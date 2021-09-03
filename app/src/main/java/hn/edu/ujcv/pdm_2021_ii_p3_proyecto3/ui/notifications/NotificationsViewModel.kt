package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
//        value = "Fragment de Notificaciones"
    }
    val text: LiveData<String> = _text
}