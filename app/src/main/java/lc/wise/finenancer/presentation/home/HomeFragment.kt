package lc.wise.finenancer.presentation.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import lc.wise.finenancer.databinding.FragmentHomeBinding
import lc.wise.finenancer.presentation.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            assetsList.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToAssetsListFragment()
                )
            }
            portfolioList.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToPortfolioListFragment()
                )
            }
            settings.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToSettingsFragment()
                )
            } // we're doing it as a button on home screen for now but it being always
        } // available in the toolbar with back button and fragment name is cooler
    }
}
