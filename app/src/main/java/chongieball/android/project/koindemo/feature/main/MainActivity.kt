package chongieball.android.project.koindemo.feature.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.widget.Toast
import chongieball.android.project.koindemo.R
import chongieball.android.project.koindemo.feature.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : BaseActivity() {

    val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeLoader(mainViewModel, loaderView)

        mainViewModel.searchRepos("android")
        mainViewModel.repoList.observe(this, Observer {
            Toast.makeText(this, it?.size.toString(), Toast.LENGTH_LONG).show()
        })
    }
}