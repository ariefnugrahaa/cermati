package works.codex.arief.dependencies

import dagger.Module
import dagger.Provides
import works.codex.arief.service.NavigationService

@Module
class AriefServiceModule {

    @Provides
    fun provideNavigationService() = NavigationService()
}