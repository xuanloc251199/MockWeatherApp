package com.teamdcls.mockweather.model.current

import com.google.gson.annotations.SerializedName


data class DegreeDaySummary (

  @SerializedName("Heating" ) var Heating : Heating? = Heating(),
  @SerializedName("Cooling" ) var Cooling : Cooling? = Cooling()

)