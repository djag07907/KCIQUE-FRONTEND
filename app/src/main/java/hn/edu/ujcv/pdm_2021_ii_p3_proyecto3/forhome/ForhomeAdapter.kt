package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.forhome

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.R
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.products.ProductsForhomeActivity

class ForhomeAdapter : RecyclerView.Adapter<ForhomeAdapter.ViewHolder>() {
    private val homes = arrayOf(
        "Larach & Cia.",
        "El Titan",
        "Tiendas Centro",
        "Indufesa",
        "La mundial"
    )

    private val details = arrayOf(
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM"

    )
    private val images = intArrayOf(
        R.drawable.lara,
        R.drawable.tita,
        R.drawable.cent,
        R.drawable.indu,
        R.drawable.lamu
    )
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardforhome_layout,viewGroup, false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var homeImage: ImageView
        var homeName: TextView
        var homeDetail: TextView
        init {
            homeImage = itemView.findViewById(R.id.forhome_image)
            homeName = itemView.findViewById(R.id.forhome_name)
            homeDetail = itemView.findViewById(R.id.forhome_detail)


            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v,"Click en el item $position",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.homeName.text = homes[position]
        viewHolder.homeDetail.text = details[position]
        viewHolder.homeImage.setImageResource(images[position])

        /// Esto codigo de abajo fue el unico cambio que hice
        viewHolder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, ProductsForhomeActivity::class.java)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return homes.size
    }
}