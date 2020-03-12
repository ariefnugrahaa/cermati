package works.codex.arief.service

import android.app.Activity
import android.content.Intent
import works.codex.arief.presentation.MainActivity
import works.codex.arief.presentation.detail.DetailActivity
import works.codex.arief.presentation.list.ListActivity

class NavigationService {
    fun startListActivity(activity: Activity) {
        activity.startActivity(Intent(activity, ListActivity::class.java))
    }

    fun startDetailActivity(activity: Activity, id: Int?) {
        activity.startActivity(Intent(activity, DetailActivity::class.java).apply {
            putExtra(EXTRA_ID, id)
        })
    }

    companion object {
        const val EXTRA_ID = "intent.extra.id"
    }
}