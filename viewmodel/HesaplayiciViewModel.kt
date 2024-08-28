package com.example.hesapmakinesi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class HesaplayiciViewModel:ViewModel() {
    private val _equationText=MutableLiveData("")
    val equationText:LiveData<String> = _equationText

    private val _resultText=MutableLiveData("0")
    val resultText:LiveData<String> = _resultText
    fun onButtonClick(btn:String){
        Log.i("Clicked button",btn)

        _equationText.value?.let {
            if (btn=="AC"){
                _equationText.value = ""
                _resultText.value = "0"
                return
            }
            if (btn=="C"){
                if (it.isNotEmpty()){
                    _equationText.value=it.substring(0,it.length-1)
                    return
                }
            }
            if (btn == "="){
                _equationText.value=_resultText.value
                return
            }

            _equationText.value=it + btn

            //sonucu hesapla
            try {
                _resultText.value=sonucuHesapla(_equationText.value.toString())
            }catch (_ : Exception){

            }

        }
    }
    fun sonucuHesapla(equation:String):String{
        val context:Context=Context.enter()
        context.optimizationLevel=-1
        val scriptable:Scriptable=context.initStandardObjects()
        val  finalSonuc=context.evaluateString(scriptable,equation,"Javascript",1,null).toString()
        return finalSonuc

    }
}