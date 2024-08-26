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
    currencyId = currencyId,
    currencyName = currencyName
)

fun Currency.toCurrencyEntity() = CurrencyEntity(
    currencyId = currencyId,
    currencyName = currencyName
)

fun CountryEntity.toCountry() = Country(
    countryId = countryId,
    countryName = countryName
)

fun Country.toCountryEntity() = CountryEntity(
    countryId = countryId,
    countryName = countryName
)

fun CashEntity.toCash(
    currency: Currency
) = Asset.Cash(
    assetId = assetId,
    assetName = assetName,
    currency = currency,
    worth = worth
)

fun Asset.Cash.toCashEntity() = CashEntity(
    assetId = assetId,
    assetName = assetName,
    currencyId = currency.currencyId,
    worth = worth
)

fun StockEntity.toStock(
    currency: Currency,
    country: Country
) = Asset.Stock(
    assetId = assetId,
    assetName = assetName,
    currency = currency,
    ticker = ticker,
    country = country,
    dividends = dividends
)

fun Asset.Stock.toStockEntity() = StockEntity(
    assetId = assetId,
    assetName = assetName,
    currencyId = currency.currencyId,
    ticker = ticker,
    countryId = country.countryId,
    dividends = dividends
)

fun BondEntity.toBond(
    currency: Currency,
    country: Country
) = Asset.Bond(
    assetId = assetId,
    assetName = assetName,
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
    assetId = assetId,
    assetName = assetName,
    currencyId = currency.currencyId,
    ticker = ticker,
    countryId = country.countryId,
    fixedPayment = fixedPayment,
    maturityDateDay = maturityDate.dayOfMonth,
    maturityDateMonth = maturityDate.monthValue,
    maturityDateYear = maturityDate.year
)

fun PortfolioEntity.toPortfolio(
    assetsList: List<Asset>
) = Portfolio(
    portfolioId = portfolioId,
    portfolioName = portfolioName,
    assetsList = assetsList
)

fun Portfolio.toPortfolioEntity() = PortfolioEntity(
    portfolioId = portfolioId,
    portfolioName = portfolioName
)
