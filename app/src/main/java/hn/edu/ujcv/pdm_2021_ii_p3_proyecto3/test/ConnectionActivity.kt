package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.*
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.restaurants.restaurantsproducts.ProductsActivity
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.restaurants.RestaurantActivity
import kotlinx.android.synthetic.main.activity_connection.*

class ConnectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection)

        button_shop_act.setOnClickListener{
            val intent = Intent(this, ShopActivity::class.java)
            startActivity(intent)
        }

        button_register_act.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        button_profile_act.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        button_payment_act.setOnClickListener {
            val intent = Intent(this, PaymentMethodsActivity::class.java)
            startActivity(intent)
        }
        button_main_act.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }
        button_credit_act.setOnClickListener {
            val intent = Intent(this, CreditCardFormActivity::class.java)
            startActivity(intent)
        }
        button_contact_act.setOnClickListener {
            val intent = Intent(this, ContactUsActivity::class.java)
            startActivity(intent)
        }
        button_confirm_payment_act.setOnClickListener {
            val intent = Intent(this, ConfirmPaymentActivity::class.java)
            startActivity(intent)
        }
        button_restaurants_act.setOnClickListener {
            val intent = Intent(this, RestaurantActivity::class.java)
            startActivity(intent)
        }
        button_products_act.setOnClickListener {
            val intent = Intent(this, ProductsActivity::class.java)
            startActivity(intent)
        }

        button_rating.setOnClickListener {
            val intent = Intent(this, BottomSheetRateFood::class.java)
            startActivity(intent)
        }
    }
}