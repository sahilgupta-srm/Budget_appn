package com.example.budget_tracker

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.map
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.budget_tracker.databinding.ActivityMainBinding
import com.example.budget_tracker.presentation.List_adapter2

import com.example.budget_tracker.presentation.MainActivityViewModel
import com.example.budget_tracker.presentation.MainActivityViewModelFactory
import com.example.budget_tracker.presentation.di.Injector
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject

    lateinit var factory:MainActivityViewModelFactory
    private  lateinit var viewmodel:MainActivityViewModel
    lateinit var adapter:List_adapter
    lateinit var adapter2: List_adapter2
    lateinit var tn:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var binding: ActivityMainBinding =DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as Injector).createviewModelSubComponent().inject(this)
        viewmodel=ViewModelProvider(this,factory).get(MainActivityViewModel::class.java)
        binding.viewmodel=viewmodel
        binding.lifecycleOwner=this
        tn= emptyArray()

        viewmodel.current_value.observe(this){

        }

//                viewmodel.tag.observe(this){
//                    val tagNames = it.map { it.name ?: "" }.toTypedArray()
//                    val adapter= ArrayAdapter<String>(this,R.layout.list_item,tagNames)
//                    binding.dropdownMenu.setAdapter(adapter)
//                    binding.dropdownMenu.setOnItemClickListener {
//                            adapterView, view, i, l ->
//                        val itemselected=adapterView.getItemAtPosition(i)
//                        viewmodel.onItemSelected(itemselected.toString())
//                    }
//                }
        viewmodel.getTagFromDB().observe(this){
            tn = it.map { it.name ?: "" }.toTypedArray()
            Log.i("Mytag",tn.toString())
            val adapter3 = ArrayAdapter<String>(this, R.layout.list_item, tn)
            binding.dropdownMenu.setAdapter(adapter3)

        }

            binding.dropdownMenu.setOnItemClickListener {
                    adapterView, view, i, l ->
                val itemSelected=adapterView.getItemAtPosition(i)
                viewmodel.onItemSelected(itemSelected.toString())
            }

        //Recycler view
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        adapter=List_adapter()
        binding.recyclerView.adapter=adapter
        val responsedata=viewmodel.getEquation()
        responsedata.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT)
            }
        }
        //drawer recycler view
        binding.button2.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
            binding.recyclerViewNavigation.layoutManager=LinearLayoutManager(this)
            adapter2=List_adapter2()
            binding.recyclerViewNavigation.adapter=adapter2
            val data=viewmodel.getTagFromDataBase()
            data.observe(this) {
                if (it != null) {
                    adapter2.setList(it)
                    adapter2.notifyDataSetChanged()
                }
                else{
                    Toast.makeText(this,"No tags created",Toast.LENGTH_LONG).show()
                }
            }


        }
        binding.button3.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            val inflater = LayoutInflater.from(this)
            val dialogView = inflater.inflate(R.layout.dialog_input, null)
            val editText = dialogView.findViewById<EditText>(R.id.editText)

            alertDialogBuilder.setView(dialogView)
            alertDialogBuilder.setTitle("Enter Text")

            alertDialogBuilder.setPositiveButton("Save") { dialog, _ ->
                val a = editText.text.toString()
                viewmodel.saveTagToDatabase(a)
                dialog.dismiss()
            }

            alertDialogBuilder.setNegativeButton("Quit") { dialog, _ ->
                // Handle quitting or canceling
                dialog.dismiss()
            }

            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()

            }
        }

    }
