package home.learn.hmt.learnandroid.ui.screen.topRate.adapter

import androidx.recyclerview.widget.DiffUtil
import home.learn.hmt.learnandroid.model.MovieItem

class DiffUtilCallBack : DiffUtil.ItemCallback<MovieItem>() {
    override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean =
        oldItem.id == newItem.id
}
