package works.codex.arief.data.server

import io.reactivex.Observable
import works.codex.arief.data.server.entity.response.CommentResponse
import works.codex.arief.data.server.entity.response.StoryResponse

class ApiServiceManager(private val apiService: ApiService) {

    fun emittedStory(): Observable<ArrayList<Int>> {
        return apiService.getStory()
    }

    fun emittedStoryDetail(idString: Int): Observable<StoryResponse> {
        return apiService.getStoryDetail(idString)
    }

    fun emittedCommentDetail(idString: Int): Observable<CommentResponse> {
        return apiService.getCommentsDetail(idString)
    }
}