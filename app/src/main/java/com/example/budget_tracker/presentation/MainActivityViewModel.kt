package com.example.budget_tracker.presentation

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.util.Log
import android.widget.Toast

import com.example.budget_tracker.domain.*
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import androidx.lifecycle.*
import com.example.budget_tracker.Db.*


class MainActivityViewModel(
    private val getTagUseCase: GetTagUseCase,
    private val getExpenseUseCase: GetExpenseUseCase,
    private val saveExpenseUseCase: SaveExpenseUseCase,
    private val saveTagUseCase: SaveTagUseCase,
    private val deleteTagUseCase: DeleteTagUseCase,
    private val deleteExpenseUseCase: DeleteExpenseUseCase
) : ViewModel(){
    private val currentValue=MutableLiveData<String>()
    val current_value:LiveData<String>
    get()=currentValue

    private val currentTag=MutableLiveData<String>()
    val current_tag:LiveData<String>
    get()=currentTag

    fun onItemSelected(a:String){
        currentTag.value=a
    }
    fun getEquation():LiveData<List<Expense>?> = liveData{
        val equationList=getExpenseUseCase.getExpenses()
        emit(equationList)
    }
    @SuppressLint("SuspiciousIndentation")
    fun saveDataToDatabse(){
        if(currentValue!=null && currentTag.value.toString()!="Select a Tag"){
            val Time = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") // Define a format if needed
            val FormatTime = Time.format(formatter)
            val value= Expense(0, currentValue.value!!.toFloat(),FormatTime.toString(),currentTag.value.toString())
            Log.i("Mytag", value.toString())
            viewModelScope.launch {
                if(value!=null)
                    saveExpenseUseCase.saveExpense(value)
            }
        }
    }
    fun saveTagToDatabase(a: String){
        val tags=getTagFromDB()
        val containsA = tags.value?.any { tag ->
            tag.name == a
        } ?: false
        Log.i("Mytag",tags.toString())
        if(containsA){

        }
        else{
        viewModelScope.launch {
            val value= Tags(0,a)
            saveTagUseCase.savetag(value)}
        }
    }
        fun getTagFromDataBase():LiveData<List<Tags>> = liveData {
            val a=getTagUseCase.gettags()
            emit(a)

        }
    fun getTagFromDB(): LiveData<List<Tags>> = liveData {
        val a = getTagUseCase.gettags()
        emit(a)
    }



}