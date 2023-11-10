package io.name.card.aos.Management

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.name.card.aos.Data.NameCardImage
import io.name.card.aos.R
import io.name.card.aos.Data.NameCardData

class NameCard_Making_Adapter(private val context: Context) :
    RecyclerView.Adapter<NameCard_Making_Adapter.ViewHolder>() {

    var nameCardImageData = mutableListOf<NameCardImage>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.namecard_making_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = nameCardImageData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(nameCardImageData[position])
    }

    fun setList(image: MutableList<NameCardImage>) {
        nameCardImageData = image
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val making_nameCardImage: ImageView = itemView.findViewById(R.id.nameCard_image_item)

        fun bind(item: NameCardImage) {
            Glide.with(itemView).load(item.image).into(making_nameCardImage)
        }
    }


}