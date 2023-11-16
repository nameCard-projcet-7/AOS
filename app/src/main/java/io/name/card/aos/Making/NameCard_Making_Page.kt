package io.name.card.aos.Making

import android.content.ClipData
import android.content.ClipDescription
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.name.card.aos.Data.NameCardMakingImage
import io.name.card.aos.HorizontalItemDecorator
import io.name.card.aos.Management.NameCard_Making_Page_Adapter
import io.name.card.aos.R

class NameCard_Making_Page : AppCompatActivity() {

    private lateinit var nameCard_Making_Page_Adapter: NameCard_Making_Page_Adapter // 어댑터
    private lateinit var nameCard_Making_Image_Choose: RecyclerView // 리사이클러뷰
    private lateinit var nameCardMakingImageView: ImageView // 명함을 제작하는 이미지뷰

    var nameCardMakingImageData = mutableListOf<NameCardMakingImage>()

    companion object {
        private const val NAME_TAG = "NAME_TAG"
        // 다른 EditText 태그를 위한 상수도 이곳에 추가할 수 있습니다.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.namecard_making)

        // 에딧 텍스트 뷰
        val Et_name: EditText = findViewById(R.id.nameCard_making_Et_name)
        val Et_office: EditText = findViewById(R.id.nameCard_making_Et_office)
        val Et_position: EditText = findViewById(R.id.nameCard_making_Et_position)
        val Et_phone: EditText = findViewById(R.id.nameCard_making_Et_phone)
        val Et_email: EditText = findViewById(R.id.nameCard_making_Et_email)
        val Et_address: EditText = findViewById(R.id.nameCard_making_Et_address)
        val nameCardMakingLayout: ConstraintLayout = findViewById(R.id.constraint)

        Et_name.apply{
            tag = NAME_TAG
            setOnClickListener {v: View ->
                val dragData = ClipData(
                    v.tag as? CharSequence,
                    arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                    ClipData.Item(v.tag as? CharSequence)
                )
                val myShadow = View.DragShadowBuilder(v)

                v.startDragAndDrop(dragData, myShadow, v, 0)
            }
        }

        val dragListen = View.OnDragListener {v, event ->
            when(event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    event.clipDescription.hasMimeType((ClipDescription.MIMETYPE_TEXT_PLAIN))
                }
                DragEvent.ACTION_DRAG_ENDED -> true
                DragEvent.ACTION_DRAG_LOCATION -> true
                DragEvent.ACTION_DRAG_EXITED -> true
                DragEvent.ACTION_DROP -> {
                    when (v) {
                        nameCardMakingLayout -> {
                            val tView = event.localState as View
                            ((tView) as ViewGroup).removeView(tView)
                            nameCardMakingLayout.addView(tView)
                            true
                        }
                        else -> {
                            false
                        }
                    }
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    when(event.result) {
                        true -> Log.d(TAG, "Good")
                        else -> Log.d(TAG, "BAD")
                    }
                    true
                }
                else -> false
            }
        }
        nameCardMakingLayout.setOnDragListener(dragListen)

        nameCardMakingImageView = findViewById(R.id.nameCard_making_image_make)

        nameCard_Making_Image_Choose = findViewById(R.id.nameCard_making_image_choose)
        nameCard_Making_Page_Adapter = NameCard_Making_Page_Adapter(this) { imageResId ->
            // 클릭한 이미지 리소스 ID를 ImageView에 로드
            Glide.with(this).load(imageResId).into(nameCardMakingImageView)
        }
        nameCard_Making_Image_Choose.adapter = nameCard_Making_Page_Adapter
        nameCard_Making_Image_Choose.layoutManager = LinearLayoutManager(this)

        nameCard_Making_Image_Choose.addItemDecoration(HorizontalItemDecorator(10))
        nameCard_Making_Image_Choose.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        nameCardMakingImageData.apply {
            add(NameCardMakingImage(making_image = R.drawable.namecard_1))
            add(NameCardMakingImage(making_image = R.drawable.namecard_2))
            add(NameCardMakingImage(making_image = R.drawable.namecard_3))
            add(NameCardMakingImage(making_image = R.drawable.namecard_4))
            add(NameCardMakingImage(making_image = R.drawable.namecard_5))
            add(NameCardMakingImage(making_image = R.drawable.namecard_6))
            add(NameCardMakingImage(making_image = R.drawable.namecard_7))
            add(NameCardMakingImage(making_image = R.drawable.namecard_8))
            add(NameCardMakingImage(making_image = R.drawable.namecard_9))
            add(NameCardMakingImage(making_image = R.drawable.namecard_10))
        }

        nameCard_Making_Page_Adapter.setList(nameCardMakingImageData)
    }
}
