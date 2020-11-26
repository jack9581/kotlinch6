package com.example.kotlinlab6

import android.content.ClipData
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.SpinnerAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.trans_list.*
import kotlinx.android.synthetic.main.trans_list.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data class item(val image: Int,val name: String)
        val items1 = ArrayList<item>()
        val items2 = ArrayList<item>()
        val  transArray =intArrayOf(R.drawable.trans1,R.drawable.trans2,R.drawable.trans3,R.drawable.trans4,R.drawable.trans5,R.drawable.trans6)
        val  transnameArray=arrayOf("腳踏車","機車","汽車","巴士","飛機","船")
        for(i in 0 until 6)
            items1.add(item(transArray[i], transnameArray[i]))
        val  cubeeArray =intArrayOf(R.drawable.cubee1,R.drawable.cubee2,R.drawable.cubee3,R.drawable.cubee4,R.drawable.cubee5,
                R.drawable.cubee6,R.drawable.cubee7,R.drawable.cubee8,R.drawable.cubee9,R.drawable.cubee10)
        val  cubeenameArray=arrayOf("哭哭","發抖","再見","生氣","昏倒","竊笑","很棒","你好","驚嚇","大笑")
        for(i in 0 until 10)
            items2.add(item(cubeeArray[i], cubeenameArray[i]))
        class myadpater constructor( val layout: Int, val data: ArrayList<item>):BaseAdapter(){
            override fun getCount()=data.size

            override fun getItem(position: Int)= data[position]

            override fun getItemId(position: Int)=0L

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val view = View.inflate(parent?.context, layout, null)
                view.img_photo.setImageResource(data[position].image)
                view.tv_name.text = data[position].name
                return view

            }
        }
        spinner.adapter=myadpater(R.layout.trans_list,items1)
        gridview.numColumns = 3
        gridview.adapter = myadpater(R.layout.cubee_list, items2)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                arrayListOf("訊息1","訊息2","訊息3","訊息4","訊息5","訊息6"))



    }
}