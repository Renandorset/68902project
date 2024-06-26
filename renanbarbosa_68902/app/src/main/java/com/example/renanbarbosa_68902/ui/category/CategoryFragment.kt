package com.example.renanbarbosa_68902.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.renanbarbosa_68902.R
import com.example.renanbarbosa_68902.adapters.NavCategoryAdapter
import com.example.renanbarbosa_68902.models.NavCategoryModel
import com.google.firebase.firestore.FirebaseFirestore

class CategoryFragment : Fragment() {
    var db: FirebaseFirestore? = null
    var recyclerView: RecyclerView? = null
    var categoryModelList: MutableList<NavCategoryModel>? = null
    var navCategoryAdapter: NavCategoryAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_category, container, false)
        db = FirebaseFirestore.getInstance()
        recyclerView = root.findViewById(R.id.categoryRec)
        recyclerView?.setLayoutManager(LinearLayoutManager(activity, RecyclerView.VERTICAL, false))
        categoryModelList = ArrayList()
        navCategoryAdapter = NavCategoryAdapter(requireActivity(),
            categoryModelList as ArrayList<NavCategoryModel>
        )
        recyclerView?.setAdapter(navCategoryAdapter)
        db!!.collection("NavCategory")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        val navCategoryModel = document.toObject(
                            NavCategoryModel::class.java
                        )
                        categoryModelList?.add(navCategoryModel)
                        navCategoryAdapter!!.notifyDataSetChanged()
                    }
                } else {
                    Toast.makeText(activity, "Error: " + task.exception, Toast.LENGTH_SHORT).show()
                }
            }
        return root
    }
}
