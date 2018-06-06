package net.println.kotlin.network.dagger2.module

import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import javax.inject.Singleton

@Module
class RxAdapterModule {
    @Singleton
    @Provides
    fun adapter(): CallAdapter.Factory = RxJavaCallAdapterFactory.create()
}