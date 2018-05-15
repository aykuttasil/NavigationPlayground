package com.aykutasil.navigationplayground.ui.about


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.aykutasil.navigationplayground.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Proje build edildikten sonra navigation graph içerisinde tanımlanmış olan bu fragment a ait argümanlara aşağıdaki şekilde erişilebilir.
        // androidx.navigation.safeargs plugini kullanıldığı için type-safe parametre geçişi sağlanır.
        val args = AboutFragmentArgs.fromBundle(arguments)
        val ad = args.ad
        val soyad = args.soyad

        Toast.makeText(context, "$ad $soyad", Toast.LENGTH_LONG).show()
    }


}
