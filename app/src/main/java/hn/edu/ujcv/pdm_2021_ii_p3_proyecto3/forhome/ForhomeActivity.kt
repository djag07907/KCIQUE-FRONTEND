package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.forhome

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.R
import kotlinx.android.synthetic.main.activity_forhome.*
import kotlinx.android.synthetic.main.content_main.*

class ForhomeActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ForhomeAdapter.ViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forhome)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = " Hogar"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        forhome_toollbar.title = "Hogar"
        forhome_toollbar.setContentScrimColor(Color.DKGRAY)



        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager


        adapter = ForhomeAdapter()
        recyclerView.adapter = adapter
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}