package home.learn.hmt.data

import home.learn.hmt.data.model.mapper.UserEntityMapper
import home.learn.hmt.data.remote.api.UserAPI
import home.learn.hmt.domain.model.User
import home.learn.hmt.domain.repository.UserRepository
import io.reactivex.Single

class UserRepositoryImpl constructor(
    private val userApi: UserAPI,
    private val userMapper: UserEntityMapper
) : UserRepository {
    override fun getUser(id: String): Single<User> {
        return userApi.getUser(id).map { userMapper.mapToDomain(it) }
    }
}