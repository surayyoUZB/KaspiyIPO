package com.yoo.kaspiyipo.ui.screens.register

//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.yoo.kaspiyipo.domain.repository.Repository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class ViewModel @Inject constructor(
//    private val repository: Repository
//):ViewModel() {
//    var id= mutableStateOf(0)
//    var name= mutableStateOf("null")
//    var gmail= mutableStateOf("null")
//    init {
//        viewModelScope.launch {
//            repository.getId().collectLatest {
//                id.value=it
//            }
//        }
//        viewModelScope.launch {
//            repository.getId().collectLatest {
//                id.value=it
//            }
//        }
//        viewModelScope.launch {
//            repository.getId().collectLatest {
//                id.value=it
//            }
//        }
//    }
//    fun saveId(index:Int){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.saveId(index)
//        }
//    }
//    fun saveName(name:String){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.saveName(name)
//        }
//    }
//    fun saveGmail(gmail:String){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.saveGmail(gmail)
//        }
//    }
//}