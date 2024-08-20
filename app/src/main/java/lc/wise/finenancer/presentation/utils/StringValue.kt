package lc.wise.finenancer.presentation.utils

import androidx.annotation.StringRes
import lc.wise.finenancer.App

object StringValue {
    fun getStringRes(
        @StringRes stringRes: Int,
        vararg formatArgs: Any = emptyArray()
    ): String = App.instance.getString(stringRes, *formatArgs)
}
