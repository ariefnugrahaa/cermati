package works.cermati.arief.data.server

import io.reactivex.Observable
import works.cermati.arief.data.server.entity.response.CommentResponse
import works.cermati.arief.data.server.entity.response.StoryResponse
import works.cermati.arief.presentation.list.model.UsersModelItem

class ApiServiceManager(private val apiService: ApiService) {

    fun emittedUsers(page: Int): Observable<MutableList<UsersModelItem>>{
        return apiService.getAllUsers(page)
    }

}