package lc.wise.finenancer.presentation.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import javax.inject.Inject
import lc.wise.finenancer.domain.entity.Bond
import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.domain.entity.Stock
import lc.wise.finenancer.presentation.assets.rv.ItemBondViewHolder
import lc.wise.finenancer.presentation.assets.rv.ItemCashViewHolder
import lc.wise.finenancer.presentation.assets.rv.ItemStockViewHolder

interface TypeFactory {
    fun type(cash: Cash): Int
    fun type(stock: Stock): Int
    fun type(bond: Bond): Int

    fun holder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<*>
}

class TypeFactoryImpl @Inject constructor() : TypeFactory {
    override fun type(cash: Cash): Int = AssetViewType.CASH.ordinal
    override fun type(stock: Stock): Int = AssetViewType.STOCK.ordinal
    override fun type(bond: Bond): Int = AssetViewType.BOND.ordinal

    override fun holder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*> {
        return when (viewType) {
            AssetViewType.CASH.ordinal -> ItemCashViewHolder.createViewHolder(inflater, parent)
            AssetViewType.STOCK.ordinal -> ItemStockViewHolder.createViewHolder(inflater, parent)
            AssetViewType.BOND.ordinal -> ItemBondViewHolder.createViewHolder(inflater, parent)
            else -> throw IllegalArgumentException()
        }
    }
}
