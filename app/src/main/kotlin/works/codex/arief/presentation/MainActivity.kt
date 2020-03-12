package works.codex.arief.presentation

import android.os.Bundle
import works.codex.arief.AriefApplication
import works.codex.arief.R
import works.codex.arief.common.base.composer.BaseActivity

class MainActivity : BaseActivity() {

    private val navigation by lazy { AriefApplication.ariefComponent.provideNavigationService() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.startListActivity(this).also { finish() }
    }

    override fun onBackPressed() = Unit
}