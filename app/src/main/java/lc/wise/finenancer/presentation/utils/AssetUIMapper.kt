package lc.wise.finenancer.presentation.utils

import lc.wise.finenancer.domain.entity.Asset

fun Asset.Cash.toCashUI() = AssetUI.CashUI(
    assetId = assetId,
    assetName = assetName,
    currency = currency.currencyName,
    worth = worth
)

fun Asset.Stock.toStockUI() = AssetUI.StockUI(
    assetId = assetId,
    assetName = assetName,
    currency = currency.currencyName,
    ticker = ticker,
    country = country.countryName,
    dividends = dividends
)

fun Asset.Bond.toBondUI() = AssetUI.BondUI(
    assetId = assetId,
    assetName = assetName,
    currency = currency.currencyName,
    ticker = ticker,
    country = country.countryName,
    fixedPayment = fixedPayment,
    maturityDateDay = maturityDate.dayOfMonth,
    maturityDateMonth = maturityDate.monthValue,
    maturityDateYear = maturityDate.year
)

fun Asset.toAssetUI(): AssetUI =
    when (this) {
        is Asset.Cash -> this.toCashUI()
        is Asset.Stock -> this.toStockUI()
        is Asset.Bond -> this.toBondUI()
    }

fun List<Asset>.toAssetUIList(): List<AssetUI> = this.map { it.toAssetUI() }
