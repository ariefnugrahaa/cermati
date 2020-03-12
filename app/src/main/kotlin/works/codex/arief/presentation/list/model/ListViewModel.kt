package works.codex.arief.presentation.list.model

import java.io.Serializable

data class ListViewModel(
    val id: Int? = 0,
    val title: String? = null,
    val author: String? = null,
    val date: String? = null,
    val text: String? = null,
    val comments: MutableList<Int?>? = null
) : Serializable