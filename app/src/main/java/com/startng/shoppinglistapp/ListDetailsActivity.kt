package com.startng.shoppinglistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_list_details.*
import kotlinx.android.synthetic.main.layout_item_view.*


class ListDetailsActivity : AppCompatActivity() {

    lateinit var binding: ListDetailsActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_list_details)

        listname.text = getIntent().getStringExtra("LISTNAME")
        list_description.text = getIntent().getStringExtra("LISTDESCRIPTION")
        image.setImageResource(getIntent().getStringExtra("LISTLOGO").toInt())
    }
}
