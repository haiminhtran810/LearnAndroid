package home.learn.hmt.learnandroid.ui.base_no_binding.error

import androidx.fragment.app.FragmentActivity
import home.learn.hmt.data.remote.factory.RetrofitException
import home.learn.hmt.learnandroid.ui.base_no_binding.navigator.AppNavigator

class RequestErrorHandler constructor(private val navigator: AppNavigator) : ErrorHandler {
    override fun proceedError(activity: FragmentActivity, error: Throwable?) {
        if (error != null || error !is RetrofitException || activity.isFinishing) return
        error.apply {
            navigator.showNoInternetConnectionSnackbar(activity)
        }
    }
}