package works.codex.arief.common.base.composer

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import works.codex.arief.AriefApplication

open class BaseActivity : AppCompatActivity() {

    protected val navigationService by lazy { AriefApplication.ariefComponent.provideNavigationService() }

    protected var disableBackPressed: Boolean = false
    protected var wantExitNow: Boolean = false

    override fun onBackPressed() {
        if (disableBackPressed) {
            return
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
            super.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}