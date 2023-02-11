package com.mrwhoknows.dogimagegenerator.ui.view_dogs

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mrwhoknows.dogimagegenerator.databinding.LayoutImageItemBinding

class DogImagesListAdapter :
    ListAdapter<Bitmap, DogImagesListAdapter.DogImagesViewHolder>(itemCallback) {

    inner class DogImagesViewHolder(
        private val binding: LayoutImageItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bitmap: Bitmap) {
            binding.ivImage.setImageBitmap(bitmap)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogImagesViewHolder =
        DogImagesViewHolder(
            LayoutImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: DogImagesViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val itemCallback = object : ItemCallback<Bitmap>() {
            override fun areItemsTheSame(oldItem: Bitmap, newItem: Bitmap): Boolean =
                oldItem.sameAs(newItem)

            override fun areContentsTheSame(oldItem: Bitmap, newItem: Bitmap): Boolean =
                oldItem.sameAs(newItem)
        }
    }

}