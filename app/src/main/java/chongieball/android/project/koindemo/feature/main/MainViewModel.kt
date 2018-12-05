package chongieball.android.project.koindemo.feature.main

import android.arch.lifecycle.MutableLiveData
import chongieball.android.project.koindemo.data.network.ErrorData
import chongieball.android.project.koindemo.data.network.response.RepoResponse
import chongieball.android.project.koindemo.data.network.response.RepoSearchResponse
import chongieball.android.project.koindemo.data.repository.DataRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import chongieball.android.project.koindemo.feature.base.BaseViewModel
import chongieball.android.project.koindemo.utils.ApiObserver
import timber.log.Timber

class MainViewModel(private val dataRepository: DataRepository): BaseViewModel() {

    private var msg: String = "test"
    var repoList: MutableLiveData<List<RepoResponse>> = MutableLiveData()

    fun getMessage(): String {
        msg = dataRepository.getMessage()
        return msg
    }

    fun searchRepos(query: String) {
        displayLoader(true)

        dataRepository.searchRepositories(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : ApiObserver<RepoSearchResponse>(compositeDisposable) {
                    override fun onError(e: ErrorData) {
                        displayLoader(false)
                        error.value = e
                    }

                    override fun onSuccess(data: RepoSearchResponse) {
                        displayLoader(false)
                        repoList.value = data.items
                    }
                })
    }
}