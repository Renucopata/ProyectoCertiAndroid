package com.first.mascotapp.fragments.viewModels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.first.mascotapp.data.repositories.LostRepository
import com.first.mascotapp.models.LostItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class LostViewModel: ViewModel() {
    val lostRepository = LostRepository()
    val lostList = MutableLiveData(listOf<LostItemModel>())


    fun getLostList(context: Context, onError: () -> Unit) {
         viewModelScope.launch {
            lostRepository.getLostList(context)
                .flowOn(Dispatchers.IO)
                .catch {
                    it.printStackTrace()
                    onError()
                }
                .collect {
                    lostList.value = it
                    println(it.toString())
                }
        }
        viewModelScope.launch(Dispatchers.IO) {
            lostRepository.updateLostList(context)
        }
    }

}