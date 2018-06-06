package net.println.kotlin.network.dagger2.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = arrayOf(BaseUrlModule::class, OkHttpClientModule::class, GsonConverterModule::class, RxAdapterModule::class))
class RetrofitModule {
    @Singleton
    @Provides
    fun retrofit(
            baseUrl: String,
            okHttpClient: OkHttpClient,
            converterFactory: Converter.Factory,
            adapterFactory: CallAdapter.Factory): Retrofit
            = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .build()
}