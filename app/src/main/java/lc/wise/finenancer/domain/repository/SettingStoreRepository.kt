package lc.wise.finenancer.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingStoreRepository {
    suspend fun getDefaultCurrency(): Flow<String>
    suspend fun setDefaultCurrency(newCurrency: String)
}
