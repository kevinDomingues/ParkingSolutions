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
    val state = mutableStateOf(listOf<Park>())

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            state.value = getParksFromFireStore()
        }
    }
}


suspend fun getParksFromFireStore():List<Park>{
    val db = FirebaseFirestore.getInstance()
    val parks = mutableListOf<Park>()

    try {
        db.collection("park").get().await().map {
            val result = it.toObject(Park::class.java)
            parks.add(result)
        }
    } catch (e: FirebaseFirestoreException) {
        Log.d("Error", "getDataFromFireStore: $e")
    }

    return parks.toList()
}