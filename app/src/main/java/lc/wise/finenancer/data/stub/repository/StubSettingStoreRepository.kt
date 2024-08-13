package lc.wise.finenancer.data.stub.repository

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.repository.SettingStoreRepository
import javax.inject.Inject


class StubSettingStoreRepository @Inject constructor(
    @ApplicationContext context: Context
) : SettingStoreRepository {
    private val settingStore: SharedPreferences =
        context.getSharedPreferences(SETTING_STORAGE_NAME, Context.MODE_PRIVATE)

    override fun setDefaultCurrency(newCurrency: String) {
        settingStore.edit().putString(DEFAULT_CURRENCY_KEY, newCurrency).apply()
    }

    override fun getDefaultCurrency(): String {
        val defaultCurrency = settingStore.getString(DEFAULT_CURRENCY_KEY, null)
        return defaultCurrency ?: StubData.currencyList.firstOrNull()?.name.orEmpty()
    }

    fun saveStubDataToPreferences() {
        val editor = settingStore.edit()
        StubData.currencyList.forEach { currency ->
            editor.putString("currency_${currency.id}", currency.name)
        }
        editor.apply()
    }

    companion object {
        const val SETTING_STORAGE_NAME = "settings"
        const val DEFAULT_CURRENCY_KEY = "default_currency"
    }
}
