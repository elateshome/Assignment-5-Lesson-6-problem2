package com.example.assignment_5_lesson_6_problem2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = ArrayList<Product>()

        list.add(Product("RGA Voyger 7 16 GB Android tablet", 35.00, "Black", R.drawable.phone, "3", "item detail goes here"))
        list.add(Product("HP Flyer Red 15 Laptop", 299.00, "Black & Red", R.drawable.laptop, "4", "item detail goes here"))
        list.add(Product("Vizio 70 classic 4k", 1298.00, "Black", R.drawable.tv, "5", "item detail goes here"))
        list.add(Product("Epson WorkForce WF-2750", 69.00, "Black", R.drawable.printer, "6", "item detail goes here"))

        product_recycler.layoutManager = LinearLayoutManager(this)
        val adaptor = MyAdaptor(list, this)

        product_recycler.adapter = adaptor
    }

    override fun onItemClicked(product: Product) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("image", product.image)
        intent.putExtra("title", product.title)
        intent.putExtra("color", product.color)
        intent.putExtra("itemId", product.itemId)
        intent.putExtra("description", product.desc)

        startActivity(intent)
    }
}