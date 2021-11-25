package com.example.countries.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.databinding.GridViewItemBinding
import com.example.countries.network.Phototresponse


class PhotoGridAdapter : ListAdapter<Phototresponse,
        PhotoGridAdapter.CountrysPhotoViewHolder>(DiffCallback) {


    class CountrysPhotoViewHolder(private var binding:
                              GridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(MarsPhoto: Phototresponse) {
            binding.photo = MarsPhoto
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Phototresponse>() {
        override fun areItemsTheSame(oldItem: Phototresponse, newItem: Phototresponse): Boolean {
            return newItem.msg == oldItem.msg
        }

        override fun areContentsTheSame(oldItem: Phototresponse, newItem: Phototresponse): Boolean {
            return oldItem.msg == newItem.msg
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.CountrysPhotoViewHolder {
        return CountrysPhotoViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))    }



    override fun onBindViewHolder(holder: PhotoGridAdapter.CountrysPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
}