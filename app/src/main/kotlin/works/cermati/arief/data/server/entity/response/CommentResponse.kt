package works.cermati.arief.data.server.entity.response

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class CommentResponse(
    @SerializedName("by")
    @Expose
    val `by`: String?,
    @SerializedName("id")
    @Expose
    val id: Int?,
    @SerializedName("kids")
    @Expose
    val kids: List<Int?>?,
    @SerializedName("time")
    @Expose
    val time: Int?,
    @SerializedName("text")
    @Expose
    val text: String?,
    @SerializedName("type")
    @Expose
    val type: String?
) : Serializable