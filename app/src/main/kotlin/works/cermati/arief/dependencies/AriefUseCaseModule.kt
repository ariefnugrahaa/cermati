package works.cermati.arief.dependencies

import dagger.Module
import dagger.Provides
import works.cermati.arief.data.server.ApiServiceManager
import works.cermati.arief.domain.usecase.GetUsersUseCase
import javax.inject.Singleton

@Module
class AriefUseCaseModule {

    @Singleton
    @Provides
    fun provieGetUsersUseCase(apiServiceManager: ApiServiceManager) =
            GetUsersUseCase(apiServiceManager)

}