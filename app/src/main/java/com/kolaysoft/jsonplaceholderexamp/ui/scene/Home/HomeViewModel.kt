package com.kolaysoft.jsonplaceholderexamp.ui.scene.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolaysoft.jsonplaceholderexamp.data.model.UserModel
import com.kolaysoft.jsonplaceholderexamp.data.repositoy.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: UserRepositoryImpl) : ViewModel() {
    private val _data = MutableStateFlow(emptyList<UserModel>())
    val data = _data.asStateFlow()

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            val result = repository.getUsers()
            _data.value = result
        }
    }
}