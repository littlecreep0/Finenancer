package lc.wise.finenancer.presentation.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import javax.inject.Inject
import lc.wise.finenancer.databinding.ItemBondBinding
import lc.wise.finenancer.databinding.ItemCashBinding
import lc.wise.finenancer.databinding.ItemStockBinding
import lc.wise.finenancer.presentation.assets.rv.ItemBondViewHolder
import lc.wise.finenancer.presentation.assets.rv.ItemCashViewHolder
import lc.wise.finenancer.presentation.assets.rv.ItemStockViewHolder

interface TypeFactory {
    fun type(cashUI: AssetUI.CashUI): Int
    fun type(stockUI: AssetUI.StockUI): Int
    fun type(bondUI: AssetUI.BondUI): Int

    fun holder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<*>
}

class TypeFactoryImpl @Inject constructor() : TypeFactory {
    override fun type(cashUI: AssetUI.CashUI): Int = AssetClass.CASH.ordinal
    override fun type(stockUI: AssetUI.StockUI): Int = AssetClass.STOCK.ordinal
    override fun type(bondUI: AssetUI.BondUI): Int = AssetClass.BOND.ordinal

    override fun holder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*> {
        return when (viewType) {
            AssetClass.CASH.ordinal -> ItemCashViewHolder(
                ItemCashBinding.inflate(inflater, parent, false)
            )

            AssetClass.STOCK.ordinal -> ItemStockViewHolder(
                ItemStockBinding.inflate(inflater, parent, false)
            )

            AssetClass.BOND.ordinal -> ItemBondViewHolder(
                ItemBondBinding.inflate(inflater, parent, false)
            )

            else -> throw IllegalArgumentException()
        }
    }
}
