package io.name.card.aos.Management

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import io.name.card.aos.R
import io.name.card.aos.Data.NameCardData

class NameCard_Management_Adapter(private val context: Context) :
    RecyclerView.Adapter<NameCard_Management_Adapter.ViewHolder>() {

    var nameCardData = NameCard_Management_Detail_Modification.NameCardDataSource.nameCardDataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.namecard_managemnt_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = nameCardData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(nameCardData[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(nameData: MutableList<NameCardData>) {
        nameCardData = nameData
        notifyDataSetChanged()  // RecyclerView에 데이터 변경을 알립니다.
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameCardName: TextView = itemView.findViewById(R.id.nameCardName_Tv)
        private val nameCardOffice: TextView = itemView.findViewById(R.id.nameCardOffice_Tv)
        private val nameCardNumber: TextView = itemView.findViewById(R.id.nameCardNumber_Tv)
        private val nameCardEmail: TextView = itemView.findViewById(R.id.nameCardEmail_Tv)

        // 리사이클러뷰의 아이템을 클릭 시 Detail로 넘어감
        // 데이터들을 함께 보냄
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    val currentItem = nameCardData[position]
                    val intent = Intent(context, NameCard_Management_Detail::class.java).apply {
                        putExtra("name", currentItem.Name)
                        putExtra("office", currentItem.Company)
                        putExtra("position", currentItem.Role)
                        putExtra("number", currentItem.PhoneNumber)
                        putExtra("email", currentItem.Email)
                        putExtra("address", currentItem.Address)
                    }
                    context.startActivity(intent)
                }
            }
        }

        fun bind(item: NameCardData) {
            nameCardName.text = item.Company
            nameCardOffice.text = item.Name
            nameCardNumber.text = item.PhoneNumber
            nameCardEmail.text = item.Email
        }

    }


}