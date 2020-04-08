package com.startng.shoppinglistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.startng.shoppinglistapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnListItemClickListener{

    lateinit var binding: ActivityMainBinding
    lateinit var shoplist: ArrayList<Lists>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        shoplist = ArrayList()
        addLists()

        listRecycler.layoutManager = LinearLayoutManager(this)
        listRecycler.addItemDecoration(DividerItemDecoration(this, 1))
        listRecycler.adapter = ListAdapter(shoplist, this)
    }
    fun addLists () {
        shoplist.add(Lists("Bread", "Bread for breakfast with tea and butter, i have to buy this one, ",R.drawable.bread))
        shoplist.add(Lists("Butter", "Butter for breakfast with bread and tea, i have to buy this one, ",R.drawable.butter))
        shoplist.add(Lists("Sugar", "Sugar for breakfast with tea and bread with butter, i have to buy this one, ",R.drawable.sugar))
        shoplist.add(Lists("Milk", "Milk for breakfast to prepare tea, i have to buy this one, ",R.drawable.milk))
        shoplist.add(Lists("Milo", "Milo for breakfast to prepare tea, i have to buy this one, ",R.drawable.milo))
        shoplist.add(Lists("Soap", "Soap for washing of plate, i have to buy this one, ",R.drawable.soap))
        shoplist.add(Lists("Detergent", "Detergent for washing of cloth, i have to buy this one, ",R.drawable.detergent))
    }

    override fun onItemClick(item: Lists, Position: Int) {
        TODO("Not yet implemented")
        val intent = Intent(this, ListDetailsActivity::class.java)
        intent.putExtra("LISTNAME",item.name)
        intent.putExtra("LISTDESCRIPTION",item.description)
        intent.putExtra("LISTLOGO",item.logo.toString())
        startActivity(intent)
    }
}