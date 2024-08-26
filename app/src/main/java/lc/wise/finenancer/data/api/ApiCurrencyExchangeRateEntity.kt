package lc.wise.finenancer.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiCurrencyExchangeRateEntity(
    @SerialName("Cur_ID")
    val id: Int,

    @SerialName("Date")
    val date: String,

    @SerialName("Cur_Abbreviation")
    val abbreviation: String,

    @SerialName("Cur_Name")
    val name: String,

    @SerialName("Cur_Scale")
    val scale: Int,

    @SerialName("Cur_OfficialRate")
    val rate: Double
)
