package io.name.card.aos.Management

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.name.card.aos.R
import io.name.card.aos.Data.NameCardData
import io.name.card.aos.VerticalItemDecorator

class NameCard_Management : Fragment() {

    private lateinit var nameCardManagementAdapter: NameCard_Management_Adapter // 리사이클러뷰 사용을 위한 어댑터
    private lateinit var nameCardRecyclerView: RecyclerView // 리사이클러뷰

    var nameCardData = mutableListOf<NameCardData>() // 데이터 클래스 가져오기

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_name_card__management, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameCardRecyclerView = view.findViewById(R.id.recyclerView)
        nameCardManagementAdapter = NameCard_Management_Adapter(requireContext())
        nameCardRecyclerView.adapter = nameCardManagementAdapter
        nameCardRecyclerView.layoutManager = LinearLayoutManager(context)
        nameCardRecyclerView.addItemDecoration(VerticalItemDecorator(10))

        // 더미 데이터 생성. API호출 시 삭제
        nameCardData.add(NameCardData("김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(NameCardData("김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(NameCardData("김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(NameCardData("김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(NameCardData("김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(NameCardData("김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(NameCardData("김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "부산광역시 사하구 낙동대로 550번길 37"))

        nameCardManagementAdapter.setList(nameCardData)
    }

}