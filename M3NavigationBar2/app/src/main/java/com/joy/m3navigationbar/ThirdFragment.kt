package com.joy.m3navigationbar

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.Exception

class ThirdFragment : Fragment() {

    private lateinit var onCreateListener: OnFragmentCreateListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    interface OnFragmentCreateListener{
        fun onCreateFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onCreateListener = context as OnFragmentCreateListener
        } catch (e: Exception) {
            throw ClassCastException(context.toString() + " must implement OnImageClickListener.")
        }

    }


}