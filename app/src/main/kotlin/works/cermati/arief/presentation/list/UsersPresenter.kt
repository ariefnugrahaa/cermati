package works.cermati.arief.presentation.list

import works.cermati.arief.common.base.presenter.BasePresenter
import works.cermati.arief.common.utils.Logger
import works.cermati.arief.domain.usecase.GetUsersUseCase
import works.cermati.arief.presentation.list.model.UsersModelItem

class UsersPresenter(private val getUsersUseCase: GetUsersUseCase):BasePresenter<UsersContract.View>(), UsersContract.Presenter {

    override fun onAttach() {
        super.onAttach()
        view().initViews()
    }

    private fun onFetchUsersDataFailed(it: Throwable?) {
        view().onError(it)
        Logger.debug("Error >>> ${it?.message}")
    }

    override fun fetchUsersData(since:Int) {
        view().showLoading()
            observe {
             subscribeOnIoSchedulers(
                     getUsersUseCase.fetchUsers(since)
             ).subscribe(
                     { onFetchUsersDataSuccess(it) },
                     { onFetchUsersDataFailed(it) }
             )
        }
    }

    private fun onFetchUsersDataSuccess(it: MutableList<UsersModelItem>){
        view().hideLoading()
        view().showListData(it)
    }
}