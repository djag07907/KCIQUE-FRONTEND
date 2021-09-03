package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.gson.Gson
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.bakery.BakeryActivity
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.databinding.ActivityMainMenuBinding
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.CustomerDataCollectionItem
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.RestApiError
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.forhome.ForhomeActivity
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.restaurants.RestaurantActivity
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.tech.TechActivity
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Inicio"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main_menu)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

//        ImageHandlers

        imageFFood.setOnClickListener{
            val intent = Intent(this, RestaurantActivity::class.java)
            startActivity(intent)
        }
        imageBakery.setOnClickListener{
            val intent = Intent(this, BakeryActivity::class.java)
            startActivity(intent)
        }
        imageHome.setOnClickListener{
            val intent = Intent(this, ForhomeActivity::class.java)
            startActivity(intent)
        }
        imageTechnology.setOnClickListener{
            val intent = Intent(this, TechActivity::class.java)
            startActivity(intent)
        }

        profileButton.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


// Services Call
//    Get Customers
//    private fun callServiceGetCustomers(){
//        val customerService: CustomerService = RestEngine.buildService().create(CustomerService::class.java)
//        var result: Call<List<CustomerDataCollectionItem>> = customerService.listCustomers()
//
//        result.enqueue(object : Callback<List<CustomerDataCollectionItem>> {
//            override fun onFailure(call: Call<List<CustomerDataCollectionItem>>, t: Throwable) {
//                Toast.makeText(this@MainMenuActivity, "Error", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(
//                call: Call<List<CustomerDataCollectionItem>>,
//                response: Response<List<CustomerDataCollectionItem>>
//            ) {
//                Toast.makeText(this@MainMenuActivity, "Ok"+response.body()!!.get(0).nombre,Toast.LENGTH_LONG)
//            }
//        })
//    }

//    Get Customer by Id

//    private fun callServiceGetCustomer(){
//        val customerService:CustomerService = RestEngine.buildService().create(CustomerService::class.java)
////        Hacer get de entry, aqui esta en hardcoded/quemado
//        var result: Call<CustomerDataCollectionItem> = customerService.getCustomerById(1)
//
//        result.enqueue(object : Callback<CustomerDataCollectionItem>{
//            override fun onFailure(call: Call<CustomerDataCollectionItem>, t: Throwable) {
//                Toast.makeText(this@MainMenuActivity, "Error", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(
//                call: Call<CustomerDataCollectionItem>,
//                response: Response<CustomerDataCollectionItem>
//            ) {
//                Toast.makeText(this@MainMenuActivity, "OK"+response.body()!!.nombre,Toast.LENGTH_LONG).show()
//            }
//        })
//    }

//    Add customer method
//    fun addCustomer(customerData: CustomerDataCollectionItem, onResult: (CustomerDataCollectionItem?) -> Unit){
//        val retrofit = RestEngine.buildService().create(CustomerService::class.java)
//        var result: Call<CustomerDataCollectionItem> = retrofit.addCustomer(customerData)
//
//        result.enqueue(object : Callback<CustomerDataCollectionItem>{
//            override fun onResponse(
//                call: Call<CustomerDataCollectionItem>,
//                response: Response<CustomerDataCollectionItem>
//            ) {
//                if (response.isSuccessful) {
//                    val addedCustomer = response.body()!!
//                    onResult(addedCustomer)
//                }
//                else if (response.code() == 500) {
//                    val errorResponse = Gson().fromJson(response.errorBody()!!.string()!!, RestApiError::class.java)
//
//                    Toast.makeText(this@MainMenuActivity,errorResponse.errorDetails, Toast.LENGTH_LONG).show()
//                }
//                else {
//                    Toast.makeText(this@MainMenuActivity, "Fallo al traer el item", Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<CustomerDataCollectionItem>, t: Throwable) {
//                onResult(null)
//            }
//        })
//    }

//    Post Customer
//    private fun callServicePostCustomer(){
//    val fecha = "2021-8-20"
//    val customerInfo = CustomerDataCollectionItem(null,
//        dni = 888888888888,
//        mobile = 99999999,
//        nombre = "dan",
//        email ="dan.mail@domain.com",
//        password ="dan.password"
//        )
////  ^^ Agregar controllers text de captura de datos
//
//        addCustomer(customerInfo){ if (it?.id != null){
//            Toast.makeText(this@MainMenuActivity, "OK"+it?.id, Toast.LENGTH_LONG).show()
//        } else {
//            Toast.makeText(this@MainMenuActivity, "Error",Toast.LENGTH_LONG).show()
//         }
//    }
//
//
//    }

//    Put Costumer
//    private fun callServicePutCustomer(){
//        val fecha = "2021-8-20"
//        val customerInfo = CustomerDataCollectionItem(14,
//            dni = 888888888889,
//            mobile = 99999998,
//            nombre = "dani",
//            email ="dani.mail@domain.com",
//            password ="dani.password"
//        )
//    val retrofit = RestEngine.buildService().create(CustomerService::class.java)
//    var result: Call<CustomerDataCollectionItem> = retrofit.updateCustomer(customerInfo)
//
//    result.enqueue(object : Callback<CustomerDataCollectionItem> {
//        override fun onResponse(
//            call: Call<CustomerDataCollectionItem>,
//            response: Response<CustomerDataCollectionItem>
//        ) {
//            if (response.isSuccessful) {
//                val updatedCustomer = response.body()!!
//                Toast.makeText(this@MainMenuActivity, "OK"+response.body()!!.nombre,Toast.LENGTH_LONG).show()
//            }
//            else if (response.code() == 401){
//                Toast.makeText(this@MainMenuActivity,"Sesion Expirada", Toast.LENGTH_LONG).show()
//            }
//            else {
//                Toast.makeText(this@MainMenuActivity, "Fallo al traer el item", Toast.LENGTH_LONG).show()
//            }
//        }
//
//        override fun onFailure(call: Call<CustomerDataCollectionItem>, t: Throwable) {
//            Toast.makeText(this@MainMenuActivity, "Error", Toast.LENGTH_LONG).show()
//        }
//
//    })
//    }

//    Delete Customer
//    private fun callServiceDeleteCustomer(){
//        val customerService:CustomerService = RestEngine.buildService().create(CustomerService::class.java)
//        var result: Call<ResponseBody> = customerService.deleteCustomer(14)
//
//        result.enqueue(object: Callback<ResponseBody> {
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                if (response.isSuccessful) {
//                    Toast.makeText(this@MainMenuActivity, "DELETE", Toast.LENGTH_LONG).show()
//                }
//                else if (response.code() == 401) {
//                    Toast.makeText(this@MainMenuActivity, "Sesion expirada", Toast.LENGTH_LONG).show()
//                }
//                else {
//                    Toast.makeText(this@MainMenuActivity, "Fallo al traer el item", Toast.LENGTH_LONG).show()
//                }
//             }
//
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                Toast.makeText(this@MainMenuActivity, "Error", Toast.LENGTH_LONG).show()
//             }
//
//        })
//    }
}