package com.ibrahim.ethem.sen.cleanarchitectureexample.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.ethem.sen.cleanarchitectureexample.databinding.QuoteItemRvBinding
import com.ibrahim.ethem.sen.cleanarchitectureexample.domain.model.QuoteEntity

class HomeRecyclerAdapter : RecyclerView.Adapter<HomeRecyclerAdapter.HomeRecyclerViewHolder>() {
    private val quoteList = mutableListOf<QuoteEntity>()

    fun updateList(newList : List<QuoteEntity>){
        quoteList.apply {
            clear()
            addAll(newList)
        }
        notifyDataSetChanged()
    }
    class HomeRecyclerViewHolder(val binding : QuoteItemRvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        val binding = QuoteItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HomeRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {
        holder.binding.authorTv.text = quoteList[position].author
        holder.binding.contentTv.text = quoteList[position].content
    }

    override fun getItemCount(): Int = quoteList.size
}