package home.learn.hmt.learnandroid.model.base

import home.learn.hmt.domain.model.base.Model

interface ItemMapper<M : Model, MI : ModelItem> {
    fun mapToPresentation(model: M): MI

    fun mapToDomain(modelItem: MI): M
}