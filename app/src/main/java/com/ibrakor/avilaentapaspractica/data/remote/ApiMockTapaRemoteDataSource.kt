package com.ibrakor.avilaentapaspractica.data.remote

import com.ibrakor.avilaentapaspractica.app.Either
import com.ibrakor.avilaentapaspractica.app.ErrorApp
import com.ibrakor.avilaentapaspractica.app.right
import com.ibrakor.avilaentapaspractica.domain.Tapa

class ApiMockTapaRemoteDataSource {
    fun obtain(): Either<ErrorApp, List<Tapa>>{
        val tapa = Tapa(1,"Albóndiga de faisán en escabeche con caldo clarificado de gambón salvaje","Vermuteria el Atrio",0,0.0,
            "https://gourmetabulense.files.wordpress.com/2021/06/26-vermuteria-el-atrio-albondiga-de-faisan-en-escabeche-con-caldo-clarificado-de-gambon-salvaje.jpg")
        val tapas : MutableList<Tapa> = mutableListOf(tapa)
        return tapas.right()

    }
}