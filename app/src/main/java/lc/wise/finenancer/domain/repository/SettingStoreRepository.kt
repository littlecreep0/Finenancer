package lc.wise.finenancer.domain.repository

interface SettingStoreRepository {
    fun getDefaultCurrency(): String
    fun setDefaultCurrency(newCurrency: String)
}