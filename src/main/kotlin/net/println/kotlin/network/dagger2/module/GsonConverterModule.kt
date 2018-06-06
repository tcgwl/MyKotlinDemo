package net.println.kotlin.network.dagger2.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = arrayOf(GsonModule::class))
class GsonConverterModule {
    @Singleton
    @Provides
    fun converter(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)
}