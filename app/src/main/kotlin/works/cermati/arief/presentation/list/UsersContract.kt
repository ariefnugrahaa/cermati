package works.cermati.arief.presentation.list

import works.cermati.arief.presentation.list.model.UsersModelItem

interface UsersContract {

    interface View {
        fun initViews()
        fun onError(it: Throwable?)
        fun showListData(it: MutableList<UsersModelItem>?)
        fun hideLoading()
        fun showLoading()
    }

    interface Presenter {
        fun fetchUsersData(since:Int)
    }
}