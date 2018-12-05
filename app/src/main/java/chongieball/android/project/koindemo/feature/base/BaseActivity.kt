package chongieball.android.project.koindemo.feature.base

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import timber.log.Timber

abstract class BaseActivity: AppCompatActivity() {

    fun observeLoader(viewModel: BaseViewModel, loaderView: View) {
        viewModel.loader.observe(this, Observer {
            loaderView.visibility = if(it != null && it) View.VISIBLE else View.GONE
            Timber.d("QWERTY ${viewModel.error}")
        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it?.message, Toast.LENGTH_LONG).show()
        })
    }
}