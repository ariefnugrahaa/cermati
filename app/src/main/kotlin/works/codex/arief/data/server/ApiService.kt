package works.codex.arief.data.server

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import works.codex.arief.data.server.entity.response.CommentResponse
import works.codex.arief.data.server.entity.response.StoryResponse

interface ApiService {

    @GET(STORY)
    fun getStory(): Observable<ArrayList<Int>>

    @GET(DETAIL)
    fun getStoryDetail(@Path("id") storyId: Int): Observable<StoryResponse>

    @GET(DETAIL)
    fun getCommentsDetail(@Path("id") storyId: Int): Observable<CommentResponse>

    private companion object {
        const val STORY = "v0/topstories.json"
        const val DETAIL = "v0/item/{id}.json"
    }
}