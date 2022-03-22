package com.larcener.lucky

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class InfoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_info, container, false)
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        var buttonI : ImageView = inflate.findViewById(R.id.backI)
        buttonI.setOnClickListener{
            fragmentTransaction.replace(R.id.frag_view,StartFragment())
            fragmentTransaction.commit()
        }
        return inflate
    }

}