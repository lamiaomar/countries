package com.example.countries.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.databinding.GridViewItemBinding
import com.example.countries.network.CountryPhoto
import com.example.countries.network.Phototresponse


class PhotoGridAdapter : ListAdapter<CountryPhoto,
        PhotoGridAdapter.CountrysPhotoViewHolder>(DiffCallback) {


    class CountrysPhotoViewHolder(private var binding:
                              GridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(MarsPhoto: CountryPhoto) {
            binding.photo = MarsPhoto
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CountryPhoto>() {
        override fun areItemsTheSame(oldItem: CountryPhoto, newItem: CountryPhoto): Boolean {
            return newItem.name == oldItem.name
        }

        override fun areContentsTheSame(oldItem: CountryPhoto, newItem: CountryPhoto): Boolean {
            return oldItem.name == newItem.name
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