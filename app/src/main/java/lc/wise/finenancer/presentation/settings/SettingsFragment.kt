package lc.wise.finenancer.presentation.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
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

        parentFragmentManager.setFragmentResultListener("requestKey", this) { key, bundle ->
            val selectedCurrency = bundle.getString("selectedCurrency")
            viewModel.setDefaultCurrency(selectedCurrency ?: "")
        }
    }

    private fun showCurrencyBottomSheet() {
        val bottomSheet = CurrencyBottomSheet()
        bottomSheet.show(parentFragmentManager, CurrencyBottomSheet.TAG)
    }
}
