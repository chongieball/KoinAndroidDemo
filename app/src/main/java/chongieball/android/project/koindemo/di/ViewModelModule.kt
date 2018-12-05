package chongieball.android.project.koindemo.di

import chongieball.android.project.koindemo.data.repository.DataRepository
import chongieball.android.project.koindemo.feature.main.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    single(createOnStart = true) { DataRepository(get()) }

    viewModel { MainViewModel(get()) }
}