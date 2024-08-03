package lc.wise.finenancer.data.stub

import java.util.Date
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.domain.entity.CashDetails
import lc.wise.finenancer.domain.entity.Currency
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.domain.entity.Stock
import lc.wise.finenancer.domain.entity.StockDetails

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
        Asset(4, "Apple", 16_000_000_000.0),
        Asset(5, "GazProm", 23_673_512_900.0),
        Asset(6, "Sber", 21_586_948_000.0),
        Asset(7, "Google", 515_922_000.0),
        Asset(8, "Apple", 16_000_000_000.0),
        Asset(9, "GazProm", 23_673_512_900.0),
        Asset(10, "Sber", 21_586_948_000.0),
        Asset(11, "Google", 515_922_000.0),
        Asset(12, "Apple", 16_000_000_000.0),
        Asset(13, "GazProm", 23_673_512_900.0),
        Asset(14, "Sber", 21_586_948_000.0),
        Asset(15, "Google", 515_922_000.0),
        Asset(16, "Apple", 16_000_000_000.0)
    )

    val portfolioCashList: List<Cash> = listOf(
        Cash(1, "USD", 100.0)
    )

    val CashDetailsList: List<CashDetails> = listOf(
        CashDetails(1, "USD", 100.0, 100.0, 1.0, "USD", Date())
    )

    val portfolioStockList: List<Stock> = listOf(
        Stock(1, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(2, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(3, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(4, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(5, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(6, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(7, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(8, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(9, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(10, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(11, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(12, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(13, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(14, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(15, "GazProm", 23_673_512_900.0, 20_000.0),
        Stock(16, "GazProm", 23_673_512_900.0, 20_000.0)
    )

    val StockDetailsList: List<StockDetails> = listOf(
        StockDetails(1, "GazProm", 23_673_512_900.0, 20_000.0, 2.0, 10_000.0, "RUB", Date())
    )

    val portfolioList: List<Portfolio> = listOf(
        Portfolio(1, "My Portfolio 1", portfolioCashList, portfolioStockList),
        Portfolio(2, "My Portfolio 2", portfolioCashList, portfolioStockList),
        Portfolio(3, "My Portfolio 3", portfolioCashList, portfolioStockList),
        Portfolio(4, "My Portfolio 4", portfolioCashList, portfolioStockList),
        Portfolio(5, "My Portfolio 5", portfolioCashList, portfolioStockList),
        Portfolio(6, "My Portfolio 6", portfolioCashList, portfolioStockList),
        Portfolio(7, "My Portfolio 7", portfolioCashList, portfolioStockList),
        Portfolio(8, "My Portfolio 8", portfolioCashList, portfolioStockList),
        Portfolio(9, "My Portfolio 9", portfolioCashList, portfolioStockList),
        Portfolio(10, "My Portfolio 10", portfolioCashList, portfolioStockList),
        Portfolio(11, "My Portfolio 11", portfolioCashList, portfolioStockList),
        Portfolio(12, "My Portfolio 12", portfolioCashList, portfolioStockList),
        Portfolio(13, "My Portfolio 13", portfolioCashList, portfolioStockList),
        Portfolio(14, "My Portfolio 14", portfolioCashList, portfolioStockList),
        Portfolio(15, "My Portfolio 15", portfolioCashList, portfolioStockList),
        Portfolio(16, "My Portfolio 16", portfolioCashList, portfolioStockList),
        Portfolio(17, "My Portfolio 17", portfolioCashList, portfolioStockList),
        Portfolio(18, "My Portfolio 18", portfolioCashList, portfolioStockList)
    )
    // yes, just one portfolio planned, but...
}
