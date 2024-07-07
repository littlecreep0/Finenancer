package lc.wise.finenancer.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.FragmentHomeBinding
import lc.wise.finenancer.presentation.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            assetsList.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_assetsListFragment)
            }
            portfolioList.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_portfolioListFragment)
            }
            settings.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
            } // we're doing it as a button on home screen for now but it being always
        } //available in the toolbar with back button and fragment name is cooler
    }
}