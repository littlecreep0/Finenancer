package lc.wise.finenancer.presentation.settings

import lc.wise.finenancer.databinding.FragmentSettingsBinding
import lc.wise.finenancer.presentation.BaseFragment

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    override fun getViewBinding(): FragmentSettingsBinding = FragmentSettingsBinding
        .inflate(layoutInflater)
}
