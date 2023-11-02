package io.name.card.aos.Management

import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.name.card.aos.R
import java.io.OutputStream
import java.util.UUID

class nameCard_Management_Detail : AppCompatActivity() {
    // 블루투스 어댑터 초기화
    val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.namecard_management_item_detail)

        /*/// 페어링된 기기 목록을 클래스 내에서 바로 얻을 수 있습니다.
        val pairedDevices: Set<BluetoothDevice>? = bluetoothAdapter?.bondedDevices

        // 블루투스 지원 여부 확인
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            return
        }

        // 블루투스 활성화 여부 확인
        if (!bluetoothAdapter.isEnabled) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode != Activity.RESULT_OK) {
                    // 사용자가 블루투스 활성화를 거부했을 경우 처리
                }
            }.launch(enableBtIntent)
        }*/



        var tvNameDetail: TextView = findViewById(R.id.nameCard_detail_name_Tv)
        var tvOfficeDetail: TextView = findViewById(R.id.nameCard_detail_office_Tv)
        var tvPositionDetail: TextView = findViewById(R.id.nameCard_detail_position_Tv)
        var tvNumberDetail: TextView = findViewById(R.id.nameCard_detail_number_Tv)
        var tvEmailDetail: TextView = findViewById(R.id.nameCard_detail_email_Tv)
        var tvAddressDetail: TextView = findViewById(R.id.nameCard_detail_address_Tv)
        var buttonShare: Button = findViewById(R.id.nameCard_detail_share_Button)

        var image = intent.getIntExtra("image", 0)
        var name = intent.getStringExtra("name")
        var office = intent.getStringExtra("office")
        var position = intent.getStringExtra("position")
        var number = intent.getStringExtra("number")
        var email = intent.getStringExtra("email")
        var address = intent.getStringExtra("address")

        tvNameDetail.text = name
        tvOfficeDetail.text = office
        tvPositionDetail.text = position
        tvNumberDetail.text = number
        tvEmailDetail.text = email
        tvAddressDetail.text = address

        /*buttonShare.setOnClickListener {
            // 선택된 블루투스 기기와 연결을 시도
            val device: BluetoothDevice = pairedDevices?.firstOrNull() ?: return@setOnClickListener

            val uuid: UUID = UUID.fromString("your-uuid-string-here")
            try {
                val socket: BluetoothSocket = device.createRfcommSocketToServiceRecord(uuid)
                socket.connect()
                val outputStream: OutputStream = socket.outputStream
                val stringToSend = "${tvNameDetail.text},${tvOfficeDetail.text},${tvPositionDetail.text},${tvNumberDetail.text},${tvEmailDetail.text},${tvAddressDetail.text}"
                outputStream.write(stringToSend.toByteArray())
            } catch (e: Exception) {
                // 연결 또는 데이터 전송 중 오류 발생
            }
        }*/
    }

}