package works.codex.arief.data.server

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import works.codex.arief.data.server.entity.response.StoryResponse

interface ApiService {

    @GET(STORY)
    fun getStory(): Observable<ArrayList<Int>>

    @GET(STORY_DETAIL)
    fun getStoryDetail(@Path("id") storyId: Int): Observable<StoryResponse>

    private companion object {
        const val STORY = "v0/topstories.json"
        const val STORY_DETAIL = "v0/item/{id}.json"
    }
}