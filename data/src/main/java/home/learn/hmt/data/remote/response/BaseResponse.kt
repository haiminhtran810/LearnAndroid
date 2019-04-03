package home.learn.hmt.data.remote.response

import com.google.gson.annotations.SerializedName

open class BaseResponse(
    @SerializedName("total")
    val total: Int? = null,
    @SerializedName("max_page")
    val maxPage: Int? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("errors")
    val errors: List<Error>? = null
)