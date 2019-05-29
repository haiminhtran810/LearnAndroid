package home.learn.hmt.learnandroid.ui.base_no_binding.navigator

import android.app.Activity
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.snackbar.Snackbar

class AppNavigator : Navigator() {
    override fun overridePendingTransition(activity: Activity, animationType: AnimationType) {
        // TODO: Implement this
    }

    override fun setCustomAnimation(transition: FragmentTransaction, animationType: AnimationType) {
        // TODO: Implement this
    }

    fun showNoInternetConnectionSnackbar(activity: Activity) {
        showErrorSnackbar(activity, "no Internet")
    }

    fun showErrorSnackbar(activity: Activity, errorMsg: String) {
        showSnackBar(activity, errorMsg)
    }

    fun showSnackBar(
        activity: Activity, message: String, action: String? = null,
        actionListener: View.OnClickListener? = null, duration: Int = Snackbar.LENGTH_SHORT
    ) {

    }
}