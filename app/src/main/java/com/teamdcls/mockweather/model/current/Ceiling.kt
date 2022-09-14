package com.teamdcls.mockweather.model.current

import com.google.gson.annotations.SerializedName


data class Ceiling (

    @SerializedName("Value"    ) var Value    : Int?    = null,
    @SerializedName("Unit"     ) var Unit     : String? = null,
    @SerializedName("UnitType" ) var UnitType : Int?    = null

)
