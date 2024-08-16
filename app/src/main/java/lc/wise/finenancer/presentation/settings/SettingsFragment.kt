package lc.wise.finenancer.presentation.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import lc.wise.finenancer.databinding.FragmentSettingsBinding
import lc.wise.finenancer.presentation.settings.bottomSheet.CurrencyBottomSheet
import lc.wise.finenancer.presentation.settings.bottomSheet.CurrencyBottomSheet.Companion.REQUEST_KEY
import lc.wise.finenancer.presentation.settings.bottomSheet.CurrencyBottomSheet.Companion.SELECTED_CURRENCY
import lc.wise.finenancer.presentation.utils.BaseFragment

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    private val viewModel: SettingsViewModel by viewModels()
    override fun inflateBinding() = FragmentSettingsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.settings.observe(viewLifecycleOwner) { currentCurrency ->
            binding.setDefaultCurrencyButton.text = currentCurrency
        }

        binding.setDefaultCurrencyButton.setOnClickListener {
            showCurrencyBottomSheet()
        }

        parentFragmentManager.setFragmentResultListener(REQUEST_KEY, this) { key, bundle ->
            val selectedCurrency = bundle.getString(SELECTED_CURRENCY)
            viewModel.setDefaultCurrency(selectedCurrency ?: "")
        }
    }

    private fun showCurrencyBottomSheet() {
        val bottomSheet = CurrencyBottomSheet()
        bottomSheet.show(parentFragmentManager, CurrencyBottomSheet.TAG)
    }
}
