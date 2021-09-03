package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

class ItemDataCollection :ArrayList<ItemDataCollectionItem> ()

data class ItemDataCollectionItem(
    val itemId:Long=0,
    val nombre:String ="",
    val itemPrice:Double=0.0,
    val photo_url: String="",
    val category:String="",
    val shop_id:Int = 0,
    val is_available:Boolean = false
)