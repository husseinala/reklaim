package com.riteshgupta.reklaim

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class MainActivityViewModel {

    val users: Array<ItemModel>
        get() {
            return arrayOf(
                    UserItemModel("Apple"),
                    UserItemModel("Orange"),
                    UserItemModel("Guava"),
                    UserItemModel("Banana"),
                    UserItemModel("Pear")
            )
        }
}

class MainActivity : AppCompatActivity() {

    private val viewModel = MainActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = R.id.rv_main.view<RecyclerView>(this)
        rv.adapter = ItemsAdapter(viewModel.users, { layoutId: Int, view: View ->
            when (layoutId) {
                R.layout.item_user -> UserItemViewHolder(view)
                else -> EmptyViewHolder(view)
            }
        })
        rv.layoutManager = LinearLayoutManager(this)
    }
}
