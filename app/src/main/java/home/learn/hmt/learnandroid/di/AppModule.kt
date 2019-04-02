package home.learn.hmt.learnandroid.di

import home.learn.hmt.data.di.entityMapperModule
import home.learn.hmt.data.di.netWorkModule
import home.learn.hmt.data.di.repositoryModule
import home.learn.hmt.domain.di.useCaseModule
import home.learn.hmt.learnandroid.rx.AppSchedulerProvider
import home.learn.hmt.learnandroid.rx.SchedulerProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val appModule = module {
    single { androidApplication().resources }
    single<SchedulerProvider> { AppSchedulerProvider() }
}

val modules = listOf(
    entityMapperModule,
    netWorkModule,
    repositoryModule,
    useCaseModule,
    appModule,
    itemMapperModule,
    viewModelModule
)