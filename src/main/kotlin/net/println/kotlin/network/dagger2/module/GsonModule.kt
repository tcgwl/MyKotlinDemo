package net.println.kotlin.network.dagger2.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
//2 18 19 24 25 33 /1 10 11
// 19 5 8 4 6 2 18
// 19 6 2 2 1 12 20
// 19 8 5
@Module
class GsonModule {
    @Singleton
    @Provides
    fun gson(): Gson = Gson()
}