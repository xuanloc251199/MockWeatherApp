package com.teamdcls.mockweather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamdcls.mockweather.databinding.SomeCitiesBinding
import com.teamdcls.mockweather.model.Cities

class RecyclerViewSearchCityAdapter :
    RecyclerView.Adapter<RecyclerViewSearchCityAdapter.ViewHolder>() {
    private var list: ArrayList<Cities> = arrayListOf()
    var onClickItem: ((Cities) -> Unit)? = null

    inner class ViewHolder( val view: SomeCitiesBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun onBind(city: Cities) {
            view.city = city
            view.executePendingBindings()
        }
    }

    fun submitData(cities: ArrayList<Cities>) {
        list.clear()
        list = cities
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SomeCitiesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list[position].let {
            holder.onBind(it)
            holder.view.addToDb.setOnClickListener { _ ->
                onClickItem?.invoke(it)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}