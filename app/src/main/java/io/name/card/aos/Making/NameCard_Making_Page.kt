package io.name.card.aos.Making

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.name.card.aos.Data.NameCardMakingImage
import io.name.card.aos.HorizontalItemDecorator
import io.name.card.aos.Management.NameCard_Making_Page_Adapter
import io.name.card.aos.R

class NameCard_Making_Page : AppCompatActivity() {

    private lateinit var nameCard_Making_Page_Adapter: NameCard_Making_Page_Adapter
    private lateinit var nameCard_making_image_choose: RecyclerView // 리사이클러뷰

    var nameCardMakingImageData = mutableListOf<NameCardMakingImage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.namecard_making)

        initRecycler()
    }

    private fun initRecycler() {
        nameCard_making_image_choose = findViewById(R.id.nameCard_making_image_choose)
        nameCard_Making_Page_Adapter = NameCard_Making_Page_Adapter(this)
        nameCard_making_image_choose.adapter = nameCard_Making_Page_Adapter

        nameCardMakingImageData.apply {
            add(NameCardMakingImage(making_image = R.mipmap.ic_launcher))
            add(NameCardMakingImage(making_image = R.mipmap.ic_launcher))
            add(NameCardMakingImage(making_image = R.mipmap.ic_launcher))
            add(NameCardMakingImage(making_image = R.mipmap.ic_launcher))
        }

        nameCard_making_image_choose.addItemDecoration(HorizontalItemDecorator(10))
    }
}