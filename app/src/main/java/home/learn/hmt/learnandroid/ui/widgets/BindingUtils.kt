package home.learn.hmt.learnandroid.ui.widgets

import android.os.SystemClock
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import home.learn.hmt.learnandroid.Constants

@BindingAdapter("onRefreshListener")
fun SwipeRefreshLayout.customRefreshListener(listener: SwipeRefreshLayout.OnRefreshListener?) {
    if (listener != null) {
        setOnRefreshListener(listener)
    }
}

@BindingAdapter("isRefreshing")
fun SwipeRefreshLayout.customRefreshing(refreshing: Boolean?) {
    isRefreshing = refreshing == true
}

@BindingAdapter("clickSafe")
fun setClickSafe(view: View, listener: View.OnClickListener?) {
    view.setOnClickListener(object : View.OnClickListener {
        private var mLastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < Constants.THRESHOLD_CLICK_TIME) {
                return
            }
            listener?.onClick(v)
            mLastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

@BindingAdapter("recyclerAdapter")
fun RecyclerView.setRecyclerAdapter(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
    setHasFixedSize(true)
    setAdapter(adapter)
}