package com.joy.menusexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.ListPopupWindow
import com.joy.menusexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.tvContextMeus)

        binding.btnShowPopup.setOnClickListener {
            showPopUpMenu(it)
        }

        binding.btnShowListPopup.setOnClickListener {
            showListPopupMenu(it)
        }

    }

    private fun showPopUpMenu(view: View){
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {  menuItem ->
            when(menuItem.itemId){
                R.id.mi_red -> view.setBackgroundColor(resources.getColor(R.color.red))
                R.id.mi_blue -> view.setBackgroundColor(resources.getColor(R.color.blue))
                R.id.mi_green -> view.setBackgroundColor(resources.getColor(R.color.green))

            }

            return@setOnMenuItemClickListener true
        }

        popupMenu.show()
    }

    private fun showListPopupMenu(view: View){
        val listPopupWindow = ListPopupWindow(this, null, com.google.android.material.R.attr.listPopupWindowStyle)
        listPopupWindow.anchorView = view

        val item = listOf<String>("Item1", "Item2", "Item3", "Item4")
        val adapter = ArrayAdapter(this, R.layout.list_popup_window_item, item)

        listPopupWindow.setAdapter(adapter)

        listPopupWindow.setOnItemClickListener{ parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            when(position+1){
                1 -> {
                    Toast.makeText(this, "Item1 clicked", Toast.LENGTH_SHORT).show()
                }
                2 -> {
                    Toast.makeText(this, "Item2 clicked", Toast.LENGTH_SHORT).show()
                }
                3 -> {
                    Toast.makeText(this, "Item3 clicked", Toast.LENGTH_SHORT).show()
                }
                4 -> {
                    Toast.makeText(this, "Item4 clicked", Toast.LENGTH_SHORT).show()
                }
            }
            listPopupWindow.dismiss()
        }

        listPopupWindow.show()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.mi_search -> {
                Toast.makeText(this, "Searching..", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.mi_add -> {
                Toast.makeText(this, "Added..", Toast.LENGTH_SHORT).show()
                return true
            }


        }

        return super.onOptionsItemSelected(item)
    }

    // For context menu
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu?.add("Hide")
            ?.setOnMenuItemClickListener {
                Toast.makeText(this, "The text is going to hide", Toast.LENGTH_SHORT).show()
                true
            }

        menu?.add("Delete")
            ?.setOnMenuItemClickListener {
                Toast.makeText(this, "The text is going to hide", Toast.LENGTH_SHORT).show()
                true
            }

        super.onCreateContextMenu(menu, v, menuInfo)
    }

}