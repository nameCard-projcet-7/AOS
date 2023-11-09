package io.name.card.aos.Making

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.name.card.aos.Data.NameCardImage
import io.name.card.aos.R
import io.name.card.aos.Management.NameCard_Making_Adapter
import io.name.card.aos.VerticalItemDecorator

class NameCard_Making : Fragment() {

    private lateinit var nameCard_Making_Adapter: NameCard_Making_Adapter // 리사이클러뷰 사용을 위한 어댑터
    private lateinit var nameCardRecyclerView: RecyclerView // 리사이클러뷰

    var nameCardImageData = mutableListOf<NameCardImage>() // 데이터 클래스 가져오기

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_name_card__making, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameCardMakingButton : Button = view.findViewById(R.id.nameCard_making_Button)

        nameCardMakingButton.setOnClickListener {
            val intent = Intent(activity, NameCard_Making_Page::class.java)
            startActivity(intent)
        }

        nameCardRecyclerView = view.findViewById(R.id.recyclerView_making)
        nameCard_Making_Adapter = NameCard_Making_Adapter(requireContext())
        nameCardRecyclerView.adapter = nameCard_Making_Adapter
        nameCardRecyclerView.layoutManager = LinearLayoutManager(context)
        nameCardRecyclerView.addItemDecoration(VerticalItemDecorator(10))

        // 더미 데이터 생성. API호출 시 삭제
        nameCardImageData.add(NameCardImage(image = R.drawable.ic_launcher_background))
        nameCardImageData.add(NameCardImage(image = R.drawable.ic_launcher_background))


        nameCard_Making_Adapter.setList(nameCardImageData)
    }

}
