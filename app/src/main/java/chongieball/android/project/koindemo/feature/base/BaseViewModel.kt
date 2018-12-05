package chongieball.android.project.koindemo.feature.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import chongieball.android.project.koindemo.data.network.ErrorData
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    val loader: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<ErrorData?> = MutableLiveData()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun displayLoader(isLoading: Boolean) {
        loader.value = isLoading
    }
}