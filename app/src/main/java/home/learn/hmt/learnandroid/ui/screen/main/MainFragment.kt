package home.learn.hmt.learnandroid.ui.screen.main

import android.os.Bundle
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.databinding.FragmentMainBinding
import home.learn.hmt.learnandroid.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>() {
    override val viewModel by viewModel<MainFragmentViewModel>()
    override val layoutId = R.layout.fragment_main

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        const val TAG = "MainFragment"
        fun newInstance() = MainFragment()
    }

}