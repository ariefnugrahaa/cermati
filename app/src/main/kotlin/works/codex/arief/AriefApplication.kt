package works.codex.arief

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import works.codex.arief.common.utils.Logger
import works.codex.arief.dependencies.AriefApplicationModule
import works.codex.arief.dependencies.AriefComponent
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import java.io.IOException
import java.net.SocketException
import works.codex.arief.dependencies.DaggerAriefComponent

class AriefApplication : Application() {
    companion object {
        lateinit var ariefComponent: AriefComponent
    }

    override fun onCreate() {
        super.onCreate()
        initLogging()
        initDagger()
        initRxJavaplugins()
        initStetho()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun initLogging() {
        Logger.logEnabled = BuildConfig.DEBUG
    }

    private fun initDagger() {
        ariefComponent = DaggerAriefComponent
            .builder()
            .ariefApplicationModule(AriefApplicationModule(this))
            .build()
    }

    private fun initRxJavaplugins() {
        RxJavaPlugins.setErrorHandler { e ->
            if (e is UndeliverableException) {
                e.cause
            }
            if (e is IOException || e is SocketException) {
                e
            }
            e as? InterruptedException
            if (e is NullPointerException || e is IllegalArgumentException) {
                Thread.currentThread().uncaughtExceptionHandler
            }
            if (e is IllegalStateException) {
                Thread.currentThread().uncaughtExceptionHandler
            }
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}