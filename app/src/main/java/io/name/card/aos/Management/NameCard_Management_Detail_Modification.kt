package io.name.card.aos.Management

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.name.card.aos.R
import io.name.card.aos.nameCardData

class nameCard_Management_Detail_Modification : AppCompatActivity() {

    object NameCardDataSource {
        var nameCardDataList = mutableListOf<nameCardData>()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.namecard_management_item_detail_modification)

        val ButtonModification: Button = findViewById(R.id.nameCardScan_modification_Button)
        val FrameLayoutImageModification: FrameLayout = findViewById(R.id.nameCard_modification_Framlayout)
        val ImageViewModifiaction: ImageView = findViewById(R.id.nameCard_modification_Image)
        val EditTvNameModification: TextView = findViewById(R.id.nameCard_modification_name_Tv)
        val EditTvOfficeModification: TextView = findViewById(R.id.nameCard_modification_office_Tv)
        val EditTvPositionModification: TextView = findViewById(R.id.nameCard_modification_position_Tv)
        val EditTvNumberModification: TextView = findViewById(R.id.nameCard_modification_number_Tv)
        val EditTvEmailModification: TextView = findViewById(R.id.nameCard_modification_email_Tv)
        val EditTvTelephoneModification: TextView = findViewById(R.id.nameCard_modification_telephone_Tv)
        val EditTvFaxModification: TextView = findViewById(R.id.nameCard_modification_fax_Tv)
        val EditTvAddressModification: TextView = findViewById(R.id.nameCard_modification_address_Tv)

        val imageId = intent.getIntExtra("image", 0)

        // 수정할 아이템들
        val updatedName = EditTvNameModification.text.toString()
        val updatedOffice = EditTvOfficeModification.text.toString()
        val updatedPosition = EditTvPositionModification.text.toString()
        val updatedNumber = EditTvNumberModification.text.toString()
        val updatedEmail = EditTvEmailModification.text.toString()
        val updatedTelephone = EditTvTelephoneModification.text.toString()
        val updatedFax= EditTvFaxModification.text.toString()
        val updatedAddress= EditTvAddressModification.text.toString()

        val nameCardData = NameCardDataSource.nameCardDataList

        // 수정한 데이터를 기존의 데이터 클래스에 덮어 씌우는 작업
        val updatedNameCardData = nameCardData(
            imageId,
            updatedName,
            updatedOffice,
            updatedPosition,
            updatedNumber,
            updatedEmail,
            updatedTelephone,
            updatedFax,
            updatedAddress
        )

        ButtonModification.setOnClickListener {
            val index = nameCardData.indexOfFirst { it.name == updatedName }
            if(index != -1) {
                NameCardDataSource.nameCardDataList[index] = updatedNameCardData
            }

            Log.d("UpdatedData", "Updated Name: $updatedName")
            Log.d("UpdatedData", "Updated Office: $updatedOffice")
            Log.d("UpdatedData", "Updated Position: $updatedPosition")
            Log.d("UpdatedData", "Updated Number: $updatedNumber")
            Log.d("UpdatedData", "Updated Email: $updatedEmail")
            Log.d("UpdatedData", "Updated Telephone: $updatedTelephone")
            Log.d("UpdatedData", "Updated Fax: $updatedFax")
            Log.d("UpdatedData", "Updated Address: $updatedAddress")

            finish()

            Log.d("check", "수정: $nameCardData")
        }
    }
}
