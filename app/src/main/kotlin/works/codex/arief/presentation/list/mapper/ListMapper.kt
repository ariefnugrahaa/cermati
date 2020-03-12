package works.codex.arief.presentation.list.mapper

import works.codex.arief.common.extension.timestampToDate
import works.codex.arief.data.server.entity.response.StoryResponse
import works.codex.arief.presentation.list.model.ListViewModel

object ListMapper {
    fun transform(data: StoryResponse): ListViewModel {
        return ListViewModel(
            id = data.idStory,
            title = data.title,
            text = data.text,
            author = data.by,
            date = data.time?.timestampToDate(),
            comments = data.kids?.toMutableList()
        )
    }
}