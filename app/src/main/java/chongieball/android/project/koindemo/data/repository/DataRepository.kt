package chongieball.android.project.koindemo.data.repository

import io.reactivex.Observable
import chongieball.android.project.koindemo.data.network.GithubService
import chongieball.android.project.koindemo.data.network.response.RepoSearchResponse

class DataRepository(private val githubService: GithubService) {

    fun getMessage(): String {
        return "hello my message"
    }

    fun searchRepositories(query: String): Observable<RepoSearchResponse> = githubService.searchRepos(query)
}