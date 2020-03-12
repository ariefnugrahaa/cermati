package works.codex.arief.presentation.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_list.*
import works.codex.arief.AriefApplication
import works.codex.arief.R
import works.codex.arief.common.extension.makeInvisible
import works.codex.arief.common.extension.makeVisible
import works.codex.arief.common.extension.showToast
import works.codex.arief.presentation.list.adapter.StoryAdapter
import works.codex.arief.presentation.list.model.ListViewModel

class ListActivity : AppCompatActivity(), ListContract.View {

    private val presenter by lazy { AriefApplication.ariefComponent.provideListPresenter() }
    private val navigator by lazy { AriefApplication.ariefComponent.provideNavigationService() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        presenter.attach(this)
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun initViews() {
        recyclerview_story.apply {
            layoutManager = GridLayoutManager(this@ListActivity, GRID_SIZE)
            adapter = StoryAdapter { position, id -> onClick(position, id) }
        }.also {
            presenter.fetchStoryData()
        }
    }

    override fun onError(it: Throwable?) {
        showToast("Error Cuuuy")
    }

    override fun showListData(it: MutableList<ListViewModel>?) {
        runOnUiThread { it?.let { getListAdapter()?.setData(it) } }
    }

    override fun hideLoading() {
        progress_bar.makeInvisible()
    }

    override fun showLoading() {
        progress_bar.makeVisible()
    }

    private fun onClick(position: Int, id: ListViewModel?) {
        navigator.startDetailActivity(this@ListActivity, id)
    }

    private fun getListAdapter(): StoryAdapter? = recyclerview_story?.adapter as? StoryAdapter

    companion object {
        private const val GRID_SIZE = 2
    }
}
