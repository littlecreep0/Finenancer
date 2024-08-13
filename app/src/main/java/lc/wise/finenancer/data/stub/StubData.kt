package lc.wise.finenancer.data.stub

import java.time.LocalDate
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.entity.Bond
import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.domain.entity.Currency
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.domain.entity.Stock

object StubData {

    val assetList: List<Asset> = listOf(
        Stock(1, "GazProm", Currency.RUB, "GZPR", "Russia", 23_673_512_900.0),
        Stock(2, "Sber", Currency.RUB, "SBR", "Russia", 21_586_948_000.0),
        Stock(3, "Google", Currency.USD, "GOOGL", "USA", 515_922_000.0),
        Stock(4, "Apple", Currency.USD, "APPL", "USA", 16_000_000_000.0),
        Bond(5, "GazProm", Currency.RUB, "GZPR", "Russia", 512_900.0, LocalDate.now()),
        Bond(6, "Sber", Currency.RUB, "SBR", "Russia", 948_000.0, LocalDate.now()),
        Bond(7, "Google", Currency.USD, "GOOGL", "USA", 922_000.0, LocalDate.now()),
        Bond(8, "Apple", Currency.USD, "APPL", "USA", 16_000_000.0, LocalDate.now()),
        Cash(9, "Dollars USA", Currency.USD, 2_500.00),
        Cash(10, "Euro", Currency.EUR, 12_500.00),
        Cash(11, "Belarusian Roubles", Currency.BYN, 12_500.00),
        Cash(12, "Russian Roubles", Currency.RUB, 12_500.00),
        Cash(13, "Chinese Yuan", Currency.CNY, 12_500.00)
    )

    val portfolioAssetList: List<Asset> = listOf(
        Stock(1, "GazProm", Currency.RUB, "GZPR", "Russia", 23_673_512_900.0),
        Stock(2, "Sber", Currency.RUB, "SBR", "Russia", 21_586_948_000.0),
        Stock(3, "Google", Currency.USD, "GOOGL", "USA", 515_922_000.0),
        Stock(4, "Apple", Currency.USD, "APPL", "USA", 16_000_000_000.0),
        Bond(5, "GazProm", Currency.RUB, "GZPR", "Russia", 512_900.0, LocalDate.now()),
        Bond(6, "Sber", Currency.RUB, "SBR", "Russia", 948_000.0, LocalDate.now()),
        Bond(7, "Google", Currency.USD, "GOOGL", "USA", 922_000.0, LocalDate.now()),
        Bond(8, "Apple", Currency.USD, "APPL", "USA", 16_000_000.0, LocalDate.now()),
        Cash(9, "Dollars USA", Currency.USD, 2_500.00),
        Cash(10, "Euro", Currency.EUR, 12_500.00),
        Cash(11, "Belarusian Roubles", Currency.BYN, 12_500.00),
        Cash(12, "Russian Roubles", Currency.RUB, 12_500.00),
        Cash(13, "Chinese Yuan", Currency.CNY, 12_500.00)
    )

    val portfolioList: List<Portfolio> = listOf(
        Portfolio(1, "My Portfolio 1", portfolioAssetList),
        Portfolio(2, "My Portfolio 2", portfolioAssetList),
        Portfolio(3, "My Portfolio 3", portfolioAssetList),
        Portfolio(4, "My Portfolio 4", portfolioAssetList),
        Portfolio(5, "My Portfolio 5", portfolioAssetList),
        Portfolio(6, "My Portfolio 6", portfolioAssetList),
        Portfolio(7, "My Portfolio 7", portfolioAssetList),
        Portfolio(8, "My Portfolio 8", portfolioAssetList),
        Portfolio(9, "My Portfolio 9", portfolioAssetList),
        Portfolio(10, "My Portfolio 10", portfolioAssetList),
        Portfolio(11, "My Portfolio 11", portfolioAssetList),
        Portfolio(12, "My Portfolio 12", portfolioAssetList),
        Portfolio(13, "My Portfolio 13", portfolioAssetList),
        Portfolio(14, "My Portfolio 14", portfolioAssetList),
        Portfolio(15, "My Portfolio 15", portfolioAssetList),
        Portfolio(16, "My Portfolio 16", portfolioAssetList),
        Portfolio(17, "My Portfolio 17", portfolioAssetList),
        Portfolio(18, "My Portfolio 18", portfolioAssetList)
    )
    // yes, just one portfolio planned, but...
}
