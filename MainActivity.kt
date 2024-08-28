package com.example.hesapmakinesi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.hesapmakinesi.ui.theme.HesapMakinesiTheme
import com.example.hesapmakinesi.viewmodel.HesaplayiciViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val hesaplayiciViewModel=ViewModelProvider(this)[HesaplayiciViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            HesapMakinesiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Hesaplayici(modifier = Modifier.padding(innerPadding),hesaplayiciViewModel)
                }
            }
        }
    }
}

