package com.fatemeh.digitoon.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fatemeh.digitoon.databinding.ItemRateBinding
import com.fatemeh.digitoon.model.Rate

class RateAdapter :
    RecyclerView.Adapter<RateAdapter.ViewHolder>() {

    var ratings = ArrayList<Rate>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRateBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(ratings[position])

    override fun getItemCount(): Int = ratings.size

    inner class ViewHolder(private val binding: ItemRateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(rate: Rate) {

            binding.tvSource.text = rate.source
            binding.tvValue.text = rate.value

        }
    }

}