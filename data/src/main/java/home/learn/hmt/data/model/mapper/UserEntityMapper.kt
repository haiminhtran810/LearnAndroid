package home.learn.hmt.data.model.mapper

import home.learn.hmt.data.model.UserEntity
import home.learn.hmt.data.model.base.EntityMapper
import home.learn.hmt.domain.model.User

class UserEntityMapper : EntityMapper<User, UserEntity> {
    override fun mapToDomain(entity: UserEntity) = User(entity.id)

    override fun mapTOEntity(model: User) = UserEntity(model.id)
}