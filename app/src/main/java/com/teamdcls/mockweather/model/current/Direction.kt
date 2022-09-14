package com.teamdcls.mockweather.model.current

import com.google.gson.annotations.SerializedName


data class Direction (

  @SerializedName("Degrees"   ) var Degrees   : Int?    = null,
  @SerializedName("Localized" ) var Localized : String? = null,
  @SerializedName("English"   ) var English   : String? = null

)