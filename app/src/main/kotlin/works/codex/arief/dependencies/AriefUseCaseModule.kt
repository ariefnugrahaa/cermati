package works.codex.arief.dependencies

import dagger.Module
import dagger.Provides
import works.codex.arief.data.server.ApiServiceManager
import works.codex.arief.domain.usecase.GetStoryUseCase
import javax.inject.Singleton

@Module
class AriefUseCaseModule {
    @Singleton
    @Provides
    fun provideGetStoryUseCase(apiServiceManager: ApiServiceManager) =
        GetStoryUseCase(apiServiceManager)
}