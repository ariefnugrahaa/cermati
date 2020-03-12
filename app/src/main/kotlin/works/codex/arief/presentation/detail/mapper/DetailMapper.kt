package works.codex.arief.presentation.detail.mapper

import works.codex.arief.data.server.entity.response.CommentResponse
import works.codex.arief.presentation.detail.model.CommentViewModel

object DetailMapper {
    fun transform(data: CommentResponse): CommentViewModel {
        return CommentViewModel(text = data.text)
    }
}