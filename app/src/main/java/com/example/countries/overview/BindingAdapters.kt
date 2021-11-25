package com.example.countries.overview

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import com.example.countries.R
import com.example.countries.network.CountryPhoto
import java.util.*


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<CountryPhoto>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)

}

//@BindingAdapter("imageUrl")
//fun bindImage(imgView: ImageView, imgUrl: String?) {
//    imgUrl?.let {
//        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
//        imgView.load(imgUri)
//        {
//            placeholder(R.drawable.loading_animation)
//            error(R.drawable.ic_broken_image)
//        }
//    }
//}


@BindingAdapter("imageUrl")
fun ImageView.loadSvg(imageUri: String?) {
    imageUri?.let{
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry { add(SvgDecoder(this@loadSvg.context)) }
            .build()

        this.load(imageUri, imageLoader) {
            crossfade(true)
            crossfade(500)
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)    }
    }

}
