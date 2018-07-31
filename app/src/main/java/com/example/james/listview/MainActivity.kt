package com.example.james.listview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewMain = findViewById<ListView>(R.id.ListView_main)


        listViewMain.adapter = MainListCustomAdapter(this)

    }


    private class MainListCustomAdapter(context: Context) : BaseAdapter() {

        private val names = arrayListOf<String>(
                "James",
                "Meg",
                "Katherine",
                "Grace",
                "Adva"
        )

        // needs context which is information what activity is currently active
        private val mContext: Context

        init {
            mContext = context

        }

        // rendering each row
        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            // layout inflator allows us to refer to layout object
            val layoutInflater = LayoutInflater.from(mContext)
            val mainRow = layoutInflater.inflate(R.layout.main_row, viewGroup, false)

            val nameTextView = mainRow.findViewById<TextView>(R.id.text_view_name)
            nameTextView.text = "Name: ${names[position]}"

            val descriptionTextView = mainRow.findViewById<TextView>(R.id.text_view_description)
            descriptionTextView.text = "Row number: $position"

            return mainRow

        }

        override fun getItem(p0: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        // responsible for how many rows in list
        override fun getCount(): Int {
            return names.size
        }

    }

}


