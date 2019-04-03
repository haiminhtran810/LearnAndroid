package home.learn.hmt.data.di

import com.google.gson.Gson
import home.learn.hmt.data.Constants
import home.learn.hmt.data.MusicRepositoryImpl
import home.learn.hmt.data.local.pref.AppPrefs
import home.learn.hmt.data.local.pref.PrefHelper
import home.learn.hmt.domain.repository.MusicRepository
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

val repositoryModule = module {
    single { createDatabaseName() }
    single<PrefHelper> { create<AppPrefs>() }
    single { Gson() }
    single<MusicRepository> { create<MusicRepositoryImpl>() }
}


fun createDatabaseName() = Constants.DATABASE_NAME
