package home.learn.hmt.learnandroid.utils.chameleon

import com.cloudmade.chameleon.Theme

enum class ChameleonTheme(resourceIdSuffix: String) : Theme {

    NIGHT("_night"),
    DAY("_day");

    private var resourceIdSuffixValue: String? = null

    init {
        resourceIdSuffixValue = resourceIdSuffix
    }

    override fun getResourceIdSuffix(): String? {
        return resourceIdSuffixValue
    }
}