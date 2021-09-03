package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

class OrderDataCollection: ArrayList<OrderDataCollectionItem>()

data class OrderDataCollectionItem(
    val orderId:Long=0,
    val itemId:Int,
    val itemAmount:Int,
    val shopId:Int,
    val customerDni:String="",
    val orderStatusName:String="",
    val orderName:String="",
    val orderTotalTopay:Int,
    val isvType:Double,
    val isvAmount:Double,
    val orderDate:String="",
    val deliveryPrice:Double,
    val customerAddress:String=""
)