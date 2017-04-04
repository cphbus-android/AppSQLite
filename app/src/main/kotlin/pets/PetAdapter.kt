package pets

import android.view.*
import android.widget.BaseAdapter
import android.widget.TextView
import app.App
import app.R

class PetAdapter(var listpets: List<Map<String, Any?>>) : BaseAdapter() {

    override fun getView(position: Int, view: View?, viewgroup: ViewGroup): View {

        val viewpetslist = LayoutInflater.from(App.instance).inflate(R.layout.pet_list, viewgroup, false);

        val textViewPetName = viewpetslist.findViewById(R.id.petname) as TextView
        val textViewPetAge = viewpetslist.findViewById(R.id.petage) as TextView

        val item = getItem(position)

        textViewPetName.text = item["petName"].toString()
        textViewPetAge.text = item["petAge"].toString()

        return viewpetslist
    }

    override fun getItem(position: Int): Map<String, Any?> {
        return listpets.get(position)
    }

    override fun getCount(): Int {
        return listpets.size
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).get("petID") as Long;
    }
}
