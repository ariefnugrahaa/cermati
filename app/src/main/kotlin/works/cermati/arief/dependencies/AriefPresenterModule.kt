package works.cermati.arief.dependencies

import dagger.Module
import dagger.Provides
import works.cermati.arief.domain.usecase.GetUsersUseCase
import works.cermati.arief.presentation.list.UsersPresenter
import javax.inject.Singleton

@Module
class AriefPresenterModule {

    @Singleton
    @Provides
    fun provideUserPresenter(getUsersUseCase: GetUsersUseCase) =
            UsersPresenter(getUsersUseCase)
}