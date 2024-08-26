package lc.wise.finenancer.presentation.utils

import lc.wise.finenancer.domain.entity.Asset

fun Asset.Cash.toCashUI() = AssetUI.CashUI(
    id = id,
    name = name,
    currency = currency.name,
    worth = worth
)

fun Asset.Stock.toStockUI() = AssetUI.StockUI(
    id = id,
    name = name,
    currency = currency.name,
    ticker = ticker,
    country = country.name,
    dividends = dividends
)

fun Asset.Bond.toBondUI() = AssetUI.BondUI(
    id = id,
    name = name,
    currency = currency.name,
    ticker = ticker,
    country = country.name,
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
