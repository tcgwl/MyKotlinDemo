package net.println.kotlin.network.dagger2

import dagger.Component
import net.println.kotlin.network.dagger2.module.RetrofitModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RetrofitModule::class))
interface RESTFulComponent {
    fun retrofit(): Retrofit
}