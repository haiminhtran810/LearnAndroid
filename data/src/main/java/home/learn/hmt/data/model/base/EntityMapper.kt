package home.learn.hmt.data.model.base

import home.learn.hmt.domain.model.base.Model

interface EntityMapper<M : Model, ME : ModelEntity> {
    fun mapToDomain(entity: ME): M
    fun mapTOEntity(model: M): ME
}