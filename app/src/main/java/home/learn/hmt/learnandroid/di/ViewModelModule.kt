package home.learn.hmt.learnandroid.di

import home.learn.hmt.learnandroid.ui.screen.topRate.TopRateViewModel
import home.learn.hmt.learnandroid.ui.screen.MainViewModel
import home.learn.hmt.learnandroid.ui.screen.main.MainFragmentViewModel
import home.learn.hmt.learnandroid.ui.screen.newRelease.NewReleaseViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel<MainViewModel>()
    viewModel<TopRateViewModel>()
    viewModel<MainFragmentViewModel>()
    viewModel<NewReleaseViewModel>()
}