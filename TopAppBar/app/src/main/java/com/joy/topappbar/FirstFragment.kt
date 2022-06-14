package com.joy.topappbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.joy.topappbar.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        binding.topAppBar.setOnMenuItemClickListener {  menuItem ->
            if(menuItem.itemId == R.id.mi_forward){
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            }
            true
        }

        return binding.root
    }




}