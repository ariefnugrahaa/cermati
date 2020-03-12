package works.codex.arief.dependencies

import android.content.Context
import dagger.Component
import works.codex.arief.data.server.ApiServiceManager
import works.codex.arief.presentation.list.ListPresenter
import works.codex.arief.service.NavigationService
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AriefApplicationModule::class,
    AriefNetworkModule::class,
    AriefMapperModule::class,
    AriefPresenterModule::class,
    AriefUseCaseModule::class,
    AriefServiceModule::class
])

interface AriefComponent {
    fun provideApplicationContext(): Context
    fun provideApiServiceManager(): ApiServiceManager
    fun provideNavigationService(): NavigationService

    fun provideListPresenter(): ListPresenter
}