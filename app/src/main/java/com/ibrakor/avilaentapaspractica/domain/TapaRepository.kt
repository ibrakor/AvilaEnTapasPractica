package com.ibrakor.avilaentapaspractica.domain

import com.ibrakor.avilaentapaspractica.app.Either
import com.ibrakor.avilaentapaspractica.app.ErrorApp

interface TapaRepository {

    fun obtainTapa():Either<ErrorApp,List<Tapa>>

}