package com.devrachit.swiggy_xml_imdb.di.modules

import com.devrachit.swiggy_xml_imdb.data.repository.ApiServicesRepositoryImpl
import com.devrachit.swiggy_xml_imdb.domain.repository.ApiServicesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(repositoryImpl: ApiServicesRepositoryImpl): ApiServicesRepository
}