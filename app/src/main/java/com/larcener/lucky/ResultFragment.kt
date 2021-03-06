package com.larcener.lucky

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class ResultFragment : Fragment() {
    lateinit var text : TextView
    lateinit var button : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var inflate = inflater.inflate(R.layout.fragment_result, container, false)
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val args = this.arguments
        val x = args?.get("res")
        button = inflate.findViewById(R.id.rstrt)
        text = inflate.findViewById(R.id.resuu)
        if(x==0){
            text.text = "You Lose"
        }else{
            text.text = "You Won\n"+x.toString()
        }
        button.setOnClickListener {
            fragmentTransaction.replace(R.id.frag_view, GameFragment())
            fragmentTransaction.commit()
        }
        return inflate
    }

}