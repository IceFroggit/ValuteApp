package com.example.valuteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valuteapp.databinding.ListItemBinding

class HumanAdapter: RecyclerView.Adapter<HumanAdapter.HumanViewHolder>(){
    val people = ArrayList<Human>()
    class HumanViewHolder(item: View):RecyclerView.ViewHolder(item){
        val binding = ListItemBinding.bind(item)

        fun bind(human: Human) = with(binding){
            imageView2.setImageResource(human.imageId)
            tvID.text = human.id.toString()
            tvname.text = human.name
            tvemail.text = human.mail
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return HumanViewHolder(view)
    }

    override fun onBindViewHolder(holder: HumanViewHolder, position: Int) {
        holder.bind(people[position])
    }

    override fun getItemCount(): Int {
        return people.size
    }

    fun addHuman(human: Human){
        people.add(human)
        notifyDataSetChanged()
    }
}