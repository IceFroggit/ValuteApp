package com.example.valuteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valuteapp.databinding.ListItemBinding
import com.example.valuteapp.databinding.ValuteItemBinding

class ValuteAdapter: RecyclerView.Adapter<ValuteAdapter.ValuteViewHolder>(){
    val valutes = ArrayList<Valute>()
    class ValuteViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ValuteItemBinding.bind(item)


        fun bind(valute: Valute) = with(binding){
            imageView2.setImageResource(valute.Image)
            tvData1.text = valute.charCode
            tvData2.text = valute.cnt.toString()
            tvData3.text = valute.name
            tvData4.text = String.format("%.2f",valute.course)+"₽";
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValuteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.valute_item, parent, false)
        return ValuteViewHolder(view)
    }

    override fun onBindViewHolder(holder: ValuteViewHolder, position: Int) {
        holder.bind(valutes[position])
    }

    override fun getItemCount(): Int {
        return valutes.size
    }

    fun addValute(valute: Valute){
        valutes.add(valute)
        notifyDataSetChanged()
    }
}