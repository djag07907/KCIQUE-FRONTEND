package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.bakery

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.R
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.bakery.bakeryproducts.ProductsBakeryBasiliosActivity

class BakeryAdapter: RecyclerView.Adapter<BakeryAdapter.ViewHolder>() {
    private val bakery = arrayOf(
        "Salmans",
        "Reposteria OM",
        "Gennies",
        "Basilio's",
        "Pan y Mas"
    )

    private val details = arrayOf(
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM"

    )
    private val images = intArrayOf(
        R.drawable.basilios,
        R.drawable.gennies,
        R.drawable.om,
        R.drawable.pan_y_mas,
        R.drawable.salmans
    )
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardbakery_layout,viewGroup, false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var bakeryImage: ImageView
        var bakeryName: TextView
        var bakeryDetail: TextView
        init {
            bakeryImage = itemView.findViewById(R.id.bakery_image)
            bakeryName = itemView.findViewById(R.id.bakery_name)
            bakeryDetail = itemView.findViewById(R.id.bakery_detail)


            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v,"Click en el item $position",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bakeryName.text = bakery[position]
        viewHolder.bakeryDetail.text = details[position]
        viewHolder.bakeryImage.setImageResource(images[position])

        /// Esto codigo de abajo fue el unico cambio que hice
        viewHolder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, ProductsBakeryBasiliosActivity::class.java)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return bakery.size
    }
}