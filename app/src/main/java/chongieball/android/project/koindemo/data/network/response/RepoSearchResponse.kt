package chongieball.android.project.koindemo.data.network.response

import com.squareup.moshi.Json
import chongieball.android.project.koindemo.data.network.response.RepoResponse

data class RepoSearchResponse(
        @Json(name = "total_count")
        val totalCount: Int,

        @Json(name = "items")
        val items: List<RepoResponse>
)