package com.teamdcls.mockweather.model.current

import com.google.gson.annotations.SerializedName

data class Visibility (

    @SerializedName("Value"    ) var Value    : Double? = null,
    @SerializedName("Unit"     ) var Unit     : String? = null,
    @SerializedName("UnitType" ) var UnitType : Int?    = null

)
