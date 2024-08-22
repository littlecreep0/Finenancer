package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.data.entity.AssetEntity

@Dao
interface AssetDao {
    @Query("SELECT asset_type FROM assets_list WHERE asset_id = :assetID")
    fun getAssetType(assetID: Int): String

    @Query("SELECT asset_id FROM assets_list ORDER BY asset_id DESC LIMIT 1")
    fun getLastAssetID(): Int

    @Query("SELECT * FROM assets_list WHERE asset_id = :assetID")
    fun getAssetByID(assetID: Int): AssetEntity

    @Upsert
    fun saveAsset(assetEntity: AssetEntity)

    @Delete
    fun deleteAsset(assetEntity: AssetEntity)
}
