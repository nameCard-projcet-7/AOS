package io.name.card.aos.Making

import android.content.ClipData
import android.content.ClipDescription
import android.os.Build
import android.os.Bundle
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.namecard_making)

        val touchListener = View.OnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val clipText = "This is our ClipData text" // 실제로는 드래그하는 데이터를 여기에 넣음
                val item = ClipData.Item(clipText)
                val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
                val dragData = ClipData(clipText, mimeTypes, item)
                val dragShadowBuilder = View.DragShadowBuilder(view)

                // startDragAndDrop() 메소드를 사용. FLAG_NULL을 통해 어떠한 플래그도 설정안함.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.startDragAndDrop(dragData, dragShadowBuilder, view, 0)
                } else {
                    view.startDrag(dragData, dragShadowBuilder, view, 0)
                }
                view.visibility = View.INVISIBLE // 드래그하는 동안 뷰를 보이지 않게 설정합니다.
                true
            } else {
                false
            }
        }

        val dragListener = View.OnDragListener { v, event ->
            when (event.action) {
                DragEvent.ACTION_DROP -> {
                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)
                    val container = v as RelativeLayout

                    val x = event.x - view.width / 2
                    val y = event.y - view.height / 2

                    // 뷰의 위치를 업데이트합니다.
                    view.x = x
                    view.y = y
                    container.addView(view)
                    view.visibility = View.VISIBLE
                    true
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    // 드래그가 끝났을 때 뷰를 다시 보이게 합니다.
                    val view = event.localState as View
                    view.visibility = View.VISIBLE
                    true
                }
                else -> true
            }
        }

        // 에딧 텍스트 뷰
        val Et_name: EditText = findViewById(R.id.nameCard_making_Et_name)
        val Et_office: EditText = findViewById(R.id.nameCard_making_Et_office)
        val Et_position: EditText = findViewById(R.id.nameCard_making_Et_position)
        val Et_phone: EditText = findViewById(R.id.nameCard_making_Et_phone)
        val Et_email: EditText = findViewById(R.id.nameCard_making_Et_email)
        val Et_address: EditText = findViewById(R.id.nameCard_making_Et_address)


        Et_name.setOnTouchListener(touchListener)
        Et_office.setOnTouchListener(touchListener)
        Et_position.setOnTouchListener(touchListener)
        Et_phone.setOnTouchListener(touchListener)
        Et_email.setOnTouchListener(touchListener)
        Et_address.setOnTouchListener(touchListener)

        val nameCardMakingLayout: RelativeLayout = findViewById(R.id.relativeLayout)
        nameCardMakingLayout.setOnDragListener(dragListener)

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
            add(NameCardMakingImage(making_image = R.mipmap.ic_launcher))
            add(NameCardMakingImage(making_image = R.mipmap.ic_launcher))
            add(NameCardMakingImage(making_image = R.mipmap.ic_launcher))
            add(NameCardMakingImage(making_image = R.mipmap.ic_launcher))
        }

        nameCard_Making_Page_Adapter.setList(nameCardMakingImageData)
    }
}