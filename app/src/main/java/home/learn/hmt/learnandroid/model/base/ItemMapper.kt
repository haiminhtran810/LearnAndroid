package home.learn.hmt.learnandroid.model.base

import home.learn.hmt.domain.model.base.Model

abstract class ItemMapper<M : Model, MI : ModelItem>() {
    abstract fun mapToPresentation(model: M): MI

    abstract fun mapToDomain(modelItem: MI): M

    open fun mapToDomain(dataCollection: Collection<MI>): List<M> {
        return dataCollection.map { mapToDomain(it) }
    }

    open fun mapToPresentation(dataCollection: Collection<M>): List<MI> {
        return dataCollection.map { mapToPresentation(it) }
    }

}