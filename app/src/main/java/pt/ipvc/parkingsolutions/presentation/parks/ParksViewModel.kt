package pt.ipvc.parkingsolutions.presentation.parks

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ParksViewModel: ViewModel(){
    val state = mutableStateOf(Park())

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            state.value = getParksFromFireStore()
        }
    }
}


suspend fun getParksFromFireStore():Park{
    val db = FirebaseFirestore.getInstance()
    var parks = Park()

    try {
        db.collection("park").get().await().map {
            val result = it.toObject(Park::class.java)
            parks = result
        }
    } catch (e: FirebaseFirestoreException) {
        Log.d("Error", "getDataFromFireStore: $e")
    }

    return parks;
}