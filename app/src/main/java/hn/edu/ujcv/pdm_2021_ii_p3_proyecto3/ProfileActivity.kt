package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.AddressDataCollectionItem
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.RestApiError
import kotlinx.android.synthetic.main.activity_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Mi Perfil"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        button_paymentmethods.setOnClickListener { paymentmethods() }
        button_myadresses.setOnClickListener { myadresses() }
    }

    private fun myadresses() {
        val intent = Intent(this, AddressActivity::class.java)
        startActivity(intent)
    }

    private fun paymentmethods() {
        val intent = Intent(this, CreditCardFormActivity::class.java)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    // Services Call
//    Get Addresses
    private fun callServiceGetAddresses(){
        val addressService: AddressService = RestEngine.buildService().create(AddressService::class.java)
        var result: Call<List<AddressDataCollectionItem>> = addressService.listAddressess()

        result.enqueue(object : Callback<List<AddressDataCollectionItem>> {
            override fun onFailure(call: Call<List<AddressDataCollectionItem>>, t: Throwable) {
                Toast.makeText(this@ProfileActivity, "Error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<AddressDataCollectionItem>>,
                response: Response<List<AddressDataCollectionItem>>
            ) {
                Toast.makeText(this@ProfileActivity, "Ok"+response.body()!!.get(0).addressId,Toast.LENGTH_LONG)
            }
        })
    }

//    Add address method
    fun addAddress(addressData: AddressDataCollectionItem, onResult: (AddressDataCollectionItem?) -> Unit){
        val retrofit = RestEngine.buildService().create(AddressService::class.java)
        var result: Call<AddressDataCollectionItem> = retrofit.addAddress(addressData)

        result.enqueue(object : Callback<AddressDataCollectionItem>{
            override fun onResponse(
                call: Call<AddressDataCollectionItem>,
                response: Response<AddressDataCollectionItem>
            ) {
                if (response.isSuccessful) {
                    val addedAddress = response.body()!!
                    onResult(addedAddress)
                }
                else if (response.code() == 500) {
                    val errorResponse = Gson().fromJson(response.errorBody()!!.string()!!, RestApiError::class.java)

                    Toast.makeText(this@ProfileActivity,errorResponse.errorDetails, Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(this@ProfileActivity, "Fallo al traer el item", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<AddressDataCollectionItem>, t: Throwable) {
                onResult(null)
            }
        })
    }

//    Post Address (TO BE WELL DEFINED)
    private fun callServicePostAddress(){
    val addressInfo = AddressDataCollectionItem(addressId = 1,

         country = findViewById(R.id.txt_new_id),
         department = findViewById(R.id.txt_new_id),
         city = findViewById(R.id.txt_new_id),
         postalCode = findViewById(R.id.txt_new_id),
         streetName = findViewById(R.id.txt_new_id),
         houseNumber = findViewById(R.id.txt_new_id),
        )
//  ^^ Agregar controllers text de captura de datos

        addAddress(addressInfo){ if (it?.addressId != null){
            Toast.makeText(this@ProfileActivity, "OK"+it?.addressId, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this@ProfileActivity, "Error",Toast.LENGTH_LONG).show()
         }
    }


    }

//    Put Address (TO BE WELL DEFINED)
    private fun callServicePutAddress(){
        val addressInfo = AddressDataCollectionItem(addressId = 1,

            country = findViewById(R.id.txt_new_id),
            department = findViewById(R.id.txt_new_id),
            city = findViewById(R.id.txt_new_id),
            postalCode = findViewById(R.id.txt_new_id),
            streetName = findViewById(R.id.txt_new_id),
            houseNumber = findViewById(R.id.txt_new_id),
        )
    val retrofit = RestEngine.buildService().create(AddressService::class.java)
    var result: Call<AddressDataCollectionItem> = retrofit.updateAddress(addressInfo)

    result.enqueue(object : Callback<AddressDataCollectionItem> {
        override fun onResponse(
            call: Call<AddressDataCollectionItem>,
            response: Response<AddressDataCollectionItem>
        ) {
            if (response.isSuccessful) {
                val updatedAddress = response.body()!!
                Toast.makeText(this@ProfileActivity, "OK"+response.body()!!.addressId,Toast.LENGTH_LONG).show()
            }
            else if (response.code() == 401){
                Toast.makeText(this@ProfileActivity,"Sesion Expirada", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this@ProfileActivity, "Fallo al traer el item", Toast.LENGTH_LONG).show()
            }
        }

        override fun onFailure(call: Call<AddressDataCollectionItem>, t: Throwable) {
            Toast.makeText(this@ProfileActivity, "Error", Toast.LENGTH_LONG).show()
        }

    })
    }
}