package home.learn.hmt.learnandroid.ui.screen.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.databinding.ItemArtistBinding
import home.learn.hmt.learnandroid.model.ArtistItem
import home.learn.hmt.learnandroid.ui.base.BaseRecyclerAdapter

class SearchArtistAdapter(val itemClickListener: (ArtistItem) -> Unit = {}) :
    BaseRecyclerAdapter<ArtistItem, ItemArtistBinding>(object : DiffUtil.ItemCallback<ArtistItem>() {
        override fun areItemsTheSame(oldItem: ArtistItem, newItem: ArtistItem): Boolean {
            return oldItem.artistId == newItem.artistId
        }

        override fun areContentsTheSame(oldItem: ArtistItem, newItem: ArtistItem): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun createBinding(parent: ViewGroup): ItemArtistBinding {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_artist, parent, false)
    }

    override fun bind(binding: ItemArtistBinding, item: ArtistItem) {
        binding?.apply {
            itSearch.text = item.artistName ?: ""
            root.setOnClickListener {
                item?.apply {
                    itemClickListener(this)
                }
            }
        }
    }
}