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
import io.name.card.aos.Data.NameCardMakingImage

class NameCard_Making_Page_Adapter(private val context: Context) :
    RecyclerView.Adapter<NameCard_Making_Page_Adapter.ViewHolder>() {

    var nameCardMakingImageData = mutableListOf<NameCardMakingImage>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.namecard_making_image, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = nameCardMakingImageData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(nameCardMakingImageData[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val making_nameCardImage: ImageView = itemView.findViewById(R.id.nameCard_making_image)

        fun bind(item: NameCardMakingImage) {
            Glide.with(itemView).load(item.making_image).into(making_nameCardImage)
        }
    }


}