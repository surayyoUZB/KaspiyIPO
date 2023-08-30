package com.yoo.kaspiyipo.domain.manager

//import android.content.Context
//import androidx.datastore.preferences.core.booleanPreferencesKey
//import androidx.datastore.preferences.core.edit
//import androidx.datastore.preferences.core.intPreferencesKey
//import androidx.datastore.preferences.core.stringPreferencesKey
//import androidx.datastore.preferences.preferencesDataStore
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//
//class DataStoreManager(
//    private val context: Context
//) {
//    private val Context.dataStore by preferencesDataStore("my_pref")
//
//    companion object {
//        private val ID = intPreferencesKey("id")
//        private val NAME = stringPreferencesKey("name")
//        private val GMAIL = stringPreferencesKey("gmail")
//    }
//
//    suspend fun saveId(index: Int) {
//        context.dataStore.edit {
//            it[ID] = index
//        }
//    }
//
//    fun getId(): Flow<Int> = context.dataStore.data.map {
//        it[ID] ?: 0
//    }
//    suspend fun saveName(name: String) {
//        context.dataStore.edit {
//            it[NAME] = name
//        }
//    }
//
//    fun getName(): Flow<String> = context.dataStore.data.map {
//        it[NAME] ?: "user"
//    }
//    suspend fun saveGmail(gmail: String) {
//        context.dataStore.edit {
//            it[GMAIL] = gmail
//        }
//    }
//
//    fun getGmail(): Flow<String> = context.dataStore.data.map {
//        it[GMAIL] ?: "user@gmail.com"
//    }
//}