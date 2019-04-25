package home.learn.hmt.data.remote.response.base

import com.google.gson.annotations.SerializedName
import home.learn.hmt.domain.model.Movie
import java.util.ArrayList

open class BaseListResponse<T>{
    @SerializedName("page")
    var page: Int? = 0
    @SerializedName("total_results")
    var total_results: Int? = null
    @SerializedName("total_pages")
    var total_pages: Int? = null
    @SerializedName("results")
    var results = ArrayList<T>()
    /*@SerializedName("dates")
    var dates: Dates? = null*/
}