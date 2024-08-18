package lc.wise.finenancer.data.stub.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.repository.SettingStoreRepository
import javax.inject.Inject

class StubSettingStoreRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : SettingStoreRepository {

    private val key = stringPreferencesKey("default_currency")

    override suspend fun getDefaultCurrency(): String {
        return withContext(Dispatchers.IO) {
            dataStore.data.map { settings ->
                settings[key]
                    ?: StubData.currencyList.firstOrNull()?.name.orEmpty()
            }.first()
        }
    }

    override suspend fun setDefaultCurrency(newCurrency: String) {
        withContext(Dispatchers.IO) {
            dataStore.edit { settings ->
                settings[key] = newCurrency
            }
        }
    }
}