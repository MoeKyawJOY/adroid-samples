package com.joy.m3navigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), ThirdFragment.OnFragmentCreateListener {

    private lateinit var bottomNav: BottomNavigationView
    private lateinit var appBarConfig: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreateFragment() {
        bottomNav.selectedItemId = R.id.mi_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_nav)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNav.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.mi_home -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.action_global_firstFragment)
                }
                R.id.mi_message ->{
                    findNavController(R.id.fragmentContainerView).navigate(R.id.action_global_secondFragment)
                }
                R.id.mi_history -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.action_global_thirdFragment)
                }

            }

            true
        }

        var badge = bottomNav.getOrCreateBadge(R.id.mi_message)
        badge.isVisible = true



    }



}