package works.codex.arief.service

import android.content.Intent
import works.codex.arief.presentation.MainActivity
import works.codex.arief.presentation.list.ListActivity

class NavigationService {
    fun startListActivity(activity: MainActivity) {
        activity.startActivity(Intent(activity, ListActivity::class.java))
    }

    fun startDetailActivity(activity: ListActivity, id: Int?) {
        activity.startActivity(Intent(activity, ListActivity::class.java).apply {
            putExtra(EXTRA_ID, id)
        })
    }

    companion object {
        const val EXTRA_ID = "intent.extra.id"
    }
}