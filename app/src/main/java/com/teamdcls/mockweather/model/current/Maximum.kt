package com.teamdcls.mockweather.model.current

import com.google.gson.annotations.SerializedName


data class Maximum (

  @SerializedName("Value"    ) var Value    : Float? = null,
  @SerializedName("Unit"     ) var Unit     : String? = null,
  @SerializedName("UnitType" ) var UnitType : Int?    = null,
  @SerializedName("Phrase"   ) var Phrase   : String? = null

)