package home.learn.hmt.learnandroid.ui.screen.topRate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.model.MovieItem
import kotlinx.android.synthetic.main.item_movie.view.*

class TopRatePagingAdapter(private val retryCallback: () -> Unit) :
    PagedListAdapter<MovieItem, TopRatePagingAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bindPost(it)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindPost(item: MovieItem) {
        }
    }

}