package com.larcener.lucky

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import java.lang.Exception

class GameFragment : Fragment() {
    lateinit var button : Button
    lateinit var e : Exception
    lateinit var One : String
    lateinit var Two : String
    lateinit var Three : String
    var  x : Int = 0

    fun guess() : Int{
        val rnds : Int = (0..10).random()
        return rnds
    }
    fun game(a:Int, b:Int, c:Int, s:Int):Int{
        var res : Int = 0
        if(s<11){
            res = res + 2*a
        }
        if(s==11){
            res = res + 2*b
        }
        if(s>11){
            res = res + 2*c
        }
        return res
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_game, container, false)
        button = inflate.findViewById(R.id.bidbutton)
        val bOne : EditText = inflate.findViewById(R.id.bidl)
        val bTwo : EditText = inflate.findViewById(R.id.bidlt)
        val bThree : EditText = inflate.findViewById(R.id.bidgt)

//Bundle and value passing

        button.setOnClickListener {
            One = bOne.text.toString()
            Two = bTwo.text.toString()
            Three = bThree.text.toString()
            var a : Int
            var b : Int
            var c : Int
            if(One.isEmpty()){
                a = 0
            }else{
                a = Integer.parseInt(One)
            }
            if(Two.isEmpty()){
                b = 0
            }else{
                b = Integer.parseInt(Two)
            }
            if(Three.isEmpty()){
                c = 0
            }else{
                c = Integer.parseInt(Three)
            }
            var gOne : Int = guess()
            var gTwo : Int = guess()
            var sum : Int = gOne+gTwo
            x = game(a,b,c,sum)
            val bundle = Bundle()
            bundle.putInt("res",x)
            val frag = ResultFragment()
            frag.arguments = bundle
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frag_view, frag)
            fragmentTransaction.commit()
        }
        return inflate
    }

}