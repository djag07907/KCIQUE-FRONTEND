package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.restaurants.restaurantsproducts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.R


class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    private val products = arrayOf(
        "Pizza Pepperoni",
        "Pizza 4 Estaciones",
        "Pan de ajo"
    )

    private val products_details = arrayOf(
        "Precio L.",
        "Precio L.",
        "Precio L."

    )
    private val products_images = intArrayOf(
        R.drawable.pzzzz,
        R.drawable.pzz,
        R.drawable.pzzz
    )
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardproduct_layout,viewGroup, false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var productsImage: ImageView
        var productsName: TextView
        var productsDetail: TextView
        init {
            productsImage = itemView.findViewById(R.id.restaurantyproduct_image)
            productsName = itemView.findViewById(R.id.restaurantyproduct_name)
            productsDetail = itemView.findViewById(R.id.restaurantyproduct_detail)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v,"Click en el item $position",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.productsName.text = products[position]
        viewHolder.productsDetail.text = products_details[position]
        viewHolder.productsImage.setImageResource(products_images[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }
}
