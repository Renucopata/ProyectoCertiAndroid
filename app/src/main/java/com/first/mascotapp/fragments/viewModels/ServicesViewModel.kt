package com.first.mascotapp.fragments.viewModels

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.first.mascotapp.R
import com.first.mascotapp.data.repositories.LostRepository
import com.first.mascotapp.data.repositories.ServicesRepository
import com.first.mascotapp.fragments.VetsFragment
import com.first.mascotapp.models.LostItemModel
import com.first.mascotapp.models.ServiceListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ServicesViewModel: ViewModel() {
    val serviceRepository = ServicesRepository()
    val serviceList = MutableLiveData(listOf<ServiceListItem>())

    fun getServiceList1(context: Context, onError: () -> Unit) {
        viewModelScope.launch {
            serviceRepository.getServiceList1(context)
                .flowOn(Dispatchers.IO)
                .catch {
                    it.printStackTrace()
                    onError()
                }
                .collect {
                    serviceList.value = it
                    println(it.toString())
                }
        }
        viewModelScope.launch(Dispatchers.IO) {
            serviceRepository.updateServiceList(context)
        }
    }
    fun getServiceList2(context: Context, onError: () -> Unit) {
        viewModelScope.launch {
            serviceRepository.getServiceList2(context)
                .flowOn(Dispatchers.IO)
                .catch {
                    it.printStackTrace()
                    onError()
                }
                .collect {
                    serviceList.value = it
                    println(it.toString())
                }
        }
        viewModelScope.launch(Dispatchers.IO) {
            serviceRepository.updateServiceList(context)
        }
    }



}