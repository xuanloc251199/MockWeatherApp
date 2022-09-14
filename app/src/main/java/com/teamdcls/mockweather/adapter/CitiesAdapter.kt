package com.teamdcls.mockweather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamdcls.mockweather.databinding.ItemCitiesBinding
import com.teamdcls.mockweather.model.CityDatabase

class CitiesAdapter : RecyclerView.Adapter<CitiesAdapter.ViewHolder>(){
    private var list = arrayListOf<CityDatabase>()
    inner class ViewHolder( val view: ItemCitiesBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun onBind(city: CityDatabase) {
            view.city = city
            view.executePendingBindings()
        }
    }

    fun submitData(cities: List<CityDatabase>) {
        list.clear()
        list.addAll(cities)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesAdapter.ViewHolder {
        return ViewHolder(
            ItemCitiesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CitiesAdapter.ViewHolder, position: Int) {
        list[position].let {
            holder.onBind(it)
        }
    }

    override fun getItemCount(): Int = list.size
}