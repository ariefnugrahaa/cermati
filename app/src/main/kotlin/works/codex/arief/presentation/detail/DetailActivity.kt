package works.codex.arief.presentation.detail

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

class DetailActivity : AppCompatActivity(), DetailContract.View {

    private val presenter by lazy { AriefApplication.ariefComponent.provideDetailPresenter() }

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

    }


}
