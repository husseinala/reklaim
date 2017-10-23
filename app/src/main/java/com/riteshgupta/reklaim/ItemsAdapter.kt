package com.riteshgupta.reklaim

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by riteshgupta on 23/10/17.
 */

interface ItemModel {
    val layoutId: Int
}

interface ItemView<in Model : ItemModel> {
    fun configure(model: Model)
}

open class ItemsAdapter(
        private val items: Array<ItemModel>,
        private val itemViewForLayoutId: ((Int, View) -> RecyclerView.ViewHolder)): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return itemViewForLayoutId(viewType, parent.loadLayout(viewType))
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemView<*>) {
            val cell = holder as ItemView<ItemModel>
            val model = items[position]
            cell.configure(model)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].layoutId
    }

    override fun getItemCount(): Int {
        return items.count()
    }

}

abstract class BaseViewHolder<in Model : ItemModel>(view: View) : RecyclerView.ViewHolder(view), ItemView<Model>

class EmptyViewHolder(view: View) : RecyclerView.ViewHolder(view)