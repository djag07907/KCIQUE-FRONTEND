package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.ShopDataCollectionItem
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ShopService {

    @GET("shops")
    fun listShops(): Call<List<ShopDataCollectionItem>>

    @GET("shops/id/{id}")
    fun getShopByRegId(@Path("id") idShop: Long): Call<ShopDataCollectionItem>
    @Headers("Content-Type: application/json")

    @GET("shops/nombre/{nombre}")
    fun getShopByName(@Path("nombre") nameShop: String): Call<ShopDataCollectionItem>
    @Headers("Content-Type: application/json")

    @GET("shops/city/{city}")
    fun getShopByCity(@Path("city") cityShop: String): Call<ShopDataCollectionItem>
    @Headers("Content-Type: application/json")

    @GET("shops/localePhoneNumber/{localePhoneNumber}")
    fun getShopByLocalPhoneNumber(@Path("localePhoneNumber") localePhoneNumberShop: Int): Call<ShopDataCollectionItem>
    @Headers("Content-Type: application/json")

    @POST("shops/addShop")
    fun addShop(@Body shopData: ShopDataCollectionItem): Call<ShopDataCollectionItem>
    @Headers("Content-Type: application/json")

    @PUT("shops")
    fun updateShop(@Body shopData: ShopDataCollectionItem): Call<ShopDataCollectionItem>

    @DELETE("shops/delete/{id}")
    fun deleteShop(@Path("id") idShop: Long): Call<ResponseBody>

}