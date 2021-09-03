package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.RestApiError
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.ShopDataCollectionItem
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
    }

//    Services Call
//    Get Shops
    private fun callServiceGetShops(){
        val shopService: ShopService = RestEngine.buildService().create(ShopService::class.java)
        var result: Call<List<ShopDataCollectionItem>> = shopService.listShops()

        result.enqueue(object : Callback<List<ShopDataCollectionItem>> {
            override fun onFailure(call: Call<List<ShopDataCollectionItem>>, t: Throwable) {
                Toast.makeText(this@ShopActivity, "Error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<ShopDataCollectionItem>>,
                response: Response<List<ShopDataCollectionItem>>
            ) {
                Toast.makeText(this@ShopActivity, "Ok"+response.body()!!.get(0).shopId,Toast.LENGTH_LONG)
            }
        })
    }

//    Get Shop by Id
    private fun callServiceGetShop(){
        val shopService:ShopService = RestEngine.buildService().create(ShopService::class.java)
//        Hacer get de entry, aqui esta en hardcoded/quemado
        var result: Call<ShopDataCollectionItem> = shopService.getShopByRegId(1)

        result.enqueue(object : Callback<ShopDataCollectionItem>{
            override fun onFailure(call: Call<ShopDataCollectionItem>, t: Throwable) {
                Toast.makeText(this@ShopActivity, "Error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<ShopDataCollectionItem>,
                response: Response<ShopDataCollectionItem>
            ) {
                Toast.makeText(this@ShopActivity, "OK"+response.body()!!.shopId,Toast.LENGTH_LONG).show()
            }
        })
    }

//    Add shop method
    fun addShop(shopData: ShopDataCollectionItem, onResult: (ShopDataCollectionItem?) -> Unit){
        val retrofit = RestEngine.buildService().create(ShopService::class.java)
        var result: Call<ShopDataCollectionItem> = retrofit.addShop(shopData)

        result.enqueue(object : Callback<ShopDataCollectionItem>{
            override fun onResponse(
                call: Call<ShopDataCollectionItem>,
                response: Response<ShopDataCollectionItem>
            ) {
                if (response.isSuccessful) {
                    val addedShop = response.body()!!
                    onResult(addedShop)
                }
                else if (response.code() == 500) {
                    val errorResponse = Gson().fromJson(response.errorBody()!!.string()!!, RestApiError::class.java)

                    Toast.makeText(this@ShopActivity,errorResponse.errorDetails, Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(this@ShopActivity, "Fallo al traer el item", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ShopDataCollectionItem>, t: Throwable) {
                onResult(null)
            }
        })
    }

//    Post Shop
    private fun callServicePostShop(){
    val shopInfo = ShopDataCollectionItem( shopId = 0,

         nombre = findViewById(R.id.txt_new_id),
         photo_url = findViewById(R.id.txt_new_id),
         cover_url = findViewById(R.id.txt_new_id),
         city = findViewById(R.id.txt_new_id),
         localePhoneNumber = findViewById(R.id.txt_new_id),
         place_id = findViewById(R.id.txt_new_id),
         opening_time = findViewById(R.id.txt_new_id),
         closing_time = findViewById(R.id.txt_new_id),
        )
//  ^^ Agregar controllers text de captura de datos

        addShop(shopInfo){ if (it?.shopId != null){
            Toast.makeText(this@ShopActivity, "OK"+it?.shopId, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this@ShopActivity, "Error",Toast.LENGTH_LONG).show()
         }
    }


    }

//    Put Shop
    private fun callServicePutShop(){
        val shopInfo = ShopDataCollectionItem(shopId = 0,

            nombre = findViewById(R.id.txt_new_id),
            photo_url = findViewById(R.id.txt_new_id),
            cover_url = findViewById(R.id.txt_new_id),
            city = findViewById(R.id.txt_new_id),
            localePhoneNumber = findViewById(R.id.txt_new_id),
            place_id = findViewById(R.id.txt_new_id),
            opening_time = findViewById(R.id.txt_new_id),
            closing_time = findViewById(R.id.txt_new_id),
        )
    val retrofit = RestEngine.buildService().create(ShopService::class.java)
    var result: Call<ShopDataCollectionItem> = retrofit.updateShop(shopInfo)

    result.enqueue(object : Callback<ShopDataCollectionItem> {
        override fun onResponse(
            call: Call<ShopDataCollectionItem>,
            response: Response<ShopDataCollectionItem>
        ) {
            if (response.isSuccessful) {
                val updatedShop = response.body()!!
                Toast.makeText(this@ShopActivity, "OK"+response.body()!!.nombre,Toast.LENGTH_LONG).show()
            }
            else if (response.code() == 401){
                Toast.makeText(this@ShopActivity,"Sesion Expirada", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this@ShopActivity, "Fallo al traer el item", Toast.LENGTH_LONG).show()
            }
        }

        override fun onFailure(call: Call<ShopDataCollectionItem>, t: Throwable) {
            Toast.makeText(this@ShopActivity, "Error", Toast.LENGTH_LONG).show()
        }

    })
    }

//    Delete Shop
    private fun callServiceDeleteShop(){
        val shopService:ShopService = RestEngine.buildService().create(ShopService::class.java)
        var result: Call<ResponseBody> = shopService.deleteShop(14)

        result.enqueue(object: Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@ShopActivity, "DELETE", Toast.LENGTH_LONG).show()
                }
                else if (response.code() == 401) {
                    Toast.makeText(this@ShopActivity, "Sesion expirada", Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(this@ShopActivity, "Fallo al traer el item", Toast.LENGTH_LONG).show()
                }
             }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@ShopActivity, "Error", Toast.LENGTH_LONG).show()
             }

        })
    }
}