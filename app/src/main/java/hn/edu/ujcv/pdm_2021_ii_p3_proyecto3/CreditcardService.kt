package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import retrofit2.Call
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.AddressDataCollectionItem
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.CreditcardDataCollectionItem
import okhttp3.ResponseBody
import retrofit2.http.*


interface CreditcardService {

    @GET("creditcards")
    fun listCreditcards(): Call<List<CreditcardDataCollectionItem>>

    @GET("creditcards/id/{id}")
    fun getCreditcardsById(@Path("id") idCreditcard: Long): Call<CreditcardDataCollectionItem>
    @Headers("Content-Type: application/json")

    @GET("creditcards/nametag/{nametag}")
    fun getCreditcardsByNameTag(@Path("nametag") nametagCreditcard: String): Call<CreditcardDataCollectionItem>
    @Headers("Content-Type: application/json")

//    @GET("creditcards/customerdni/{customerdni}")
//    fun getCreditcardsByCustomerDni(@Path("customerdni") customerDni: Int): Call<CreditcardDataCollectionItem>
//    @Headers("Content-Type: application/json")

    @POST("creditcards/addCreditcard")
    fun addCreditcard(@Body creditcardData: CreditcardDataCollectionItem): Call<CreditcardDataCollectionItem>
    @Headers("Content-Type: application/json")

    @PUT("creditcards")
    fun updateCreditcard(@Body creditcardData: CreditcardDataCollectionItem): Call<CreditcardDataCollectionItem>

    @DELETE("creditcards/delete/{id}")
    fun deleteCreditcard(@Path("id") idCreditcard: Long): Call<ResponseBody>
}