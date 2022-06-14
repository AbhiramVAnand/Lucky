
package com.larcener.lucky

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment


class StartFragment : Fragment() {
    lateinit var button : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_start, container, false)
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val score : TextView = inflate.findViewById(R.id.score)
        val context = requireActivity().applicationContext
        val pref = context.getSharedPreferences("com.larcener.lucky", Context.MODE_PRIVATE)
        pref.edit().putInt("score", 200).apply()
        val hsc : Int = pref.getInt("score",0)
        score.text = "Score: $hsc"
        button = inflate.findViewById(R.id.start)
        var buttonI : ImageView = inflate.findViewById(R.id.infoi)
        buttonI.setOnClickListener{
            fragmentTransaction.replace(R.id.frag_view,InfoFragment())
            fragmentTransaction.commit()
        }
        button.setOnClickListener {
            fragmentTransaction.replace(R.id.frag_view,GameFragment())
            fragmentTransaction.commit()
        }
        return inflate
    }
}

