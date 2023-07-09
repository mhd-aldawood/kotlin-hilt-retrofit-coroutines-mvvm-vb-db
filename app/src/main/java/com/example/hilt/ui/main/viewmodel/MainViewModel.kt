package com.example.hilt.ui.main.viewmodel


import android.util.Log
import androidx.lifecycle.*
import com.example.hilt.data.model.responde.Token
import com.example.hilt.data.model.reuqest.User
import com.example.hilt.data.repo.MainRepository
import com.example.hilt.utils.NetworkHelper
import com.example.hilt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>>
        get() = _users

    var error: MutableLiveData<String> = MutableLiveData()
    var password = MutableLiveData<String>()
    var username = MutableLiveData<String>()
    var startActivity: MutableLiveData<Boolean> = MutableLiveData(false)


    public fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }
    }

    private val TAG = "MainViewModel"
    fun userLogin() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                val user = User(username = "mor_2314", password = "83r5^_")
//                val user = User(username = username.value, password = password.value)
                mainRepository.userLogin(user).let {
                    if (it.isSuccessful) {
                        val token =
                            Token(it.body()?.token)//TODO store this key in cypersharedprefernce

                        startActivity.postValue(true)
                    } else
                        error.postValue(it.message())

                }


            } else
                error.postValue("Error No Network")

        }

    }
}