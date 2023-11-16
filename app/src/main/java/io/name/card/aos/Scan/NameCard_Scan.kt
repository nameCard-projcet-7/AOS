package io.name.card.aos.Scan

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.name.card.aos.API.RetrofitClient
import io.name.card.aos.Data.NameCardData
import io.name.card.aos.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NameCard_Scan : Fragment() {
    private val REQUEST_IMAGE_CAPTURE = 1 // 사진 촬영
    private val REQUEST_GALLERY_IMAGE = 2 // 갤러리 불러오기
    private lateinit var nameCardScanImage: ImageView

    var nameCard_data = mutableListOf<NameCardData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_name_card__scan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameCardScanImage =  view.findViewById(R.id.nameCardScan_Image)
        val nameCardScanButton: Button = view.findViewById(R.id.nameCardScan_Button)
        val nameCardScanImageButton: Button = view.findViewById(R.id.nameCardScan_Image_Button)

        // 사진 촬영 버튼 클릭 리스너
        nameCardScanButton.setOnClickListener {
            dispatchTakePictureIntent()
        }
        // 갤러리 불러오기 버튼 클릭 리스너
        nameCardScanImageButton.setOnClickListener {
            dispatchSelectPictureFromGalleryIntent()
        }

        getNameCardData()
    }

    // 사진 촬영 화면으로 넘어가기
    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    // 갤러리 앱으로 넘어가기
    private fun dispatchSelectPictureFromGalleryIntent() {
        val pickPhotoIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(pickPhotoIntent, REQUEST_GALLERY_IMAGE)
    }

    // 촬영 결과, 갤러리에서 가져온 이미지 가져와서 ImageView에 보이기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // 촬영을 했을 경우 비트맵으로 변환 후 이미지 뷰에 세팅
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as? Bitmap
            nameCardScanImage.setImageBitmap(imageBitmap)
        }
        // 갤러리에서 가져왔을 경우 이미지뷰에 세팅
        else if (requestCode == REQUEST_GALLERY_IMAGE && resultCode == RESULT_OK) {
            val imageUri = data?.data
            nameCardScanImage.setImageURI(imageUri)
        }
    }

    private fun getNameCardData() {
        val call = RetrofitClient.apiService.getNameCardData()

        call.enqueue(object : Callback<NameCardData> {
            override fun onResponse(call: Call<NameCardData>, response: Response<NameCardData>) {
                if (response.isSuccessful) {
                    val nameCardResponse = response.body()
                    nameCardResponse?.let {
                        updateUIWithResponse(it)
                    }
                } else {
                    Log.e("API Error", "Response not successful")
                }
            }

            override fun onFailure(call: Call<NameCardData>, t: Throwable) {
                Log.e("API Error", "Call failed", t)
            }
        })
    }

    private fun updateUIWithResponse(data: NameCardData) {
        // UI 업데이트는 메인 스레드에서 수행해야 합니다.
        activity?.runOnUiThread {
            view?.findViewById<TextView>(R.id.scanName_Tv)?.text = data.Name
            view?.findViewById<TextView>(R.id.scanOffice_Tv)?.text = data.Company
            view?.findViewById<TextView>(R.id.scanPosition_Tv)?.text = data.Role
            view?.findViewById<TextView>(R.id.scanNumber_Tv)?.text = data.PhoneNumber
            view?.findViewById<TextView>(R.id.scanEmail_Tv)?.text = data.Email
            view?.findViewById<TextView>(R.id.scanAddress_Tv)?.text = data.Address
        }
    }
}
