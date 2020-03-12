package works.codex.arief.common.base.presenter

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BasePresenter<V> {

    private val subscriptions: CompositeDisposable = CompositeDisposable()
    private var view: V? = null

    fun attach(v: V) {
        this.view = v
        onAttach()
    }

    fun detach() {
        this.view = null
        subscriptions.clear()
        onDetach()
    }

    fun view(): V = view!!

    protected fun view(v: V) {
        this.view = v
    }

    protected fun observe(execute: () -> Disposable) {
        subscriptions.add(execute())
    }

    protected fun <T> subscribeOnIoSchedulers(observable: Observable<T>): Observable<T> {
        return observable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    protected open fun onAttach() {}
    protected open fun onDetach() {}
}