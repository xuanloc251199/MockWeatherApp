package com.teamdcls.mockweather.model.current

import com.google.gson.annotations.SerializedName
import com.teamdcls.mockweather.model.current.Maximum
import com.teamdcls.mockweather.model.current.Minimum


data class RealFeelTemperature (

  @SerializedName("Minimum" ) var Minimum : Minimum? = Minimum(),
  @SerializedName("Maximum" ) var Maximum : Maximum? = Maximum()

)