package com.example.countries.overview

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.countries.R
import com.example.countries.network.CountryPhoto
import com.example.countries.network.Phototresponse
import java.util.*


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<CountryPhoto>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)

}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri)
//        {
//            placeholder(R.drawable.loading_animation)
//            error(R.drawable.ic_broken_image)
//        }
    }

}