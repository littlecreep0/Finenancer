package lc.wise.finenancer.presentation.settings.bottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import lc.wise.finenancer.databinding.BottomSheetLayoutBinding
import lc.wise.finenancer.presentation.settings.SettingsViewModel
import lc.wise.finenancer.presentation.settings.bottomSheet.rv.CurrencyBottomSheetAdapter

@AndroidEntryPoint
class CurrencyBottomSheet : BottomSheetDialogFragment() {
    private val settingsViewModel: SettingsViewModel by viewModels()
    private lateinit var currencyAdapter: CurrencyBottomSheetAdapter
    private var _binding: BottomSheetLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currencyAdapter = CurrencyBottomSheetAdapter { selectedCurrency ->
            lifecycleScope.launch {
                settingsViewModel.setDefaultCurrency(selectedCurrency.name)
                setFragmentResult(
                    "requestKey",
                    Bundle().apply {
                        putString(
                            "selectedCurrency", selectedCurrency.name
                        )
                    }
                )
                dismiss()
            }
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = currencyAdapter

        settingsViewModel.currenciesList.observe(viewLifecycleOwner) { currencies ->
            currencyAdapter.submitList(currencies)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "TAG_SELECT_CURRENCY"
    }
}
