package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

import java.math.BigInteger

class TransactionDataCollection:ArrayList<TransactionDataCollectionItem>()

data class TransactionDataCollectionItem(
    val transactionId:Long,
    val customerDni:String="",
    val customerMobile:Int,
    val paymentMethodId:Int,
    val creditcardNumber: String,
    val shopName:String="",
    val shopId:Int,
    val shopLocalePhoneNumber:Int,
    val transactionDate:String="",
    val transactionTime:String="",
    val orderId:Int,
    val totalToPay:Double,
    val isvType:Double,
    val isvAmount:Double,
    val discount:Double,
    val transactionMsg:String=""
)