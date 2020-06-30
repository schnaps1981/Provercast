package com.test.provercast.app.di

import com.test.provercast.app.di.modules.*
import com.test.provercast.mvp.presenters.MainActivityPresenter
import com.test.provercast.repository.RepositoryImpl
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ContextModule::class,
        GoogleRequestModule::class,
        RepositoryModule::class,
        RoomModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivityPresenter: MainActivityPresenter)

    fun inject(repositoryImpl: RepositoryImpl)


}