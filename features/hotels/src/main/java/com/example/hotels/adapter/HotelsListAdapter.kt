package com.example.hotels.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.entities.model.Details
import com.example.entities.uimodel.HotelListUIModel
import com.example.hotels.databinding.CardHotelsFragmentBinding

class HotelsListAdapter(val onClick : (HotelListUIModel)->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var hotelList = listOf<HotelListUIModel?>()

    fun submitList(list: List<HotelListUIModel?>) {
        this.hotelList = list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder : RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardHotelsFragmentBinding.inflate(inflater, parent, false)

        viewHolder = HotelListViewHolder(binding, onClick)
        return viewHolder
    }


    override fun getItemCount(): Int {
       return hotelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val viewHolder = holder as HotelListViewHolder
        val currentHotel = hotelList[position]

        viewHolder.binding.titleTextView.text = currentHotel?.hotelTitle
        viewHolder.binding.locationTextView.text = currentHotel?.hotelId
        viewHolder.binding.priceTextView.text = currentHotel?.hotelPrice.toString()
       // holder.binding.testTextView.text = currentHotel?.hotelTitle

    }

    class HotelListViewHolder(
         val binding: CardHotelsFragmentBinding,
        val onClick: (HotelListUIModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(uiModel: HotelListUIModel) {
        //    binding.testTextView.text = uiModel.hotelTitle
            binding.priceTextView.text = uiModel.hotelPrice.toString()
            binding.root.setOnClickListener {
                onClick(uiModel)
            }
        }
    }
}