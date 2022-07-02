package com.example.week1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week1.databinding.GalleryItemBinding
import org.jetbrains.anko.padding

class GalleryAdapter(
//    var imageList: List<Image>,
//    private val listener: (Image, Int) -> Unit
    val context: GalleryFragment,
    var imageList: List<String>,
) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of single_item.xml
    // ie SingleItemBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class ViewHolder(val binding: GalleryItemBinding) : RecyclerView.ViewHolder(binding.root)

    // inside the onCreateViewHolder inflate the view of SingleItemBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GalleryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // bind the items with each item
    // of the list languageList
    // which than will be
    // shown in recycler view
    // to keep it simple we are
    // not setting any image data to view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(imageList[position]){
//                binding.galleryItem.setImageResource(this.img)
//                Log.d("Uri:################ ", this)
                // Original without Glide
//                binding.galleryItem.setImageURI(this.toUri())
                val display = context.resources.displayMetrics
//
                binding.galleryItem.padding = 2
                binding.itemWrapper.layoutParams = ConstraintLayout.LayoutParams(display.widthPixels/3,display.widthPixels/3)

                Glide.with(context).load(this).centerCrop().into(binding.galleryItem)
            }
        }
//        holder.itemView.setOnClickListener { listener(imageList[position], position) }
//        println(holder.itemView)
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return imageList.size
    }
}