package com.hamtary.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamtary.myapplication.models.Category
import com.hamtary.myapplication.models.Data
import com.hamtary.myapplication.models.MyResponse
import com.hamtary.myapplication.repository.ApiRepoImpl
import com.hamtary.myapplication.utils.Event
import com.hamtary.myapplication.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepoImpl) : ViewModel() {

    private val _categoryStatus = MutableStateFlow<Event<Resource<MyResponse<Data<Category>>>>>(Event(Resource.Init()))
    val categoryStatus: MutableStateFlow<Event<Resource<MyResponse<Data<Category>>>>> = _categoryStatus

    fun getCategories() {
        viewModelScope.launch(Dispatchers.Main) {
            _categoryStatus.emit(Event(Resource.Loading()))
            val result = repository.getAllCategories()
            _categoryStatus.emit(Event(result))
        }
    }

}