package com.example.hotels.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.entities.model.Details
import com.example.entities.uimodel.HotelListUIModel
import com.example.hotels.databinding.CardHotelsFragmentBinding

class HotelsListAdapter(val onClick : (HotelListUIModel)->Unit) : RecyclerView.Adapter<HotelsListAdapter.HotelListViewHolder>() {

    var hotelList = listOf<Details?>()

    fun submitList(list: List<Details?>) {
        this.hotelList = list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardHotelsFragmentBinding.inflate(inflater, parent, false)

        return HotelListViewHolder(binding, onClick)
    }


    override fun getItemCount(): Int {
       return hotelList.size
    }

    override fun onBindViewHolder(holder: HotelListViewHolder, position: Int) {

        var viewHolder = holder as HotelListViewHolder
        var currentHotel = hotelList[position]

        holder.binding.titleTextView.text = currentHotel?.name
        holder.binding.testTextView.text = currentHotel?.name

    }

    class HotelListViewHolder(
         val binding: CardHotelsFragmentBinding,
        val onClick: (HotelListUIModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(uiModel: HotelListUIModel) {
            binding.testTextView.text = uiModel.hotelTitle
            binding.priceTextView.text = uiModel.hotelPrice.toString()
            binding.root.setOnClickListener {
                onClick(uiModel)
            }
        }
    }
}