package com.skaggsm.curseforgebadger.curseforge

import com.squareup.moshi.JsonClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Mitchell Skaggs on 6/26/2019.
 */
interface CurseForgeApi {
    @GET("/minecraft/mc-mods/{id}")
    fun getProject(@Path("id") id: String): Call<Project>
}

@JsonClass(generateAdapter = true)
data class Project(
        val id: String,
        val game: String,
        val type: String,
        val urls: Map<String, String>,
        val files: List<File>,
        val links: List<Link>,
        val title: String,
        val license: String,
        val versions: Map<String, List<File>>,
        val downloads: Downloads
)

@JsonClass(generateAdapter = true)
data class File(
        val id: String,
        val name: String,
        val type: String,
        val downloads: Long,
        val url: String
)

@JsonClass(generateAdapter = true)
data class Link(
        val href: String,
        val title: String
)


@JsonClass(generateAdapter = true)
data class Downloads(
        val total: Long,
        val monthly: Long
)
