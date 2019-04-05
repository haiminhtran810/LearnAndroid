package home.learn.hmt.data.di

import home.learn.hmt.data.BuildConfig
import home.learn.hmt.data.di.Properties.TIME_OUT
import home.learn.hmt.data.remote.api.RapidAPI
import home.learn.hmt.data.remote.factory.RxErrorHandlingCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val netWorkModule = module {
    single(name = "logging") { createLoggingInterceptor() }
    single(name = "header") { createHeaderInterceptor() }
    single { createOkHttpClient(get(name = "logging"), get(name = "header")) }
    single { createAppRetrofit(get()) }
    single { createUserApi(get()) }
}

object Properties {
    const val TIME_OUT = 10
}

fun createLoggingInterceptor(): Interceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
    else HttpLoggingInterceptor.Level.NONE
    return logging
}

fun createHeaderInterceptor(
): Interceptor {
    return Interceptor { chain ->
        val request = chain.request()
        val newUrl = request.url().newBuilder()
//            .addQueryParameter("api_key", "")
            .build()
        val newRequest = request.newBuilder()
            .url(newUrl)
            .header("Content-Type", "application/json")
            .header("X-RapidAPI-Host", BuildConfig.KEY_RAPID_HOST)
            .header("X-RapidAPI-Key", BuildConfig.KEY_RAPID)
            .method(request.method(), request.body())
            .build()
        chain.proceed(newRequest)
    }
}

fun createOkHttpClient(
    logging: Interceptor,
    header: Interceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        .addInterceptor(header)
        .addInterceptor(logging)
        .build()
}


fun createAppRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()
}

fun createUserApi(retrofit: Retrofit): RapidAPI {
    return retrofit.create(RapidAPI::class.java)
}