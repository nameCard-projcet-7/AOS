package io.name.card.aos.API

import io.name.card.aos.Data.NameCardData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("namecard/ocr/")
    fun getNameCardData(): Call<NameCardData>
}
