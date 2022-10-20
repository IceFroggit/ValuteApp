package com.example.valuteapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject


class ListViewAdapter(context: Context, var listLayout: Int, field: Int, var usersList: ArrayList<JSONObject>) :
    ArrayAdapter<JSONObject?>(context, listLayout, field, usersList as List<JSONObject?>) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val listViewItem = inflater.inflate(listLayout, null, false)
        val id = listViewItem.findViewById<TextView>(R.id.tvID)
        //val name = listViewItem.findViewById<TextView>(R.id.tvName)
        //val email = listViewItem.findViewById<TextView>(R.id.tvEmail)
        try {
            id.text = usersList[position].getString("id")
            //name.text = usersList[position].getString("name")
           // email.text = usersList[position].getString("email")
        } catch (je: JSONException) {
            je.printStackTrace()
        }
        return listViewItem
    }
}