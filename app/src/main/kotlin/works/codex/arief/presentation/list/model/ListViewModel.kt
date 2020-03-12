package works.codex.arief.presentation.list.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListViewModel(
    val id: Int? = 0,
    val title: String? = null,
    val author: String? = null,
    val date: String? = null,
    val text: String? = null,
    val comments: MutableList<Int?>? = null
) : Parcelable