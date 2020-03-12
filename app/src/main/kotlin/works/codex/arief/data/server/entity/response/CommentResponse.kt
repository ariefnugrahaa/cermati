package works.codex.arief.data.server.entity.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
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
) : Parcelable