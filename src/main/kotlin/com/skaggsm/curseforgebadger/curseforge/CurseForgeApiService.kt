package com.skaggsm.curseforgebadger.curseforge

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

/**
 * Created by Mitchell Skaggs on 6/26/2019.
 */
@Service
class CurseForgeApiService {

    private final val api: CurseForgeApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.cfwidget.com/")
                .addConverterFactory(MoshiConverterFactory.create(
                        Moshi.Builder()
                                .add(KotlinJsonAdapterFactory())
                                .build()
                ))
                .build()
        api = retrofit.create()
    }

    fun getProject(id: String): Project = api.getProject(id).execute().body()!!
}
