package lc.wise.finenancer.data.stub.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.repository.SettingStoreRepository
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "settings")

class StubSettingStoreRepository @Inject constructor(
    @ApplicationContext private val context: Context
) : SettingStoreRepository {

    private val key = stringPreferencesKey("default_currency")

    override suspend fun getDefaultCurrency(): String {
        return runBlocking {
            context.dataStore.data.map { settings ->
                settings[key]
                    ?: StubData.currencyList.firstOrNull()?.name.orEmpty()
            }.first()
        }
    }

    override suspend fun setDefaultCurrency(newCurrency: String) {
        context.dataStore.edit { settings ->
            settings[key] = newCurrency
        }
    }
}
