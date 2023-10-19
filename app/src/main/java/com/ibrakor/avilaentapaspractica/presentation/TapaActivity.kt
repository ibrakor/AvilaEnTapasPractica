package com.ibrakor.avilaentapaspractica.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.avilaentapaspractica.R
import com.example.avilaentapaspractica.databinding.ActivityTapasavilaBinding
import com.ibrakor.avilaentapaspractica.app.ErrorApp
import com.ibrakor.avilaentapaspractica.app.serialization.GsonSerialization
import com.ibrakor.avilaentapaspractica.data.TapaDataRepository
import com.ibrakor.avilaentapaspractica.data.local.TapaXmlLocalDataSource
import com.ibrakor.avilaentapaspractica.data.remote.ApiMockTapaRemoteDataSource
import com.ibrakor.avilaentapaspractica.domain.GetTapaUseCase
import com.ibrakor.avilaentapaspractica.domain.Tapa

class TapaActivity : AppCompatActivity() {

    lateinit var binding: ActivityTapasavilaBinding

    val viewModels:TapaViewModel by lazy {
        TapaViewModel( GetTapaUseCase(TapaDataRepository(TapaXmlLocalDataSource(this,GsonSerialization()),
            ApiMockTapaRemoteDataSource()
        )))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun bindView(){
        binding = ActivityTapasavilaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpObservers(){
        val observer= Observer<TapaViewModel.UiState>{
            if(it.isLoading){

            }
            else{

            }
            it.errorApp?.apply {
                showError(this)
            }
            it.tapa?.apply {
                bindData(this)
            }
        }
    }

    private fun bindData(tapa: List<Tapa>) {

    }

    private fun showError(errorApp: ErrorApp) {

    }

}