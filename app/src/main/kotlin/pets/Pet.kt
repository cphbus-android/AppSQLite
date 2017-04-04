package pets

import java.io.Serializable

data class Pet(
        val petID: Int,
        var petName: String,
        var petAge: Int
) : Serializable

object PetTable {
    val tableName = "Pet"
    val petID = "petID"
    val petName = "petName"
    val petAge = "petAge"
}