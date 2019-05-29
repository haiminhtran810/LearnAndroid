package home.learn.hmt.learnandroid.ui.screen.home

import android.os.Bundle
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.databinding.FragmentHomeBinding
import home.learn.hmt.learnandroid.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel by viewModel<HomeViewModel>()
    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }
}