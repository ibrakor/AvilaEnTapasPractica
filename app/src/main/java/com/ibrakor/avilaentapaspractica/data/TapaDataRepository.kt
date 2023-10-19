package com.ibrakor.avilaentapaspractica.data

import com.ibrakor.avilaentapaspractica.app.Either
import com.ibrakor.avilaentapaspractica.app.ErrorApp
import com.ibrakor.avilaentapaspractica.data.local.TapaXmlLocalDataSource
import com.ibrakor.avilaentapaspractica.data.remote.ApiMockTapaRemoteDataSource
import com.ibrakor.avilaentapaspractica.domain.Tapa
import com.ibrakor.avilaentapaspractica.domain.TapaRepository

class TapaDataRepository(private val localDataSource: TapaXmlLocalDataSource,
                        private val remoteDataRepository:ApiMockTapaRemoteDataSource
                    ):TapaRepository {
    override fun obtainTapa(): Either<ErrorApp, List<Tapa>> {
        return if(localDataSource.getTapa().get().size!=0){
            localDataSource.getTapa()
        }else{
            return remoteDataRepository.obtain().map{
                for (i in it.indices){
                    localDataSource.saveTapa(it[i])
                }
                it
            }
        }
    }
}