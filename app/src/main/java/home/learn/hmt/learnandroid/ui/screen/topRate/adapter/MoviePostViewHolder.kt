package home.learn.hmt.learnandroid.ui.screen.topRate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.model.MovieItem

class MoviePostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    init {
        view.setOnClickListener {
        }
    }

    fun bind(item: MovieItem?) {

    }

    companion object {
        fun create(parent: ViewGroup): MoviePostViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
            return MoviePostViewHolder(view)
        }
    }
}