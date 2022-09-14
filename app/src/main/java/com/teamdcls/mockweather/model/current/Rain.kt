package com.teamdcls.mockweather.model.current

import com.google.gson.annotations.SerializedName


data class Rain (

  @SerializedName("Value"    ) var Value    : Double?    = null,
  @SerializedName("Unit"     ) var Unit     : String? = null,
  @SerializedName("UnitType" ) var UnitType : Int?    = null

)