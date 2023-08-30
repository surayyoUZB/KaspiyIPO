package com.yoo.kaspiyipo.domain.di

//import android.content.Context
//import com.yoo.kaspiyipo.domain.manager.DataStoreManager
//import com.yoo.kaspiyipo.domain.repository.Repository
//import com.yoo.kaspiyipo.domain.repository.RepositoryImpl
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import java.util.concurrent.TimeUnit
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Provides
//    @Singleton
//    fun provideRepository(
//        dataStoreManager: DataStoreManager
//    ): Repository {
//        return RepositoryImpl(dataStoreManager=dataStoreManager)
//    }
//
//    @Provides
//    @Singleton
//    fun provideDataStore(
//        @ApplicationContext context: Context
//    ): DataStoreManager {
//        return DataStoreManager(context)
//    }
//}