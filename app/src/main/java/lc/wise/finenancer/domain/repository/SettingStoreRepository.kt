package lc.wise.finenancer.domain.repository

interface SettingStoreRepository {
    suspend fun getDefaultCurrency(): String
    suspend fun setDefaultCurrency(newCurrency: String)
}
