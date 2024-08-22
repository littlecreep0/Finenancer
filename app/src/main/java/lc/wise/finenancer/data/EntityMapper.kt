package lc.wise.finenancer.data

import java.time.LocalDate
import lc.wise.finenancer.data.entity.BondEntity
import lc.wise.finenancer.data.entity.CashEntity
import lc.wise.finenancer.data.entity.CountryEntity
import lc.wise.finenancer.data.entity.CurrencyEntity
import lc.wise.finenancer.data.entity.PortfolioEntity
import lc.wise.finenancer.data.entity.StockEntity
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.entity.Country
import lc.wise.finenancer.domain.entity.Currency
import lc.wise.finenancer.domain.entity.Portfolio

fun CurrencyEntity.toCurrency() = Currency(
    id = currencyId,
    name = currencyName
)

fun Currency.toCurrencyEntity() = CurrencyEntity(
    currencyId = id,
    currencyName = name
)

fun CountryEntity.toCountry() = Country(
    id = countryId,
    name = countryName
)

fun Country.toCountryEntity() = CountryEntity(
    countryId = id,
    countryName = name
)

fun CashEntity.toCash(
    currency: Currency
) = Asset.Cash(
    id = id,
    name = name,
    currency = currency,
    worth = worth
)

fun Asset.Cash.toCashEntity() = CashEntity(
    id = id,
    name = name,
    currencyId = currency.id,
    worth = worth
)

fun StockEntity.toStock(
    currency: Currency,
    country: Country
) = Asset.Stock(
    id = id,
    name = name,
    currency = currency,
    ticker = ticker,
    country = country,
    dividends = dividends
)

fun Asset.Stock.toStockEntity() = StockEntity(
    id = id,
    name = name,
    currencyId = currency.id,
    ticker = ticker,
    countryId = country.id,
    dividends = dividends
)

fun BondEntity.toBond(
    currency: Currency,
    country: Country
) = Asset.Bond(
    id = id,
    name = name,
    currency = currency,
    ticker = ticker,
    country = country,
    fixedPayment = fixedPayment,
    maturityDate = LocalDate.of(
        maturityDateYear,
        maturityDateMonth,
        maturityDateDay
    )
)

fun Asset.Bond.toBondEntity() = BondEntity(
    id = id,
    name = name,
    currencyId = currency.id,
    ticker = ticker,
    countryId = country.id,
    fixedPayment = fixedPayment,
    maturityDateDay = maturityDate.dayOfMonth,
    maturityDateMonth = maturityDate.monthValue,
    maturityDateYear = maturityDate.year
)

fun PortfolioEntity.toPortfolio(
    assetsList: List<Asset>
) = Portfolio(
    id = id,
    name = name,
    assetsList = assetsList
)

fun Portfolio.toPortfolioEntity() = PortfolioEntity(
    id = id,
    name = name
)
