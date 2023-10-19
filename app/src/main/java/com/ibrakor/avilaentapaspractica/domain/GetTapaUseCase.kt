package com.ibrakor.avilaentapaspractica.domain

import com.ibrakor.avilaentapaspractica.app.Either
import com.ibrakor.avilaentapaspractica.app.ErrorApp

class GetTapaUseCase (private val repository: TapaRepository){

    operator fun invoke():Either<ErrorApp,List<Tapa>>{
        return repository.obtainTapa()
    }


}