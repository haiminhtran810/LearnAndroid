package home.learn.hmt.learnandroid.ui.base_no_binding.error

import androidx.fragment.app.FragmentActivity

interface ErrorHandler {
    fun proceedError(activity: FragmentActivity, error: Throwable?)
}