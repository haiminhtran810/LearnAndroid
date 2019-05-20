package home.learn.hmt.learnandroid.ui.screen.topRate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.databinding.ItemArtistBinding
import home.learn.hmt.learnandroid.databinding.ItemMovieBinding
import home.learn.hmt.learnandroid.model.MovieItem
import home.learn.hmt.learnandroid.ui.base.BaseRecyclerAdapter

class TopRateAdapter(val itemClickListener: (MovieItem) -> Unit = {}) :
    BaseRecyclerAdapter<MovieItem, ItemMovieBinding>(object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun bind(binding: ItemMovieBinding, item: MovieItem) {
        binding?.apply {
            data = item
            txtStt.text = itemCount.toString()
            root.setOnClickListener {
                item?.apply {
                    itemClickListener(this)
                }
            }
        }
    }

    override fun createBinding(parent: ViewGroup): ItemMovieBinding {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_movie, parent, false)
    }


}