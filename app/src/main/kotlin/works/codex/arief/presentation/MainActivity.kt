package works.codex.arief.presentation

import android.os.Bundle
import works.codex.arief.R
import works.codex.arief.common.base.composer.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() = Unit
}