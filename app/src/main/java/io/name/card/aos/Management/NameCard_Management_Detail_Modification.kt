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
import io.name.card.aos.Data.NameCardData

class NameCard_Management_Detail_Modification : AppCompatActivity() {

    object NameCardDataSource {
        var nameCardDataList = mutableListOf<NameCardData>()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.namecard_management_item_detail_modification)

        val ButtonModification: Button = findViewById(R.id.nameCardScan_modification_Button)
        val EditTvNameModification: TextView = findViewById(R.id.nameCard_modification_name_Tv)
        val EditTvOfficeModification: TextView = findViewById(R.id.nameCard_modification_office_Tv)
        val EditTvPositionModification: TextView = findViewById(R.id.nameCard_modification_position_Tv)
        val EditTvNumberModification: TextView = findViewById(R.id.nameCard_modification_number_Tv)
        val EditTvEmailModification: TextView = findViewById(R.id.nameCard_modification_email_Tv)
        val EditTvAddressModification: TextView = findViewById(R.id.nameCard_modification_address_Tv)

        // 수정할 아이템들
        val updatedName = EditTvNameModification.text.toString()
        val updatedOffice = EditTvOfficeModification.text.toString()
        val updatedPosition = EditTvPositionModification.text.toString()
        val updatedNumber = EditTvNumberModification.text.toString()
        val updatedEmail = EditTvEmailModification.text.toString()
        val updatedAddress= EditTvAddressModification.text.toString()

        val nameCardData = NameCardDataSource.nameCardDataList

        // 수정한 데이터를 기존의 데이터 클래스에 덮어 씌우는 작업
        val updatedNameCardData = NameCardData(
            updatedName,
            updatedOffice,
            updatedPosition,
            updatedNumber,
            updatedEmail,
            updatedAddress
        )

        ButtonModification.setOnClickListener {
            val index = nameCardData.indexOfFirst { it.Name == updatedName }
            if(index != -1) {
                NameCardDataSource.nameCardDataList[index] = updatedNameCardData
            }

            Log.d("UpdatedData", "Updated Name: $updatedName")
            Log.d("UpdatedData", "Updated Office: $updatedOffice")
            Log.d("UpdatedData", "Updated Position: $updatedPosition")
            Log.d("UpdatedData", "Updated Number: $updatedNumber")
            Log.d("UpdatedData", "Updated Email: $updatedEmail")
            Log.d("UpdatedData", "Updated Address: $updatedAddress")

            finish()

            Log.d("check", "수정: $nameCardData")
        }
    }
}
