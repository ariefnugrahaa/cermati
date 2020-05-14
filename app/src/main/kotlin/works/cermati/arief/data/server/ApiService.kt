package works.cermati.arief.data.server

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import works.cermati.arief.data.server.ApiService.Companion.USERS
import works.cermati.arief.data.server.entity.response.CommentResponse
import works.cermati.arief.data.server.entity.response.StoryResponse
import works.cermati.arief.presentation.list.model.UsersModelItem

interface ApiService {

    @GET(USERS)
    fun getAllUsers(@Query("since") page:Int):Observable<MutableList<UsersModelItem>>

    private companion object {
        const val  USERS = "users"
    }
}