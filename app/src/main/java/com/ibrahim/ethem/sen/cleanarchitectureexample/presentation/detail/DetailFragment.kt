package com.ibrahim.ethem.sen.cleanarchitectureexample.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ibrahim.ethem.sen.cleanarchitectureexample.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!

    val args : DetailFragmentArgs by navArgs()
    private lateinit var id : String
    private val viewModel : DetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        id = args.id
        _binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getQuote(id)
        observeQuoteDetail()
    }

    private fun observeQuoteDetail(){
        viewModel.getQuote.observe(viewLifecycleOwner){
            binding.detailAuthor.text = it.data?.author
            binding.detailContent.text = it.data?.content
        }
    }
}