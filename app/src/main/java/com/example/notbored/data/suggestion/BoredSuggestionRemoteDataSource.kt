package com.example.notbored.data.suggestion

import com.example.notbored.data.RetrofitService
import com.example.notbored.data.dto.BoredSuggestion
import com.example.notbored.data.utils.RepositoryError
import com.example.notbored.data.utils.RepositoryResponse
import com.example.notbored.data.utils.ResponseListener
import com.example.notbored.data.utils.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BoredSuggestionRemoteDataSource {

    fun getRandom(listener: ResponseListener<BoredSuggestion>) {

        val service = RetrofitService.instance.create(BoredSuggestionService::class.java).getRandom()

        service.enqueue(object: Callback<BoredSuggestion> {

            override fun onResponse(call: Call<BoredSuggestion>, response: Response<BoredSuggestion>) {
                val activity: BoredSuggestion? = response.body()
                if (response.isSuccessful && activity != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = activity,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }

            override fun onFailure(call: Call<BoredSuggestion>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }

        })

    }

    fun getRandomParticipants(listener: ResponseListener<BoredSuggestion>, numberOfParticipants: Int) {

        val service = RetrofitService.instance.create(BoredSuggestionService::class.java)
            .getRandomParticipants(numberOfParticipants)

        service.enqueue(object: Callback<BoredSuggestion> {

            override fun onResponse(call: Call<BoredSuggestion>, response: Response<BoredSuggestion>) {
                val activity: BoredSuggestion? = response.body()
                if (response.isSuccessful && activity != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = activity,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }

            override fun onFailure(call: Call<BoredSuggestion>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }

        })

    }


    fun get(listener: ResponseListener<BoredSuggestion>, numberOfParticipants: Int, typeOfActivity: String){
        val service = RetrofitService.instance.create(BoredSuggestionService::class.java)
            .get(numberOfParticipants, typeOfActivity)

        service.enqueue(object: Callback<BoredSuggestion> {

            override fun onResponse(call: Call<BoredSuggestion>, response: Response<BoredSuggestion>) {
                val activity: BoredSuggestion? = response.body()
                if (response.isSuccessful && activity != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = activity,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }


            override fun onFailure(call: Call<BoredSuggestion>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }

        })


    }

    fun getWithOutParticipants(listener: ResponseListener<BoredSuggestion>, typeOfActivity: String){
        val service = RetrofitService.instance.create(BoredSuggestionService::class.java)
            .getWithOutParticipants(typeOfActivity)

        service.enqueue(object: Callback<BoredSuggestion> {

            override fun onResponse(call: Call<BoredSuggestion>, response: Response<BoredSuggestion>) {
                val activity: BoredSuggestion? = response.body()
                if (response.isSuccessful && activity != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = activity,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }


            override fun onFailure(call: Call<BoredSuggestion>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }

        })

    }






}