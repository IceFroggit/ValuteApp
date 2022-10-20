
package com.example.valuteapp


import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.valuteapp.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

@Suppress("DEPRECATION", "DEPRECATION")
class MainActivity : AppCompatActivity() {
    private val URLstring = "https://www.cbr.ru/currency_base/daily/"
    lateinit var doc: Document
    private var valutes: ArrayList<Valute> = ArrayList<Valute>()
    lateinit var valuteChildren: Elements
    lateinit private var binding: ActivityMainBinding
    private var imageIdList = listOf(
        R.drawable.australia,
        R.drawable.azerbaijan,
        R.drawable.armenia,
        R.drawable.belarus,
        R.drawable.bulgaria,
        R.drawable.brazil
    )
    private var index = 0
    lateinit var recyclerView: RecyclerView
    private val adapter: ValuteAdapter = ValuteAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        recyclerView = findViewById<RecyclerView>(R.id.recView)
        init()
        /*var progressBar = findViewById<ProgressBar>(R.id.progessBar)
        progressBar.visibility = View.VISIBLE
        progressBar.visibility = View.GONE*/
        var getq: getQuest = getQuest()
        getq.execute()

    }

    private fun init() {
        binding.apply {
            recView.layoutManager = LinearLayoutManager(this@MainActivity)
            recView.adapter = adapter
        }
    }
    @Suppress("DEPRECATION")
    internal inner class getQuest : AsyncTask<Void, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Void?): String? {
            doc = Jsoup.connect(URLstring).get()
            val table: Elements = doc.getElementsByTag("tbody")
            val ourTable: Element = table.get(0)
            val elementsFromTable: Elements = ourTable.children()
            val valute: Element = elementsFromTable.get(1)
            valuteChildren = elementsFromTable
            Log.d("MyLog", "Valute :" + valute.text())
            return ""
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val end = valuteChildren.size
            for (i in 1 until end) {
                //Log.d("MyLog","Tbody size :"+ elementsFromTable.get(i).text())
                val valuteItem = valuteChildren.get(i).children()
                val valute = Valute(
                    imageIdList[index],
                    valuteItem.get(0).text(),
                    valuteItem.get(1).text(),
                    valuteItem.get(2).text().toInt(),
                    valuteItem.get(3).text(),
                    valuteItem.get(4).text().replace(',', '.', false).toDouble()

                )
                index = (index + 1) % imageIdList.size
                valutes.add(valute)
                adapter.addValute(valute)
            }
        }
    }
}




