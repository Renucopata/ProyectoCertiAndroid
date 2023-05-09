package com.first.mascotapp.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageViewResource(imageView: ImageView, resource: Int) {
            imageView.setImageResource(resource)
        }

        @JvmStatic
        @BindingAdapter("srcUrl")
        fun loadUrlImageView(imageView: ImageView, url: String) {
            Glide.with(imageView).load(url).into(imageView)
        }

        @JvmStatic
        @BindingAdapter(value = ["srcUrl", "circleCrop"])
        fun loadUrlImageViewCircleCrop(
            imageView: ImageView,
            url: String,
            circleCrop: Boolean = false
        ) {
            if (circleCrop) {
                Glide.with(imageView).load(url).circleCrop().into(imageView)
            } else {
                Glide.with(imageView).load(url).into(imageView)
            }
        }

    }
}