package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

class SellerDataCollection:ArrayList<SellerDataCollectionItem>()

data class SellerDataCollectionItem(
    val sellerId:Long,
    val userId:Int,
    val orderId:Int,
    val shopId:Int,
    val sellerName:String=""
)