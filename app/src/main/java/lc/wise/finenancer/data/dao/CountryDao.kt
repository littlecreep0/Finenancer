package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.data.entity.CountryEntity

@Dao
interface CountryDao {
    @Query("SELECT * FROM countries_list")
    fun getCountriesList(): List<CountryEntity>

    @Query("SELECT * FROM countries_list WHERE country_id = :countryID")
    fun getCountryByID(countryID: Int): CountryEntity

    @Upsert
    fun saveCountry(countryEntity: CountryEntity)

    @Delete
    fun deleteCountry(countryEntity: CountryEntity)
}
