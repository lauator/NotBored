package com.example.notbored.data.suggestion

import com.example.notbored.data.dto.BoredSuggestion
import com.example.notbored.data.utils.ResponseListener

class BoredSuggestionRepository(
    private val remoteDataSource: BoredSuggestionRemoteDataSource
    ) {

    fun getRandom(listener: ResponseListener<BoredSuggestion>) {
        this.remoteDataSource.getRandom(listener)
    }

    fun getRandomParticipants(listener: ResponseListener<BoredSuggestion>, numberOfParticipants: Int) {
        this.remoteDataSource.getRandomParticipants(listener,numberOfParticipants)
    }

    fun get(listener: ResponseListener<BoredSuggestion>, numberOfParticipants: Int, typeOfActivity: String){
        this.remoteDataSource.get(listener,numberOfParticipants, typeOfActivity)
    }

    fun getWithOutParticipants(listener: ResponseListener<BoredSuggestion>, typeOfActivity: String){
        this.remoteDataSource.getWithOutParticipants(listener, typeOfActivity)
    }

}