package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

class OrderStatusDataCollection:ArrayList<OrderStatusDataCollectionItem>()

data class OrderStatusDataCollectionItem(
    val orderId:Long,
    val orderStatusId:Int,
    val orderStatusName:String="",
    val orderStatusMsg:String=""
)