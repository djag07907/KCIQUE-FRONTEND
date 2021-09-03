package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

import java.math.BigInteger
import kotlin.collections.ArrayList

class CustomerDataCollection : ArrayList<CustomerDataCollection>()

data class CustomerDataCollectionItem(
    val id: Long?,
    val dni: String,
    val mobile: String,
    val nombre: String,
    val email: String,
    val password: String
)