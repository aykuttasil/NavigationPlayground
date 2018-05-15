package com.aykutasil.navigationplayground.ui.deeplink


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.aykutasil.navigationplayground.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DeepLinkFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_deep_link, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}
