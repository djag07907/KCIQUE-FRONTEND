package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
//        value = "sdf"
    }

    val text: LiveData<String> = _text
}