package com.loc.newsapp.data.di

import android.app.Application
import com.loc.newsapp.data.manager.LocalUserManagerImpl
import com.loc.newsapp.data.remote.NewsApi
import com.loc.newsapp.data.repository.NewsRepositoryImpl
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.domain.manager.usercases.app_entry.AppEntryUseCases
import com.loc.newsapp.domain.manager.usercases.app_entry.ReadAppEntry
import com.loc.newsapp.domain.manager.usercases.app_entry.SaveAppEntry
import com.loc.newsapp.domain.manager.usercases.news.GetNews
import com.loc.newsapp.domain.manager.usercases.news.NewsUseCases
import com.loc.newsapp.domain.manager.usercases.news.SearchNews
import com.loc.newsapp.domain.repository.NewsRepository
import com.loc.newsapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application:Application
    ) : LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppUseCases(
        localUserManager: LocalUserManager
    )  =  AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewApi() : NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ) : NewsRepository = NewsRepositoryImpl(newsApi = newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ) : NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository = newsRepository),
            searchNews = SearchNews(newsRepository = newsRepository)
        )
    }
}