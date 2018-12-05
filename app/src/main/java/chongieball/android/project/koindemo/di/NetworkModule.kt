package net.abcargo.tms.koinviewmodeldemo.di

import chongieball.android.project.koindemo.data.network.GithubService
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

val networkModule = module {

    single { provideHttpLoggingInterceptor() }
    single { provideOkhttpClient(get()) }
    single { createWebService<GithubService>(get()) }
}

fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Timber.i(it) })
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}

fun provideOkhttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .client(okHttpClient)
        .build()

    return retrofit.create(T::class.java)
}