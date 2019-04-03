package home.learn.hmt.data.remote.mock

import home.learn.hmt.data.model.UserEntity
import home.learn.hmt.data.remote.api.UserAPI
import io.reactivex.Single

class MockUserAPI constructor(): UserAPI{
    override fun getUser(userId: String): Single<UserEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}