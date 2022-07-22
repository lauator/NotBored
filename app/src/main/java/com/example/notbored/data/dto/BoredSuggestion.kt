package com.example.notbored.data.dto

import com.google.gson.annotations.SerializedName

class BoredSuggestion(@SerializedName("activity")
                      val activity: String,
                      @SerializedName("type")
                      val type: String,
                      @SerializedName("participants")
                      val participants: Int,
                      @SerializedName("price")
                      val price: Double)