package chongieball.android.project.koindemo.data.network

import io.reactivex.Observable
import chongieball.android.project.koindemo.data.network.response.RepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String): Observable<RepoSearchResponse>
}