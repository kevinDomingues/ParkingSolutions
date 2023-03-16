package pt.ipvc.parkingsolutions.data

import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import pt.ipvc.parkingsolutions.util.Resource

interface AuthRepository {
    fun loginUser(email:String, password:String): Flow<Resource<AuthResult>>
    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>
}