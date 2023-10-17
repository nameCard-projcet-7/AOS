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
import io.name.card.aos.R
import io.name.card.aos.nameCardData

class nameCard_Management_Adapter(private val context: Context) :
    RecyclerView.Adapter<nameCard_Management_Adapter.ViewHolder>() {

    var nameCardData = nameCard_Management_Detail_Modification.NameCardDataSource.nameCardDataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.namecard_managemnt_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = nameCardData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(nameCardData[position])
    }

    fun setList(nameData: MutableList<nameCardData>) {
        nameCardData = nameData
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameCardName: TextView = itemView.findViewById(R.id.nameCardName_Tv)
        private val nameCardOffice: TextView = itemView.findViewById(R.id.nameCardOffice_Tv)
        private val nameCardNumber: TextView = itemView.findViewById(R.id.nameCardNumber_Tv)
        private val nameCardImage: ImageView = itemView.findViewById(R.id.nameCard_ImageView)


        fun bind(item: nameCardData) {
            nameCardName.text = item.name
            nameCardOffice.text = item.office
            nameCardNumber.text = item.number
            Glide.with(itemView).load(item.image).into(nameCardImage)

            itemView.setOnClickListener {
                val intent = Intent(context, nameCard_Management_Detail::class.java).apply {
                    putExtra("image", item.image)
                    putExtra("name", item.name)
                    putExtra("office", item.office)
                    putExtra("position", item.position)
                    putExtra("number", item.number)
                    putExtra("email", item.email)
                    putExtra("telephone", item.telephone)
                    putExtra("fax", item.fax)
                    putExtra("address", item.address)
                }
                context.startActivity(intent)
            }
        }

    }


}