package com.example.hilt.ui.main.viewmodel


import androidx.lifecycle.*
import com.example.hilt.data.model.User
import com.example.hilt.data.repo.MainRepository
import com.example.hilt.utils.NetworkHelper
import com.example.hilt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _users:LiveData<Resource<List<User>>> = liveData(Dispatchers.IO){
        emit(Resource.loading(null))
        if (networkHelper.isNetworkConnected()) {
            mainRepository.getUsers().let {
                if (it.isSuccessful) {
                    emit(Resource.success(it.body()))
                } else emit(Resource.error(it.errorBody().toString(), null))
            }
        } else emit(Resource.error("No internet connection", null))
    }
    val users: LiveData<Resource<List<User>>>
        get() = _users
}