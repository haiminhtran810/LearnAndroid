package home.learn.hmt.domain.repository

import home.learn.hmt.domain.model.User
import home.learn.hmt.domain.repository.base.Repository
import io.reactivex.Single

interface UserRepository : Repository {
    fun getUser(id: String): Single<User>
}