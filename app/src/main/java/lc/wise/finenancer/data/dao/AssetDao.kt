package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.domain.entity.Asset

@Dao
interface AssetDao {
    @Query("SELECT type FROM assets_list WHERE id = :assetID")
    fun getAssetType(assetID: Int): String

    @Query("SELECT id FROM assets_list ORDER BY id DESC LIMIT 1")
    fun getLastAssetID(): Int

    @Upsert
    fun saveAsset(asset: Asset): Asset?

    @Delete
    fun deleteAsset(assetID: Int)
}
