package works.codex.arief.service

import android.app.Activity
import android.content.Intent
import works.codex.arief.presentation.MainActivity
import works.codex.arief.presentation.detail.DetailActivity
import works.codex.arief.presentation.list.ListActivity
import works.codex.arief.presentation.list.model.ListViewModel

class NavigationService {
    fun startListActivity(activity: Activity) {
        activity.startActivity(Intent(activity, ListActivity::class.java))
    }

    fun startDetailActivity(activity: Activity, id: ListViewModel?) {
        activity.startActivityForResult(Intent(activity, DetailActivity::class.java).apply {
            putExtra(EXTRA_ID, id)
        }, RESULT_ID)
    }

    companion object {
        const val EXTRA_ID = "intent.extra.id"
        const val RESULT_ID = 123
    }
}