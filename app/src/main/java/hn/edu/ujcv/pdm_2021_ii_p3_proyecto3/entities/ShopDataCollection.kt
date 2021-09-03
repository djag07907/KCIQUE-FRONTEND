package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

class ShopDataCollection : ArrayList<ShopDataCollectionItem>()

data class ShopDataCollectionItem(
    val shopId:Long = 0,
    val nombre:String="",
    val photo_url:String="",
    val cover_url:String="",
    val city:String="",
    val localePhoneNumber:Int,
    val place_id:Int,
    val opening_time: String="08:00",
    val closing_time: String="20:00",
    val id_delete:Boolean=false
)