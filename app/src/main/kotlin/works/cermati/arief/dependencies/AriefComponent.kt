package works.cermati.arief.dependencies

import android.content.Context
import dagger.Component
import works.cermati.arief.data.server.ApiServiceManager
import works.cermati.arief.presentation.list.UsersPresenter
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
    fun provideUsersPresenter(): UsersPresenter
}