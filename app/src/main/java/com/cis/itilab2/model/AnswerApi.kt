package com.cis.itilab2.model


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AnswerApi {
    @POST("/predict")
    suspend fun getAnswerLabel(@Body answerData: AnswerData): Response<LabelResponse>
}