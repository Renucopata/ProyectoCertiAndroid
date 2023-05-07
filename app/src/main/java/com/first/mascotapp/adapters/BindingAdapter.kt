package com.first.mascotapp.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter

class BindingAdapter {
    companion object {
        @JvmStatic @BindingAdapter("android:src")
          fun setImageViewResource(imageView: ImageView, resource: Int) {
            imageView.setImageResource(resource)
    }

    }
}