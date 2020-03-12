package works.codex.arief.presentation.detail

import io.reactivex.Observable
import works.codex.arief.common.base.presenter.BasePresenter
import works.codex.arief.data.server.entity.response.CommentResponse
import works.codex.arief.domain.usecase.GetCommentUseCase
import works.codex.arief.presentation.detail.mapper.DetailMapper
import works.codex.arief.presentation.detail.model.CommentViewModel

class DetailPresenter(
    private val getCommentUseCase: GetCommentUseCase
) : BasePresenter<DetailContract.View>(), DetailContract.Presenter {

    override fun onAttach() {
        super.onAttach()
        view().initViews()
    }

    override fun fetchComments(comments: MutableList<Int?>?) {
        val listOfId = mutableListOf<Int>()
        val listOfStoryObservable = mutableListOf<Observable<CommentResponse>>()
        for (position in 0 until 10) {
            comments?.let { listOfId.add(it[position]!!) }
        }
        listOfId.forEach { listOfStoryObservable.add(getStoryDetailObservable(it)) }
        observe {
            subscribeOnIoSchedulers(Observable.fromIterable(listOfStoryObservable))
                .flatMap { mapper -> mapper }
                .toList()
                .map {
                    val data = mutableListOf<CommentViewModel>()
                    it.forEach { item -> data.add(DetailMapper.transform(item)) }
                    data
                }
                .subscribe({
                    view().hideLoading()
                    view().showComment(it)
                }, {
                    view().onError(it)
                })
        }
    }

    private fun getStoryDetailObservable(storyId: Int): Observable<CommentResponse> {
        return getCommentUseCase.fetchComment(storyId)
    }
}