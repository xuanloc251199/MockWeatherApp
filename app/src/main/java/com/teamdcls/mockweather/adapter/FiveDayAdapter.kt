//package com.teamdcls.mockweather.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.teamdcls.mockweather.databinding.FragmentDailyWeatherBinding
//import com.teamdcls.mockweather.databinding.ItemDailyWeatherBinding
//import com.teamdcls.mockweather.databinding.SomeCitiesBinding
//import com.teamdcls.mockweather.model.current.CurrentWeather
//
//class FiveDayAdapter :
//    RecyclerView.Adapter<FiveDayAdapter.ViewHolder>() {
//    private var list: ArrayList<CurrentWeather> = arrayListOf()
//    var onClickItem: ((CurrentWeather) -> Unit)? = null
//
//    inner class ViewHolder( val view: ItemDailyWeatherBinding) :
//        RecyclerView.ViewHolder(view.root) {
//        fun onBind(currentWeather: CurrentWeather) {
//            view.dailyWeather = currentWeather
//            view.executePendingBindings()
//        }
//    }
//
//    fun submitData(currentWeatherData: ArrayList<CurrentWeather>) {
//        list.clear()
//        list = currentWeatherData
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            ItemDailyWeatherBinding.inflate(
//                LayoutInflater.from(parent.context), parent, false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        list[position].let {
//            holder.onBind(it)
//        }
//    }
//
//    override fun getItemCount(): Int = list.size
//}