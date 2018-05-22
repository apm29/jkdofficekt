package com.shirly.apm29.jkdofficekt.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shirly.apm29.jkdofficekt.model.bean.Vehicle

class VehicleListActivity : AppCompatActivity() {

    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView = RecyclerView(this)
        setContentView(recyclerView)

        val str = "[\n" +
                "            {\n" +
                "                \"allow_field\": \"model,purchase_date\",\n" +
                "                \"id\": \"14\",\n" +
                "                \"license\": \"safasfa\",\n" +
                "                \"colour\": \"红\",\n" +
                "                \"brand\": \"宝马\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"allow_field\": \"model,purchase_date\",\n" +
                "                \"id\": \"15\",\n" +
                "                \"license\": \"safasfa\",\n" +
                "                \"colour\": \"红1\",\n" +
                "                \"brand\": \"宝马2\"\n" +
                "            }\n" +
                "        ]"
        val vehicles = Gson().fromJson<List<Vehicle>>(str,object :TypeToken<List<Vehicle>>(){}.type)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = object :RecyclerView.Adapter<BindingHolder>(){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
                return BindingHolder(TextView(parent.context).apply {
                    this.text = "123"
                })
            }

            override fun getItemCount(): Int {
                return vehicles.size
            }

            override fun onBindViewHolder(holder: BindingHolder, position: Int) {
            }

            override fun getItemViewType(position: Int): Int {
                return super.getItemViewType(position)
            }
        }


    }
    class BindingHolder(view:View) :RecyclerView.ViewHolder(view)
}
