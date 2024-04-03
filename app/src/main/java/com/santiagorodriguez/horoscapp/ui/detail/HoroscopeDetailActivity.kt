package com.santiagorodriguez.horoscapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.santiagorodriguez.horoscapp.R
import com.santiagorodriguez.horoscapp.databinding.ActivityHoroscopeDetailBinding
import com.santiagorodriguez.horoscapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel:HoroscopeDetailViewModel by viewModels()
    private val args:HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeDetailViewModel.state.collect{
                    when(it){
                        is HoroscopeDetailState.Error -> errorState()
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Success -> successState()
                    }
                }
            }
        }
    }

    private fun successState() {
        TODO("Not yet implemented")
    }

    private fun errorState() {
        TODO("Not yet implemented")
    }

    private fun loadingState() {
        binding.pb.isVisible = true
    }
}