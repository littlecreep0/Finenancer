package lc.wise.finenancer.presentation.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import lc.wise.finenancer.databinding.FragmentSettingsBinding
import lc.wise.finenancer.presentation.settings.bottomSheet.CurrencyBottomSheet
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
    }

    private fun showCurrencyBottomSheet() {
        val bottomSheet = CurrencyBottomSheet()
        bottomSheet.setOnCurrencySelectedListener(object :
            CurrencyBottomSheet.OnCurrencySelectedListener {
            override fun onCurrencySelected(currency: String) {
                lifecycleScope.launch {
                    viewModel.setDefaultCurrency(currency)
                }
            }
        })
        bottomSheet.show(parentFragmentManager, CurrencyBottomSheet.TAG)
    }
}
