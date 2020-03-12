package works.codex.arief.domain.usecase

import io.reactivex.Observable
import works.codex.arief.data.server.ApiServiceManager
import works.codex.arief.data.server.entity.response.StoryResponse

class GetStoryUseCase(
    private val repository: ApiServiceManager
) {
    fun fetchList(): Observable<ArrayList<Int>> {
        return repository.emittedStory()
    }

    fun fetchInformation(storyId: Int): Observable<StoryResponse> {
        return repository.emittedStoryDetail(storyId)
    }
}
