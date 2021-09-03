package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.tech

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.R
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.products.ProductsTechActivity

class TechAdapter: RecyclerView.Adapter<TechAdapter.ViewHolder>() {
    private val techs = arrayOf(
        "Radioshack",
        "Ed Ventas",
        "Jetstereo",
        "Inversiones CZ",
        "Laptop Outlet"
    )

    private val details = arrayOf(
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM"

    )
    private val images = intArrayOf(
        R.drawable.rs,
        R.drawable.ed,
        R.drawable.jt,
        R.drawable.cz,
        R.drawable.lap
    )
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardtech_layout,viewGroup, false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var techImage: ImageView
        var techName: TextView
        var techDetail: TextView
        init {
            techImage = itemView.findViewById(R.id.tech_image)
            techName = itemView.findViewById(R.id.tech_name)
            techDetail = itemView.findViewById(R.id.tech_detail)


            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v,"Click en el item $position",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.techName.text = techs[position]
        viewHolder.techDetail.text = details[position]
        viewHolder.techImage.setImageResource(images[position])

        /// Esto codigo de abajo fue el unico cambio que hice
        viewHolder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, ProductsTechActivity::class.java)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return techs.size
    }
}