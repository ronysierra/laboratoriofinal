package com.example.laboratoriopersonal.ui.results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
  //      value = "Estos son los resultados de tus exámenes de laboratorio"
    }
    val text: LiveData<String> = _text
}