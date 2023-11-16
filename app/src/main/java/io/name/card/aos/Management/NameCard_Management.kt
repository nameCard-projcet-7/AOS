package io.name.card.aos.Management

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.name.card.aos.API.RetrofitClient
import io.name.card.aos.R
import io.name.card.aos.Data.NameCardData
import io.name.card.aos.VerticalItemDecorator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        getNameCardData()
    }

    private fun getNameCardData() {
        val call = RetrofitClient.apiService.getNameCardData()

        call.enqueue(object : Callback<NameCardData> {
            override fun onResponse(call: Call<NameCardData>, response: Response<NameCardData>) {
                if (response.isSuccessful) {
                    val nameCardResponse = response.body()
                    nameCardResponse?.let {
                        val list = mutableListOf(it)  // 단일 객체를 리스트로 변환
                        activity?.runOnUiThread {
                            nameCardManagementAdapter.setList(list)  // 어댑터 인스턴스를 사용
                        }
                    }
                }
            }

            override fun onFailure(call: Call<NameCardData>, t: Throwable) {
                Log.e("Debug", "API call failed with exception ", t)
            }
        })
    }


}