package com.example.inventa_app

import android.app.Application
import android.util.Log
import android.widget.ViewSwitcher.ViewFactory
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.inventa_app.database.room.AppRoomDatabase
import com.example.inventa_app.database.room.ItemRoomDatabase
import com.example.inventa_app.database.room.repository.ItemRoomRepository
import com.example.inventa_app.database.room.repository.RoomRepository
import com.example.inventa_app.model.ItemDataModel
import com.example.inventa_app.model.Postman
import com.example.inventa_app.utils.ITEM_REPOSITORY
import com.example.inventa_app.utils.REPOSITORY
import com.example.inventa_app.utils.TYPE_ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    val context= application

    fun initDatabase(){
        val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
        REPOSITORY = RoomRepository(dao)

    }
    fun  initItemDatabase(){
        val dao = ItemRoomDatabase.getInstance(context = context).getRoomDao()
        ITEM_REPOSITORY = ItemRoomRepository(dao)
    }
    fun addPostman(postman: Postman,onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.create(postman = postman){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess
                }
            }
        }
    }
    fun deletePost(postman: Postman,onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
        REPOSITORY.delete(postman = postman){
            viewModelScope.launch(Dispatchers.Main){
                onSuccess
                }
            }
        }
    }
    fun addItem(item:ItemDataModel,onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            ITEM_REPOSITORY.create(item = item){
                viewModelScope.launch (Dispatchers.Main){
                    onSuccess
                }
            }
        }
    }
    fun deleteItem(item: ItemDataModel,onSuccess: () -> Unit){
        viewModelScope.launch (Dispatchers.IO){
            ITEM_REPOSITORY.delete(item = item){
                viewModelScope.launch (Dispatchers.Main){
                    onSuccess
                }
            }
        }
    }
    fun readAllPosts() = REPOSITORY.readAll
    fun readAllItem() = ITEM_REPOSITORY.readAll
}
class MainViewModelFactory(private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}