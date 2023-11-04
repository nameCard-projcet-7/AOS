package io.name.card.aos.Making

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.name.card.aos.Data.NameCardImage
import io.name.card.aos.R
import io.name.card.aos.Data.nameCardData
import io.name.card.aos.Management.NameCard_Making_Adapter
import io.name.card.aos.Management.VerticalItemDecorator
import io.name.card.aos.Management.nameCard_Management_Adapter

class nameCard_Making : Fragment() {

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

        nameCardRecyclerView = view.findViewById(R.id.recyclerView_making)
        nameCard_Making_Adapter = NameCard_Making_Adapter(requireContext())
        nameCardRecyclerView.adapter = nameCard_Making_Adapter
        nameCardRecyclerView.layoutManager = LinearLayoutManager(context)
        nameCardRecyclerView.addItemDecoration(VerticalItemDecorator(10))

        // 더미 데이터 생성. API호출 시 삭제



        nameCard_Making_Adapter.setList(nameCardImageData)
    }

}
