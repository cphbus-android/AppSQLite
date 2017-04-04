package app

import android.app.Activity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import pets.PetAdapter
import pets.PetController

class ActivityMain : Activity()
{
    val PetAnimalCtrl: PetController = PetController()
    var selectedPet: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PetAnimalCtrl.setup()

        petList()

        top.text = "AnimalPets\n"

        buttonPetAdd.setOnClickListener { petAdd() }

        buttonPetDelete.setOnClickListener { petDelete() }

        PetsList.setOnItemClickListener({ adapter, view, position, id ->
            Log.d("AnimalPets", "Pet - ListPosition:" + position + " ID:" + id)

            selectedPet = id.toInt()

            //PetsList.getChildAt(position).setBackgroundColor(Color.BLUE)
        })
    }

    fun petAdd() {
        PetAnimalCtrl.addPet(editPetName.text.toString(), editPetAge.text.toString().toInt())

        editPetName.setText("")
        editPetAge.setText("")

        petList()
    }

    fun petDelete() {
        PetAnimalCtrl.deletePet(selectedPet)

        petList()
    }

    fun petList() {
        PetsList.adapter = PetAdapter(PetAnimalCtrl.getPets())
    }
}
