package com.riteshgupta.reklaim

import android.view.View
import android.widget.TextView

/**
 * Created by riteshgupta on 23/10/17.
 */


class UserItemModel(val title: String) : ItemModel {

  override val layoutId: Int get() = R.layout.item_user

}

class UserItemViewHolder(view: View) : BaseViewHolder<UserItemModel>(view) {

  private var titleLabel: TextView = bindView(R.id.tv_item_user)

  override fun configure(model: UserItemModel) {
    titleLabel.text = model.title
  }
}
