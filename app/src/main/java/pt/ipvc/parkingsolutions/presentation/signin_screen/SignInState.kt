package pt.ipvc.parkingsolutions.presentation.signin_screen

data class SignInState (
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = "",
)