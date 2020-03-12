package works.codex.arief.presentation.detail

import works.codex.arief.presentation.detail.model.CommentViewModel

interface DetailContract {
    interface View {
        fun initViews()
        fun hideLoading()
        fun showComment(data: MutableList<CommentViewModel>?)
        fun onError(it: Throwable?)
    }

    interface Presenter {
        fun fetchComments(comments: MutableList<Int?>?)
    }
}