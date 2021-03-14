package com.pmacademy.catsapp.di

import com.pmacademy.catsapp.cats.ui.CatsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ViewModelModule::class, NetworkModule::class,
        RepositoryModule::class]
)
interface AppComponent {
    fun inject(fragment: CatsFragment)
}
