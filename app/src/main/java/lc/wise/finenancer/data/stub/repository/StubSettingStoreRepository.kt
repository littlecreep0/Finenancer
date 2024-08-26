package lc.wise.finenancer.data.stub.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.repository.SettingStoreRepository

class StubSettingStoreRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : SettingStoreRepository {

    private val key = stringPreferencesKey("default_currency")

    override suspend fun getDefaultCurrency(): Flow<String> {
        return withContext(Dispatchers.IO) {
            dataStore.data.map { settings ->
                settings[key]
                    ?: StubData.currencyList.firstOrNull()?.currencyName.orEmpty()
            }
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
