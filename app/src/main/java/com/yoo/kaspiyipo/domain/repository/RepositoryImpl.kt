package com.yoo.kaspiyipo.domain.repository

//import com.yoo.kaspiyipo.domain.manager.DataStoreManager
//import kotlinx.coroutines.flow.Flow
//import javax.inject.Inject
//
//class RepositoryImpl @Inject constructor(
//    private val dataStoreManager: DataStoreManager
//):Repository {
//    override suspend fun saveId(index: Int) {
//        dataStoreManager.saveId(index)
//    }
//
//    override fun getId(): Flow<Int> {
//        return dataStoreManager.getId()
//    }
//
//    override suspend fun saveName(name: String) {
//        dataStoreManager.saveName(name)
//    }
//
//    override fun getName(): Flow<String> {
//        return getName()
//    }
//
//    override suspend fun saveGmail(gmail: String) {
//        dataStoreManager.saveGmail(gmail)
//    }
//
//    override fun getGmail(): Flow<String> {
//        return getGmail()
//    }
//}