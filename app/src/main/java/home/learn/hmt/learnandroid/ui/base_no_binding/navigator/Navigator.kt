package home.learn.hmt.learnandroid.ui.base_no_binding.navigator

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.*

abstract class Navigator {
    enum class AnimationType(val type: Int) {
        NONE(0), RIGHT_LEFT(1), LEFT_RIGHT(2), BOTTOM_UP(3), TOP_DOWN(4), FADED(5)
    }

    abstract fun overridePendingTransition(activity: Activity, animationType: AnimationType)

    abstract fun setCustomAnimation(transition: FragmentTransaction, animationType: AnimationType)

    protected fun commitTransaction(
        transaction: FragmentTransaction,
        addToBackStack: Boolean = false, transit: Int = FragmentTransaction.TRANSIT_NONE
    ) {
        if (addToBackStack) transaction.addToBackStack(null)
        if (transit != -1) transaction.setTransition(transit)
        transaction.commit()
    }

    //region Activity
    fun startActivity(
        activity: Activity, clazz: Class<out Activity>, bundle: Bundle? = null,
        animation: AnimationType = AnimationType.NONE
    ) {
        val intent = Intent(activity, clazz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivity(intent)
        overridePendingTransition(activity, animation)
    }

    fun startActivityForResult(
        fragment: Fragment, clazz: Class<out Activity>,
        bundle: Bundle? = null, requestCode: Int
    ) {
        val intent = Intent(fragment.context, clazz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        fragment.startActivityForResult(intent, requestCode)
    }

    fun startActivityForResult(
        activity: Activity, clazz: Class<out Activity>,
        bundle: Bundle? = null, requestCode: Int
    ) {
        val intent = Intent(activity, clazz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivityForResult(intent, requestCode)
    }

    fun startActivityAtRoot(
        context: Context, clazz: Class<out Activity>,
        bundle: Bundle?
    ) {
        val intent = Intent(context, clazz)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        context.startActivity(intent)
    }

    fun bringActivityToTop(
        context: Context, clazz: Class<out Activity>,
        bundle: Bundle?
    ) {
        val intent = Intent(context, clazz)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        context.startActivity(intent)
    }

    fun startNewActivity(activity: Activity, clazz: Class<out Activity>) {
        startActivity(activity, clazz)
        activity.finish()
    }

    fun finishActivityWithResult(activity: Activity, intent: Intent, resultCode: Int) {
        activity.setResult(resultCode, intent)
        activity.finish()
    }

    fun finishActivity(activity: Activity, animation: AnimationType = AnimationType.NONE) {
        activity.finish()
        overridePendingTransition(activity, animation)
    }

    fun addFragment(
        fragmentManager: FragmentManager,
        fragment: Fragment, frameId: Int, addToBackStack: Boolean = false, tag: String? = null,
        bundle: Bundle? = null
    ) {
        val transaction = fragmentManager.beginTransaction()
        if (fragment.arguments == null) {
            fragment.arguments = bundle
        }
        transaction.add(frameId, fragment, tag)
        commitTransaction(transaction, addToBackStack)
    }

    fun showFragment(
        fragmentManager: FragmentManager,
        fragment: Fragment, addToBackStack: Boolean = false
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.show(fragment)
        commitTransaction(transaction, addToBackStack)
    }

    fun hideFragment(
        fragmentManager: FragmentManager,
        fragment: Fragment, addToBackStack: Boolean = false
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.hide(fragment)
        commitTransaction(transaction, addToBackStack)
    }

    fun getCurrentFragment(activity: Activity, @IdRes containerViewId: Int): Fragment? {
        return (activity as FragmentActivity).supportFragmentManager.findFragmentById(
            containerViewId
        )
    }

    //

    //region Fragment
    fun findFragment(activity: Activity, TAG: String): Fragment? {
        return (activity as FragmentActivity).supportFragmentManager.findFragmentByTag(TAG)
    }

    fun findChildFragment(parentFragment: Fragment, TAG: String): Fragment? {
        return parentFragment.childFragmentManager.findFragmentByTag(TAG)
    }

    fun replaceFragment(
        activity: Activity, containerViewId: Int, fragment: Fragment, TAG: String?,
        addToBackStack: Boolean = false, transit: Int = -1
    ) {
        val transaction = (activity as FragmentActivity).supportFragmentManager!!.beginTransaction()
            .replace(containerViewId, fragment, TAG)
        commitTransaction(transaction, addToBackStack, transit)
    }

    fun replaceChildFragment(
        parentFragment: Fragment, containerViewId: Int,
        fragment: Fragment, TAG: String?, addToBackStack: Boolean = false, transit: Int = -1
    ) {
        val transaction = parentFragment.childFragmentManager.beginTransaction().replace(
            containerViewId, fragment, TAG
        )
        commitTransaction(transaction, addToBackStack, transit)
    }

    fun addChildFragment(
        parentFragment: Fragment, containerViewId: Int,
        targetFragment: Fragment, TAG: String?, addToBackStack: Boolean = false,
        transit: Int = -1, animationType: AnimationType = AnimationType.NONE
    ) {
        val transaction = parentFragment.childFragmentManager.beginTransaction()
        setCustomAnimation(transaction, animationType)
        transaction.add(containerViewId, targetFragment, TAG)
        commitTransaction(transaction, addToBackStack, transit)
    }

    fun removeFragment(activity: Activity, fragment: Fragment) {
        (activity as FragmentActivity).supportFragmentManager.beginTransaction().remove(
            fragment
        ).commit()
    }

    fun popFragment(activity: Activity) {
        (activity as FragmentActivity).supportFragmentManager.popBackStack()
    }

    fun popAllFragment(fragmentManager: FragmentManager) {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fun popFragmentImmediate(activity: Activity) {
        (activity as FragmentActivity).supportFragmentManager.popBackStackImmediate()
    }

    // fixme remember update later
    fun popFragments(activity: Activity, number: Int) {
        for (i in 0..number) {
            (activity as FragmentActivity).supportFragmentManager.popBackStackImmediate()
        }
    }

    fun popChildFragment(parentFragment: Fragment?) {
        parentFragment?.childFragmentManager?.popBackStack()
    }

    fun showDialogFragment(
        dialogFragment: DialogFragment, fragmentManager: FragmentManager,
        tag: String
    ) {
        dialogFragment.show(fragmentManager, tag)
    }

    fun startActivityFromFragment(
        activity: FragmentActivity, clazz: Class<out Activity>,
        finishActivity: Boolean = true
    ) {
        startActivity(activity, clazz)
        if (finishActivity)
            activity.finish()
    }

    fun showLastFragmentInBackStack(fragment: Fragment?) {
        fragment?.childFragmentManager?.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
    //endregion
}