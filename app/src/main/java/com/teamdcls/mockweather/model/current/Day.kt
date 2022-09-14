package com.teamdcls.mockweather.model.current

import com.google.gson.annotations.SerializedName


data class Day (

  @SerializedName("Icon"                     ) var Icon                     : Int?                = null,
  @SerializedName("IconPhrase"               ) var IconPhrase               : String?             = null,
  @SerializedName("HasPrecipitation"         ) var HasPrecipitation         : Boolean?            = null,
  @SerializedName("PrecipitationType"        ) var PrecipitationType        : String?             = null,
  @SerializedName("PrecipitationIntensity"   ) var PrecipitationIntensity   : String?             = null,
  @SerializedName("ShortPhrase"              ) var ShortPhrase              : String?             = null,
  @SerializedName("LongPhrase"               ) var LongPhrase               : String?             = null,
  @SerializedName("PrecipitationProbability" ) var PrecipitationProbability : Int?                = null,
  @SerializedName("ThunderstormProbability"  ) var ThunderstormProbability  : Int?                = null,
  @SerializedName("RainProbability"          ) var RainProbability          : Int?                = null,
  @SerializedName("SnowProbability"          ) var SnowProbability          : Int?                = null,
  @SerializedName("IceProbability"           ) var IceProbability           : Int?                = null,
  @SerializedName("Wind"                     ) var Wind                     : Wind?               = Wind(),
  @SerializedName("WindGust"                 ) var WindGust                 : WindGust?           = WindGust(),
  @SerializedName("TotalLiquid"              ) var TotalLiquid              : TotalLiquid?        = TotalLiquid(),
  @SerializedName("Rain"                     ) var Rain                     : Rain?               = Rain(),
  @SerializedName("Snow"                     ) var Snow                     : Snow?               = Snow(),
  @SerializedName("Ice"                      ) var Ice                      : Ice?                = Ice(),
  @SerializedName("HoursOfPrecipitation"     ) var HoursOfPrecipitation     : Int?                = null,
  @SerializedName("HoursOfRain"              ) var HoursOfRain              : Int?                = null,
  @SerializedName("HoursOfSnow"              ) var HoursOfSnow              : Int?                = null,
  @SerializedName("HoursOfIce"               ) var HoursOfIce               : Int?                = null,
  @SerializedName("CloudCover"               ) var CloudCover               : Int?                = null,
  @SerializedName("Evapotranspiration"       ) var Evapotranspiration       : Evapotranspiration? = Evapotranspiration(),
  @SerializedName("SolarIrradiance"          ) var SolarIrradiance          : SolarIrradiance?    = SolarIrradiance()

)