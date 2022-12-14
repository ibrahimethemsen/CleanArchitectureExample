package com.ibrahim.ethem.sen.cleanarchitectureexample.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.ibrahim.ethem.sen.cleanarchitectureexample.databinding.FragmentHomeBinding
import com.ibrahim.ethem.sen.cleanarchitectureexample.utility.searchFilter
import com.ibrahim.ethem.sen.cleanarchitectureexample.utility.setVisibility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val rvAdapter = HomeRecyclerAdapter()
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @OptIn(FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getQuoteList()
        binding.homeRecyclerView.adapter = rvAdapter
        rvAdapter.setOnItemClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it)
            requireView().findNavController().navigate(action)
        }
        observeQuote()

        binding.searchInputEt.searchFilter()
            .filter { it.isNotEmpty() } //girilen deger uzunlugu
            .debounce(300L) //timer belirli bir süre
            .onEach { //yapılacak islem
                viewModel.searchQuote(it)
            }.launchIn(lifecycleScope) //invoke



        binding.searchInputTil.setEndIconOnClickListener {
            viewModel.getQuoteList()
            binding.searchInputEt.clearFocus()
            binding.searchInputEt.text?.clear()
            requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        }
    }

    private fun observeQuote() {
        viewModel.quoteList.observe(viewLifecycleOwner) {
            handleQuoteList(it)
        }
    }

    private fun handleQuoteList(uiState: QuoteUiState) {
        binding.loadingProgress.setVisibility(uiState.isLoading)
        rvAdapter.updateList(uiState.data)
        if (uiState.data.isEmpty()){
            binding.homeRecyclerView.visibility = View.GONE
            binding.searchMsg.visibility = View.VISIBLE
        }else{
            binding.homeRecyclerView.visibility = View.VISIBLE
            binding.searchMsg.visibility = View.GONE
        }
        if (uiState.message == null) {
            binding.errorMsg.visibility = View.GONE
        } else {
            binding.errorMsg.setText(uiState.message)
            binding.errorMsg.visibility = View.VISIBLE
        }
    }
}