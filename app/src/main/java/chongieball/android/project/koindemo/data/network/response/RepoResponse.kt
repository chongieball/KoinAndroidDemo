package chongieball.android.project.koindemo.data.network.response

import com.squareup.moshi.Json

class RepoResponse {

    @Json(name = "id")
    var id: Int = -1

    @Json(name = "full_name")
    var fullName: String = ""

    @Json(name = "description")
    var description: String = ""
}