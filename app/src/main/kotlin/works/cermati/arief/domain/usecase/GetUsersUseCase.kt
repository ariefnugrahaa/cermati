package works.cermati.arief.domain.usecase

import io.reactivex.Observable
import works.cermati.arief.data.server.ApiServiceManager
import works.cermati.arief.presentation.list.model.UsersModelItem
import java.util.*

class GetUsersUseCase (private val repository: ApiServiceManager){

    fun fetchUsers(page: Int): Observable<MutableList<UsersModelItem>> {
        return repository.emittedUsers(page)
    }
}