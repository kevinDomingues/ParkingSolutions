package pt.ipvc.parkingsolutions.presentation.parks

data class Park(
    val name:String = "",
    val location:String = "",
    val nFreeSpaces:Int = 0,
    val image:String = "",
)