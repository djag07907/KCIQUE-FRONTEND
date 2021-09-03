package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.AddressDataCollectionItem
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.RestApiError
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Mis Direcciones"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        button_myadresses.setOnClickListener{
            valempty()
        }
    }
    fun valempty(){

        when{
            txt_country.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar un País", Toast.LENGTH_SHORT).show()
            txt_departament.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar un Departamento", Toast.LENGTH_SHORT).show()
            txt_city.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su Ciudad", Toast.LENGTH_SHORT).show()
            txt_street.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su direccion de calle", Toast.LENGTH_SHORT).show()
            txt_housenumber.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su Numero de casa", Toast.LENGTH_SHORT).show()
            txt_postalcode.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su Numero postal", Toast.LENGTH_SHORT).show()
            else -> {
                callServicePostAddress()
                val intent = Intent(this, ProfileActivity::class.java)
                Toast.makeText(this,"Registrado exitosamete", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    // Services Call

    //    Add address method
    private fun addAddress(addressData: AddressDataCollectionItem, onResult: (AddressDataCollectionItem?) -> Unit){
        val retrofit = RestEngine.buildService().create(AddressService::class.java)
        var result: Call<AddressDataCollectionItem> = retrofit.addAddress(addressData)

        result.enqueue(object : Callback<AddressDataCollectionItem> {
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

                    Toast.makeText(this@AddressActivity,errorResponse.errorDetails, Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(this@AddressActivity, "Fallo al traer el item", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<AddressDataCollectionItem>, t: Throwable) {
                onResult(null)
            }
        })
    }

    //    Post address
    private fun callServicePostAddress(){
        val addressInfo = AddressDataCollectionItem( addressId = null,

            country = (findViewById(R.id.txt_country) as EditText).getText().toString(),
            department = (findViewById(R.id.txt_departament) as EditText).getText().toString(),
            city = (findViewById(R.id.txt_city) as EditText).getText().toString(),
            postalCode = (findViewById(R.id.txt_postalcode) as EditText).getText().toString(),
            houseNumber = (findViewById(R.id.txt_housenumber) as EditText).getText().toString(),
            streetName = (findViewById(R.id.txt_street) as EditText).getText().toString()

        )
//  ^^ Agregar controllers text de captura de datos
        addAddress(addressInfo){ if (it?.addressId != null){
            Toast.makeText(this@AddressActivity, "OK"+ it.addressId, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this@AddressActivity, "Error", Toast.LENGTH_LONG).show()
        }
        }

    }
}