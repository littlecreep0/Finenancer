package lc.wise.finenancer.data.stub

import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.domain.entity.CashDetails
import lc.wise.finenancer.domain.entity.Currency
import lc.wise.finenancer.domain.entity.Stock
import lc.wise.finenancer.domain.entity.StockDetails
import java.util.Date

object StubData {
    val currencyList: List<Currency> = listOf(
        Currency(1, "USD"),
        Currency(2, "BYN"),
        Currency(3, "EUR"),
        Currency(4, "RUB")
    )

    val assetList: List<Asset> = listOf(
        Asset(1, "GazProm", 23_673_512_900.0),
        Asset(2, "Sber", 21_586_948_000.0),
        Asset(3, "Google", 515_922_000.0),
        Asset(4, "Apple", 16_000_000_000.0)
    )

    val portfolioCashList: List<Cash> = listOf(
        Cash(1, "USD", 100.0)
    )

    val CashDetailsList: List<CashDetails> = listOf(
        CashDetails(1, "USD", 100.0, 100.0, 1.0, "USD", Date())
    )

    val portfolioStockList: List<Stock> = listOf(
        Stock(1, "GazProm", 23_673_512_900.0, 20_000.0)
    )

    val StockDetailsList: List<StockDetails> = listOf(
        StockDetails(1, "GazProm", 23_673_512_900.0, 20_000.0, 2.0, 10_000.0, "RUB", Date())
    )
}
