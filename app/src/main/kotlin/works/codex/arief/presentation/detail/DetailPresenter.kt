package works.codex.arief.presentation.detail

import works.codex.arief.common.base.presenter.BasePresenter

class DetailPresenter() : BasePresenter<DetailContract.View>(), DetailContract.Presenter {

    override fun onAttach() {
        super.onAttach()
        view().initViews()
    }

}