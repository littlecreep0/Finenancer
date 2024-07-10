package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.data.StubData
import lc.wise.finenancer.domain.entities.Cash
import lc.wise.finenancer.domain.entities.Security

interface PortfolioItemsRepositoryInterface {
    fun getCashByID(cashID: Int): Cash?
    fun getAllCashes(): MutableList<Cash>

    fun getSecurityByID(securityID: Int): Security?
    fun getAllSecurities(): MutableList<Security>
}

class PortfolioItemsRepository: PortfolioItemsRepositoryInterface{
    override fun getCashByID(cashID: Int): Cash? {
        return StubData.portfolioCashList.find { it.id == cashID }
    }

    override fun getAllCashes(): MutableList<Cash> {
        return StubData.portfolioCashList
    }

    override fun getSecurityByID(securityID: Int): Security? {
        return StubData.portfolioSecurityList.find { it.id == securityID }
    }

    override fun getAllSecurities(): MutableList<Security> {
        return StubData.portfolioSecurityList
    }
}
