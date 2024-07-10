package lc.wise.finenancer.data

import lc.wise.finenancer.domain.entities.Asset
import lc.wise.finenancer.domain.entities.Cash
import lc.wise.finenancer.domain.entities.Currency
import lc.wise.finenancer.domain.entities.Stock
import java.util.Date

object StubData {
    var currencyList: MutableList<Currency> = mutableListOf(
        Currency(1, "USD"),
        Currency(2, "BYN"),
        Currency(3, "EUR"),
        Currency(4, "RUB")
    )

    var assetList: MutableList<Asset> = mutableListOf(
        Asset(1, "GazProm", 23_673_512_900.0),
        Asset(2, "Sber", 21_586_948_000.0),
        Asset(3, "Google", 515_922_000.0),
        Asset(4, "Apple", 16_000_000_000.0)
    )

    var portfolioCashList: MutableList<Cash> = mutableListOf(
        Cash(1, "USD", 100.0, 1.0, "USD", Date())
    )

    var portfolioStockList: MutableList<Stock> = mutableListOf(
        Stock(1, "GazProm", 23_673_512_900.0, 2.0, 10_000.0, "RUB", Date())
    )
}
