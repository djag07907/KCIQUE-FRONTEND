package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.R

class ProductsTechAdapter : RecyclerView.Adapter<ProductsTechAdapter.ViewHolder>(){

    private val products = arrayOf(
        "Producto 1",
        "Producto 2",
        "Producto 3",
        "Producto 4",
        "Producto 5"
    )

    private val products_details = arrayOf(
        "Manzanas",
        "Peras",
        "Melones",
        "Nances",
        "Mangos"

    )
    private val products_images = intArrayOf(
        R.drawable.restaurant,
        R.drawable.restaurant,
        R.drawable.restaurant,
        R.drawable.restaurant,
        R.drawable.restaurant
    )
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout_products,viewGroup, false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var productsImage: ImageView
        var productsName: TextView
        var productsDetail: TextView
        init {
            productsImage = itemView.findViewById(R.id.product_image)
            productsName = itemView.findViewById(R.id.product_name)
            productsDetail = itemView.findViewById(R.id.product_detail)

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