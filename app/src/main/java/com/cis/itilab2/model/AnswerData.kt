package com.cis.itilab2.model

import com.google.gson.annotations.SerializedName

data class AnswerData( @SerializedName("model_answer") val model_answer:String,@SerializedName("student_answer") val student_answer:String)
