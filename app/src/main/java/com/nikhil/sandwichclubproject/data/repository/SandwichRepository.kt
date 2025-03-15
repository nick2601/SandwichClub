package com.nikhil.sandwichclubproject.data.repository
import com.nikhil.sandwichclubproject.data.local.SandwichDataSource
import com.nikhil.sandwichclubproject.data.model.Sandwich
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SandwichRepository @Inject constructor(private val dataSource: SandwichDataSource) {

    fun getSandwichList(): Flow<List<Sandwich>> = flow {
        emit(dataSource.getSandwichList())
    }

    fun getSandwichListFromAssets(): Flow<List<Sandwich>> = flow {
        emit(dataSource.getSandwichListFromAssets())
    }
}