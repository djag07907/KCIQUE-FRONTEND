package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import android.util.Log
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.CustomerDataCollectionItem
import okhttp3.ResponseBody
import retrofit2.http.*
import retrofit2.Call

interface CustomerService {

    @GET("customers")
    fun listCustomers(): Call<List<CustomerDataCollectionItem>>

    @GET("customers/id/{id}")
    fun getCustomerById(@Path("id") id: Long): Call<CustomerDataCollectionItem>
    @Headers("Content-Type: application/json")

    @GET("customers/nombre/{nombre}")
    fun getCustomerByName(@Path("nombre") nombre: String): Call<CustomerDataCollectionItem>
    @Headers("Content-Type: application/json")

    @POST("customers/addCustomer")
    fun addCustomer(@Body customerData: CustomerDataCollectionItem): Call<CustomerDataCollectionItem>
    @Headers("Content-Type: application/json")

    @PUT("customers")
    fun updateCustomer(@Body customerData: CustomerDataCollectionItem): Call<CustomerDataCollectionItem>

    @DELETE("customers/delete/{id}")
    fun deleteCustomer(@Path("id") id: Long): Call<ResponseBody>


}