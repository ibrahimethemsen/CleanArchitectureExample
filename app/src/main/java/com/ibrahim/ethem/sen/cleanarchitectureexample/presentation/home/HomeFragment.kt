package com.ibrahim.ethem.sen.cleanarchitectureexample.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ibrahim.ethem.sen.cleanarchitectureexample.databinding.FragmentHomeBinding
import com.ibrahim.ethem.sen.cleanarchitectureexample.utility.searchFilter
import com.ibrahim.ethem.sen.cleanarchitectureexample.utility.setVisibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val rvAdapter = HomeRecyclerAdapter()
    private val viewModel : HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getQuoteList()
        binding.homeRecyclerView.adapter = rvAdapter
        observeQuote()
        viewModel.getQuote()
        binding.searchInputEt.searchFilter {
            viewModel.searchQuote(it)
        }
    }
    private fun observeQuote(){
        viewModel.quoteList.observe(viewLifecycleOwner){
            handleQuoteList(it)
        }
    }
    private fun handleQuoteList(uiState : QuoteUiState){
        binding.loadingProgress.setVisibility(uiState.isLoading)
        rvAdapter.updateList(uiState.data)
        uiState.message?.let {
            binding.errorMsg.setText(uiState.message)
            binding.errorMsg.visibility = View.VISIBLE
        }
    }
}