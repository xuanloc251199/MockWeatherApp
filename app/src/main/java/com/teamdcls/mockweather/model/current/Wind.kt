package com.teamdcls.mockweather.model.current

import com.google.gson.annotations.SerializedName
import com.teamdcls.mockweather.model.current.Direction
import com.teamdcls.mockweather.model.current.Speed


data class Wind (

  @SerializedName("Speed"     ) var Speed     : Speed?     = Speed(),
  @SerializedName("Direction" ) var Direction : Direction? = Direction()

)