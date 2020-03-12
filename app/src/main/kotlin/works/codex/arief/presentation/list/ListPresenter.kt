package works.codex.arief.presentation.list

import io.reactivex.Observable
import works.codex.arief.common.base.presenter.BasePresenter
import works.codex.arief.common.utils.Logger
import works.codex.arief.data.server.entity.response.StoryResponse
import works.codex.arief.domain.usecase.GetStoryUseCase
import works.codex.arief.presentation.list.mapper.ListMapper
import works.codex.arief.presentation.list.model.ListViewModel
import java.util.*

class ListPresenter(
    private val getStoryUseCase: GetStoryUseCase
) : BasePresenter<ListContract.View>(), ListContract.Presenter {

    override fun onAttach() {
        super.onAttach()
        view().initViews()
    }

    override fun fetchStoryData() {
        view().showLoading()
        observe {
            subscribeOnIoSchedulers(getStoryUseCase.fetchList())
                .subscribe(
                    { onFetchStoryDataSucceeded(it) },
                    { onFetchStoryDataFailed(it) }
                )
        }
    }

    private fun onFetchStoryDataFailed(it: Throwable?) {
        view().onError(it)
        Logger.debug("Error >>> ${it?.message}")
    }

    private fun onFetchStoryDataSucceeded(list: ArrayList<Int>?) {
        val listOfId = mutableListOf<Int>()
        val listOfStoryObservable = mutableListOf<Observable<StoryResponse>>()
        for (position in 0 until 10) {
            list?.let { listOfId.add(it[position]) }
        }
        listOfId.forEach { listOfStoryObservable.add(getStoryDetailObservable(it)) }
        observe {
            subscribeOnIoSchedulers(Observable.fromIterable(listOfStoryObservable))
                .flatMap { mapper -> mapper }
                .toList()
                .map {
                    val data = mutableListOf<ListViewModel>()
                    it.forEach { item -> data.add(ListMapper.transform(item)) }
                    data
                }
                .subscribe({
                    view().hideLoading()
                    view().showListData(it)
                }, {
                    view().onError(it)
                })
        }
    }

    private fun getStoryDetailObservable(storyId: Int): Observable<StoryResponse> {
        return getStoryUseCase.fetchInformation(storyId)
    }
}