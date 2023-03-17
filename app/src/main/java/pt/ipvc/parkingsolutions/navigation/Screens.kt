package pt.ipvc.parkingsolutions.navigation

sealed class Screens(val route: String) {
    object SignInScreen: Screens(route = "SignIn_Screen")
    object SignUpScreen: Screens(route = "SignUp_Screen")

    object ParksScreen: Screens(route = "Parks_Screen")
}