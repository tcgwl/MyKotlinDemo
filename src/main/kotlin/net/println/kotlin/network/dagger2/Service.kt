package net.println.kotlin.network.dagger2

import net.println.kotlin.network.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 使用 dagger 注意
 * 1. 导包
 * 2. apply plugin: 'kotlin-kapt'
 * 3. build
 */
interface GitHubService{
    @GET("/repos/enbandari/Kotlin-Tutorials/stargazers")
    fun getStarGazers(@Query("page") page: Int = 1, @Query("per_page") pageSize: Int = 20): Call<List<User>>
}

object Service {
    val api: GitHubService by lazy {
        DaggerRESTFulComponent
                .builder()
                .build()
                .retrofit()
                .create(GitHubService::class.java)
    }
}

fun main(args: Array<String>) {
    Service.api.getStarGazers().execute().body().map(::println)
}