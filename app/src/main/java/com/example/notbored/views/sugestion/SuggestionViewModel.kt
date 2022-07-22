package com.example.notbored.views.sugestion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notbored.data.dto.BoredSuggestion
import com.example.notbored.data.suggestion.BoredSuggestionRepository
import com.example.notbored.data.utils.RepositoryError
import com.example.notbored.data.utils.RepositoryResponse
import com.example.notbored.data.utils.ResponseListener

class SuggestionViewModel(
    private val repository: BoredSuggestionRepository) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _activity = MutableLiveData<BoredSuggestion>()
    val activity: LiveData<BoredSuggestion>
        get() = _activity

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun loadRandom() {
        _loading.value = true
        _error.value = null
        _activity.value = null

        repository.getRandom(listener = object: ResponseListener<BoredSuggestion> {

            override fun onResponse(response: RepositoryResponse<BoredSuggestion>) {
                _activity.value = response.data
                _loading.value = false
            }

            override fun onError(error: RepositoryError) {
                _error.value = error.message
                _loading.value = false
            }

        })
    }

    fun loadRandomParticipants(numberOfParticipants: Int = 1){
        _loading.value = true
        _error.value = null
        _activity.value = null

        repository.getRandomParticipants(listener = object: ResponseListener<BoredSuggestion>{
            override fun onResponse(response: RepositoryResponse<BoredSuggestion>) {
                _activity.value = response.data
                _loading.value = false
            }

            override fun onError(error: RepositoryError) {
                _error.value = error.message
                _loading.value = false
            }

        }, numberOfParticipants)
    }

    fun load(numberOfParticipants: Int = 1, typeOfActivity: String){
        _loading.value = true
        _error.value = null
        _activity.value = null

        repository.get(listener = object: ResponseListener<BoredSuggestion>{
            override fun onResponse(response: RepositoryResponse<BoredSuggestion>) {
                _activity.value = response.data
                _loading.value = false
            }

            override fun onError(error: RepositoryError) {
                _error.value = error.message
                _loading.value = false
            }

        }, numberOfParticipants, typeOfActivity)

    }

    fun loadWithOutParticipants(typeOfActivity: String){
        _loading.value = true
        _error.value = null
        _activity.value = null

        repository.getWithOutParticipants(listener = object: ResponseListener<BoredSuggestion>{
            override fun onResponse(response: RepositoryResponse<BoredSuggestion>) {
                _activity.value = response.data
                _loading.value = false
            }

            override fun onError(error: RepositoryError) {
                _error.value = error.message
                _loading.value = false
            }

        }, typeOfActivity)

    }


}