package io.name.card.aos.Management

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.name.card.aos.R
import io.name.card.aos.nameCardData

class nameCard_Management : Fragment() {

    private lateinit var namecardManagementAdapter: nameCard_Management_Adapter
    private lateinit var nameCardRecyclerView: RecyclerView

    var nameCardData = mutableListOf<nameCardData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_name_card__management, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameCardRecyclerView = view.findViewById(R.id.recyclerView)
        namecardManagementAdapter = nameCard_Management_Adapter(requireContext())
        nameCardRecyclerView.adapter = namecardManagementAdapter
        nameCardRecyclerView.layoutManager = LinearLayoutManager(context)

        nameCardData.add(nameCardData(R.drawable.ic_launcher_foreground, "김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "010-1234-5678", "010-8765-4321", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(nameCardData(R.drawable.ic_launcher_foreground, "김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "010-1234-5678", "010-8765-4321", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(nameCardData(R.drawable.ic_launcher_foreground, "김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "010-1234-5678", "010-8765-4321", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(nameCardData(R.drawable.ic_launcher_foreground, "김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "010-1234-5678", "010-8765-4321", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(nameCardData(R.drawable.ic_launcher_foreground, "김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "010-1234-5678", "010-8765-4321", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(nameCardData(R.drawable.ic_launcher_foreground, "김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "010-1234-5678", "010-8765-4321", "부산광역시 사하구 낙동대로 550번길 37"))
        nameCardData.add(nameCardData(R.drawable.ic_launcher_foreground, "김범진", "동아대학교", "학부생", "010-5410-1476", "1923673@donga.ac.kr", "010-1234-5678", "010-8765-4321", "부산광역시 사하구 낙동대로 550번길 37"))

        namecardManagementAdapter.setList(nameCardData)
    }

}