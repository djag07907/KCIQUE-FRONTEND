package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.CustomerDataCollectionItem
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.RestApiError
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Registro"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

//        CRUD BUTTONS
//        val registerButton = findViewById<Button>(R.id.button_register)
        button_register.setOnClickListener {
            valempty()
//            callServicePostCustomer()
        }


    }
    fun valempty(){

        when{
            txt_new_id.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su Identidad / Dni", Toast.LENGTH_SHORT).show()
            txt_new_name.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su Nombre", Toast.LENGTH_SHORT).show()
            txt_new_email.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su Email", Toast.LENGTH_SHORT).show()
            txt_new_password.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su Contraseña", Toast.LENGTH_SHORT).show()
            txt_new_phone_number.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su Numero de Telefono", Toast.LENGTH_SHORT).show()
                else -> {
                    callServicePostCustomer()
                    val intent = Intent(this, LoginActivity::class.java)
                Toast.makeText(this,"Registrado exitosamete, por favor inicie sesion", Toast.LENGTH_LONG).show()
                startActivity(intent)
                }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    // Services Call

    //    Add customer method
    private fun addCustomer(customerData: CustomerDataCollectionItem, onResult: (CustomerDataCollectionItem?) -> Unit){
        val retrofit = RestEngine.buildService().create(CustomerService::class.java)
        var result: Call<CustomerDataCollectionItem> = retrofit.addCustomer(customerData)

        result.enqueue(object : Callback<CustomerDataCollectionItem> {
            override fun onResponse(
                call: Call<CustomerDataCollectionItem>,
                response: Response<CustomerDataCollectionItem>
            ) {
                if (response.isSuccessful) {
                    val addedCustomer = response.body()!!
                    onResult(addedCustomer)
                }
                else if (response.code() == 500) {
                    val errorResponse = Gson().fromJson(response.errorBody()!!.string()!!, RestApiError::class.java)

                    Toast.makeText(this@RegisterActivity,errorResponse.errorDetails, Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(this@RegisterActivity, "Fallo al traer el item", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<CustomerDataCollectionItem>, t: Throwable) {
                onResult(null)
            }
        })
    }

    //    Post Customer
    private fun callServicePostCustomer(){
        val customerInfo = CustomerDataCollectionItem( id = null,

             dni = (findViewById(R.id.txt_new_id) as EditText).getText().toString(),
             nombre = (findViewById(R.id.txt_new_name) as EditText).getText().toString(),
             email = (findViewById(R.id.txt_new_email) as EditText).getText().toString(),
             mobile = (findViewById(R.id.txt_new_phone_number) as EditText).getText().toString(),
             password = (findViewById(R.id.txt_new_password) as EditText).getText().toString()

        )
//  ^^ Agregar controllers text de captura de datos
        addCustomer(customerInfo){ if (it?.id != null){
            Toast.makeText(this@RegisterActivity, "OK"+ it.id, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this@RegisterActivity, "Error",Toast.LENGTH_LONG).show()
                }
        }

    }

}