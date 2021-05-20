package com.arno.jasmine.lib.di

import com.arno.jasmine.lib.data.DataRepository
import com.arno.jasmine.lib.data.IDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/20
 *     desc  :
 * </pre>
 */
@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindDataRepository(dataRepository: DataRepository): IDataRepository
}