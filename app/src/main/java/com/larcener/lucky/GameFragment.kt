package com.larcener.lucky

import android.os.Bundle
import android.os.TokenWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.view.OneShotPreDrawListener
import java.lang.Exception
import java.util.concurrent.ThreadPoolExecutor

class GameFragment : Fragment() {
    lateinit var button : Button
    lateinit var e : Exception
    var One : Int = 0
    var Two : Int = 0
    var  Three : Int = 0
    var  x : Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_game, container, false)
        button = inflate.findViewById(R.id.bidbutton)

        try{
            val bOne : EditText = inflate.findViewById(R.id.bidl)
            val bTwo : EditText = inflate.findViewById(R.id.bidlt)
            val bThree : EditText = inflate.findViewById(R.id.bidgt)
            One = Integer.parseInt( bOne.getText().toString() );
            Two = Integer.parseInt( bTwo.getText().toString() );
            Three = Integer.parseInt( bThree.getText().toString() );
            x = One+Two+Three
        }catch(e : NumberFormatException){
            print(e)
        }
//Bundle and value passing
        val bundle = Bundle()
        bundle.putInt("res",x)
        val frag = EndFragment()
        frag.arguments = bundle
        button.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frag_view, frag)
            fragmentTransaction.commit()
        }
        return inflate
    }

}