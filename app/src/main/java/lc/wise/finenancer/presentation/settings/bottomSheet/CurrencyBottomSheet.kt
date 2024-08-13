package lc.wise.finenancer.presentation.settings.bottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import lc.wise.finenancer.R
import lc.wise.finenancer.presentation.settings.SettingsViewModel
import lc.wise.finenancer.presentation.settings.bottomSheet.rv.CurrencyBottomSheetAdapter

@AndroidEntryPoint
class CurrencyBottomSheet : BottomSheetDialogFragment() {
    private val settingsViewModel: SettingsViewModel by viewModels()
    private lateinit var currencyAdapter: CurrencyBottomSheetAdapter
    private var onCurrencySelectedListener: OnCurrencySelectedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currencyAdapter = CurrencyBottomSheetAdapter { selectedCurrency ->
            lifecycleScope.launch {
                settingsViewModel.setDefaultCurrency(selectedCurrency.name)
                onCurrencySelectedListener?.onCurrencySelected(selectedCurrency.name)
                dismiss()
            }
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = currencyAdapter

        settingsViewModel.currenciesList.observe(viewLifecycleOwner) { currencies ->
            currencyAdapter.submitList(currencies)
        }
    }

    fun setOnCurrencySelectedListener(listener: OnCurrencySelectedListener) {
        onCurrencySelectedListener = listener
    }

    interface OnCurrencySelectedListener {
        fun onCurrencySelected(currency: String)
    }

    companion object {
        const val TAG = "TAG_SELECT_CURRENCY"
    }
}
