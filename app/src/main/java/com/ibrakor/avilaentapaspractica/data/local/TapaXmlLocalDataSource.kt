package com.ibrakor.avilaentapaspractica.data.local

import android.content.Context
import com.ibrakor.avilaentapaspractica.app.Either
import com.ibrakor.avilaentapaspractica.app.ErrorApp
import com.ibrakor.avilaentapaspractica.app.left
import com.ibrakor.avilaentapaspractica.app.right
import com.ibrakor.avilaentapaspractica.app.serialization.JsonSerialization
import com.ibrakor.avilaentapaspractica.domain.Tapa
import java.lang.Exception

class TapaXmlLocalDataSource (private val context: Context, private val jsonSerialization: JsonSerialization){
    val sharedPred = context.getSharedPreferences("tapas", Context.MODE_PRIVATE)

    fun saveTapa(tapa:Tapa):Either<ErrorApp,Boolean>{
        return try{
            with(sharedPred.edit()){
                val jsonTapa=jsonSerialization.toJson(tapa,Tapa::class.java)
                putString(tapa.id.toString(),jsonTapa)
                apply()
            }
            return true.right()
        }catch (ex:Exception){
            return ErrorApp.UnknownError.left()
        }
    }

    fun getTapa(): Either<ErrorApp, List<Tapa>>{
        return try {
            val jsonTapas = sharedPred.all as Map<String, String>
            val tapas = jsonTapas.values.map {
                jsonSerialization.fromJson(it, Tapa::class.java)
            }
            return tapas.right()
        } catch (ex: Exception){
            return ErrorApp.DataErrorApp.left()
        }
    }
}