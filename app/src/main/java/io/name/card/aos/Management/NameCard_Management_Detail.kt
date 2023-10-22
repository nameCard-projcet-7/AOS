package io.name.card.aos.Management

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.name.card.aos.R

class nameCard_Management_Detail : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.namecard_management_item_detail)

        var tvNameDetail: TextView = findViewById(R.id.nameCard_detail_name_Tv)
        var tvOfficeDetail: TextView = findViewById(R.id.nameCard_detail_office_Tv)
        var tvPositionDetail: TextView = findViewById(R.id.nameCard_detail_position_Tv)
        var tvNumberDetail: TextView = findViewById(R.id.nameCard_detail_number_Tv)
        var tvEmailDetail: TextView = findViewById(R.id.nameCard_detail_email_Tv)
        var tvTelephoneDetail: TextView = findViewById(R.id.nameCard_detail_telephone_Tv)
        var tvFaxDetail: TextView = findViewById(R.id.nameCard_detail_fax_Tv)
        var tvAddressDetail: TextView = findViewById(R.id.nameCard_detail_address_Tv)
        var buttonShare: Button = findViewById(R.id.nameCard_detail_share_Button)

        var image = intent.getIntExtra("image", 0)
        var name = intent.getStringExtra("name")
        var office = intent.getStringExtra("office")
        var position = intent.getStringExtra("position")
        var number = intent.getStringExtra("number")
        var email = intent.getStringExtra("email")
        var telephone = intent.getStringExtra("telephone")
        var fax = intent.getStringExtra("fax")
        var address = intent.getStringExtra("address")

        tvNameDetail.text = name
        tvOfficeDetail.text = office
        tvPositionDetail.text = position
        tvNumberDetail.text = number
        tvEmailDetail.text = email
        tvTelephoneDetail.text = telephone
        tvFaxDetail.text = fax
        tvAddressDetail.text = address

        buttonShare.setOnClickListener {
            
        }

        var fab: FloatingActionButton = findViewById(R.id.nameCardScan_modification_Floating)
        fab.setOnClickListener {
            var intent = Intent(this, nameCard_Management_Detail_Modification::class.java).apply {
                putExtra("image", image)
                putExtra("name", name)
                putExtra("office", office)
                putExtra("position", position)
                putExtra("number", number)
                putExtra("email", email)
                putExtra("telephone", telephone)
                putExtra("fax", fax)
                putExtra("address", address)
            }
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Refresh data and UI here
        val updatedNameCardData = nameCard_Management_Detail_Modification.NameCardDataSource.nameCardDataList.find { it.name == intent.getStringExtra("name") }
        // Update UI using updatedNameCardData
    }

}