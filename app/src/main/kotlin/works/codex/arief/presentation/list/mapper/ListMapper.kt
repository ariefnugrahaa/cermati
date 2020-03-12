package works.codex.arief.presentation.list.mapper

import works.codex.arief.data.server.entity.response.StoryResponse
import works.codex.arief.presentation.list.model.ListViewModel

object ListMapper {
    fun transform(data: StoryResponse): ListViewModel {
        return ListViewModel(
            id = data.idStory,
            title = data.title
        )
    }
}