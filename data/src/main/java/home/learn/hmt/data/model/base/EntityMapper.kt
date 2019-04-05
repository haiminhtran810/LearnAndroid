package home.learn.hmt.data.model.base

import home.learn.hmt.domain.model.base.Model

abstract class EntityMapper<M : Model, ME : ModelEntity> {
    abstract fun mapToDomain(entity: ME): M
    abstract fun mapTOEntity(model: M): ME

    open fun mapToDomain(dataCollection: Collection<ME>): List<M> {
        return dataCollection.map { mapToDomain(it) }
    }

    open fun mapTOEntity(dataCollection: Collection<M>): List<ME> {
        return dataCollection.map { mapTOEntity(it) }
    }
}