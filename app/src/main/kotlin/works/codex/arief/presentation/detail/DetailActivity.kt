package works.codex.arief.presentation.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import works.codex.arief.AriefApplication
import works.codex.arief.R
import works.codex.arief.common.extension.showToast
import works.codex.arief.presentation.detail.model.CommentViewModel
import works.codex.arief.presentation.list.model.ListViewModel
import works.codex.arief.service.NavigationService

class DetailActivity : AppCompatActivity(), DetailContract.View {

    private val presenter by lazy { AriefApplication.ariefComponent.provideDetailPresenter() }
    private val data by lazy { intent.getSerializableExtra(NavigationService.EXTRA_ID) as? ListViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        presenter.attach(this)
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun initViews() {
        data?.let {
            text_title.text = it.title.orEmpty()
            text_author.text = it.author.orEmpty()
            text_description.text = it.text.orEmpty()

            imageview_star.setOnClickListener { v ->
                val intent = Intent().apply {
                    putExtra(NavigationService.EXTRA_ID, it.title)
                }
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

            presenter.fetchComments(it.comments)
        }
    }

    override fun hideLoading() {

    }

    override fun showComment(data: MutableList<CommentViewModel>?) {
        var comments = ""
        data?.forEach {
            comments += "${it.text}\n"

        }
        text_comment.text = comments
    }

    override fun onError(it: Throwable?) {
        showToast("Error cuuuy")
    }
}
