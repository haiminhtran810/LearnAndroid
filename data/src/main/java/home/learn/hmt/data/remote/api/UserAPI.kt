package home.learn.hmt.data.remote.api

import home.learn.hmt.data.model.UserEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPI {
    @GET("users/{id}")
    fun getUser(@Path("id") userId: String): Single<UserEntity>
}