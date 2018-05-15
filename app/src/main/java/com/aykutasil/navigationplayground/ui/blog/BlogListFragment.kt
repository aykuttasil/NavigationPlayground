package com.aykutasil.navigationplayground.ui.blog


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.aykutasil.navigationplayground.R
import kotlinx.android.synthetic.main.fragment_blog_list.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BlogListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blog_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBlogDetail.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_blogListFragment_to_blogDetailFragment)
        }
    }


}
