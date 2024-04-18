package com.example.aspecttest.di

import com.example.aspecttest.utils.ResourceProvider
import com.example.aspecttest.utils.ResourceProviderImpl
import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun bindResourceProviderImpl(resourceProviderImpl: ResourceProviderImpl): ResourceProvider
}