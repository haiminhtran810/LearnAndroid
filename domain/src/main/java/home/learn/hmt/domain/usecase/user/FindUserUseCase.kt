package home.learn.hmt.domain.usecase.user

import home.learn.hmt.domain.Constant
import home.learn.hmt.domain.model.User
import home.learn.hmt.domain.repository.UserRepository
import home.learn.hmt.domain.usecase.UseCase
import io.reactivex.Single

class FindUserUseCase constructor(private val userRepository: UserRepository) :
    UseCase<FindUserUseCase.Params, Single<User>>() {
    override fun createObservable(params: Params?): Single<User> {
        params?.apply {
            return userRepository.getUser(params.userId)
        }
        return Single.error(Throwable(Constant.PARAMS_ERROR))
    }

    override fun onCleared() {
    }

    data class Params(val userId: String)
}