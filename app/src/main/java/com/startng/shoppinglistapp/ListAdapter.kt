package com.startng.shoppinglistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_view.view.*

class ListAdapter (var items : ArrayList<Lists>, var clickListener: OnListItemClickListener) : RecyclerView.Adapter<ListViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        lateinit var listViewHolder: ListViewHolder
        listViewHolder = ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view,parent, false))
        return listViewHolder

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       // holder.ListName?.text = items.get(position).name
        //holder.ListDescription?.text = items.get(position).description
        //holder.ListLogo?.setImageResource(items.get(position).logo)
        holder.initialize(items.get(position),clickListener)
    }
}

class ListViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    var ListName = itemView.listname
    var ListDescription = itemView.listdescription
    var ListLogo = itemView.listlogo

    fun initialize(item: Lists, action:OnListItemClickListener){

        ListName.text = item.name
        ListDescription.text = item.description
        ListLogo.setImageResource(item.logo)

        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }
    }
}

interface OnListItemClickListener{
    fun onItemClick(item: Lists, Position: Int)
}