package works.codex.arief.presentation.list

import works.codex.arief.presentation.list.model.ListViewModel

interface ListContract {
    interface View {
        fun initViews()
        fun onError(it: Throwable?)
        fun showListData(it: MutableList<ListViewModel>?)
        fun hideLoading()
        fun showLoading()
    }

    interface Presenter {
        fun fetchStoryData()
    }
}