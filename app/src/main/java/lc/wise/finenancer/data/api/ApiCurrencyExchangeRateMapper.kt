package lc.wise.finenancer.data.api

import lc.wise.finenancer.domain.entity.CurrencyExchangeRate

class ApiCurrencyExchangeRateMapper {
    fun fromEntity(entity: ApiCurrencyExchangeRateEntity): CurrencyExchangeRate {
        return CurrencyExchangeRate(
            id = entity.id,
            date = entity.date,
            abbreviation = entity.abbreviation,
            name = entity.name,
            scale = entity.scale,
            rate = entity.rate
        )
    }
}
