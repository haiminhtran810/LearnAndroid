package home.learn.hmt.learnandroid.di

import home.learn.hmt.learnandroid.ui.screen.search.SearchArtistViewModel
import home.learn.hmt.learnandroid.ui.screen.home.HomeViewModel
import home.learn.hmt.learnandroid.ui.screen.main.MainViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel<MainViewModel>()
    viewModel<HomeViewModel>()
    viewModel<SearchArtistViewModel>()
}