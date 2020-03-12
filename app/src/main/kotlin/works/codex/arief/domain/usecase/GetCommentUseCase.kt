package works.codex.arief.domain.usecase

import io.reactivex.Observable
import works.codex.arief.data.server.ApiServiceManager
import works.codex.arief.data.server.entity.response.CommentResponse

class GetCommentUseCase(
    private val repository: ApiServiceManager
) {
    fun fetchComment(idComment: Int): Observable<CommentResponse> {
        return repository.emittedCommentDetail(idComment)
    }
}
