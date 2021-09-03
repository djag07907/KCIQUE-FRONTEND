package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

class PaymentMethodDataCollection:ArrayList<PaymentMethodDataCollectionItem>()

data class PaymentMethodDataCollectionItem(
    val paymentMethodId:Long,
    val customerDni:String="",
    val transactionId:Int,
    val paymentName:String=""
)