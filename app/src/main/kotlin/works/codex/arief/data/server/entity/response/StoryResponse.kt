package works.codex.arief.data.server.entity.response

import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.google.gson.annotations.Expose

@Keep
data class StoryResponse(
    @SerializedName("by")
    @Expose
     val `by`: String?,
    @SerializedName("descendants")
    @Expose
    val descendants: Int?,
    @SerializedName("id")
    @Expose
    val idStory: Int?,
    @SerializedName("kids")
    @Expose
    val kids: List<Int?>?,
    @SerializedName("score")
    @Expose
    val score: Int?,
    @SerializedName("time")
    @Expose
    val time: Int?,
    @SerializedName("title")
    @Expose
    val title: String?,
    @SerializedName("type")
    @Expose
    val type: String?,
    @SerializedName("url")
    @Expose
    val url: String?
)