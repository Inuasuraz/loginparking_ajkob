package buu.informatics.s59160081.parkinglot


import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160081.parkinglot.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var Lot_One: Parking = Parking("","","")
    private var Lot_Two: Parking = Parking("","","")
    private var Lot_Three: Parking = Parking("","","")
    private var select = 0
    private var operation = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main,container,false)

        binding.apply{
            ButtonUpdate.visibility = View.INVISIBLE
            ButtonDelete.visibility = View.INVISIBLE
            License.visibility = View.INVISIBLE
            Name.visibility = View.INVISIBLE
            Phone.visibility = View.INVISIBLE
            ButtonOne.setOnClickListener{
                select = 1
                show(binding)
            }
            ButtonTwo.setOnClickListener{
                select = 2
                show(binding)
            }
            ButtonThree.setOnClickListener{
                select = 3
                show(binding)
            }
            ButtonUpdate.setOnClickListener{
                update(binding)
            }
            ButtonDelete.setOnClickListener{
                delete(binding)
            }
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())
                ||super.onOptionsItemSelected(item)
    }

    private fun update(fragment: FragmentMainBinding){

        fragment.apply{
            if (select == 1){
                if (License.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                    Name.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                    Phone.text.toString().replace("\\s".toRegex(), "").length < 1){
                    operation = 1
                    alert(fragment)
                }else{
                    Lot_One.license = License.text.toString()
                    Lot_One.name = Name.text.toString()
                    Lot_One.phone = Phone.text.toString()
                    ButtonOne.setBackgroundColor(Color.parseColor("#c94f59"))
                    operation = 2
                    alert(fragment)
                }

            }else if (select == 2){
                if (License.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                    Name.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                    Phone.text.toString().replace("\\s".toRegex(), "").length < 1){
                    operation = 1
                    alert(fragment)
                }else{
                    Lot_Two.license = License.text.toString()
                    Lot_Two.name = Name.text.toString()
                    Lot_Two.phone = Phone.text.toString()
                    ButtonTwo.setBackgroundColor(Color.parseColor("#c94f59"))
                    operation = 2
                    alert(fragment)
                }
            }else if (select == 3){
                if (License.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                    Name.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                    Phone.text.toString().replace("\\s".toRegex(), "").length < 1){
                    operation = 1
                    alert(fragment)
                }else{
                    Lot_Three.license = License.text.toString()
                    Lot_Three.name = Name.text.toString()
                    Lot_Three.phone = Phone.text.toString()
                    ButtonThree.setBackgroundColor(Color.parseColor("#c94f59"))
                    operation = 2
                    alert(fragment)
                }
            }
        }


    }

    private fun delete(fragment: FragmentMainBinding){
        fragment.apply{
            if (select == 1){
                Lot_One.license = ""
                Lot_One.name = ""
                Lot_One.phone = ""
                show(fragment)
                operation = 3
                alert(fragment)
            }else if (select == 2){
                Lot_Two.license = ""
                Lot_Two.name = ""
                Lot_Two.phone = ""
                show(fragment)
                operation = 3
                alert(fragment)
            }else if (select == 3){
                Lot_Three.license = ""
                Lot_Three.name = ""
                Lot_Three.phone = ""
                show(fragment)
                operation = 3
                alert(fragment)
            }
        }

    }

    private fun show(fragment: FragmentMainBinding){
        setBackground(fragment)

        fragment.apply{
            if (select == 1){
                if (!Lot_One.license.equals("")){
                    ButtonOne.setBackgroundColor(Color.parseColor("#c94f59"))
                }else{
                    ButtonOne.setBackgroundColor(Color.parseColor("#48a3b0"))
                }
                License.setText(Lot_One.license)
                Name.setText(Lot_One.name)
                Phone.setText(Lot_One.phone)
            }else if (select == 2){
                if (!Lot_Two.license.equals("")){
                    ButtonTwo.setBackgroundColor(Color.parseColor("#c94f59"))
                }else{
                    ButtonTwo.setBackgroundColor(Color.parseColor("#48a3b0"))
                }
                License.setText(Lot_Two.license)
                Name.setText(Lot_Two.name)
                Phone.setText(Lot_Two.phone)
            }else if (select == 3){
                if (!Lot_Three.license.equals("")){
                    ButtonThree.setBackgroundColor(Color.parseColor("#c94f59"))
                }else{
                    ButtonThree.setBackgroundColor(Color.parseColor("#48a3b0"))
                }
                License.setText(Lot_Three.license)
                Name.setText(Lot_Three.name)
                Phone.setText(Lot_Three.phone)

            }
        }

    }

    private fun setBackground(fragment: FragmentMainBinding){
        fragment.apply{
            ButtonUpdate.visibility = View.VISIBLE
            ButtonDelete.visibility = View.VISIBLE
            License.visibility = View.VISIBLE
            Name.visibility = View.VISIBLE
            Phone.visibility = View.VISIBLE
            if (!Lot_One.license.equals("")){
                ButtonOne.setBackgroundColor(Color.parseColor("#ff6673"))
            }else{
                ButtonOne.setBackgroundColor(Color.parseColor("#66E8FA"))
            }
            if (!Lot_Two.license.equals("")){
                ButtonTwo.setBackgroundColor(Color.parseColor("#ff6673"))
            }else{
                ButtonTwo.setBackgroundColor(Color.parseColor("#66E8FA"))
            }
            if (!Lot_Three.license.equals("")){
                ButtonThree.setBackgroundColor(Color.parseColor("#ff6673"))
            }else{
                ButtonThree.setBackgroundColor(Color.parseColor("#66E8FA"))
            }
        }

    }

    private fun alert(fragment: FragmentMainBinding) {

        if (operation == 1) {
            Toast.makeText(activity, "Please fill up all the box", Toast.LENGTH_LONG).show()
        } else if (operation == 2) {
            Toast.makeText(activity, "Update complete", Toast.LENGTH_LONG).show()
        } else if (operation == 3) {
            Toast.makeText(activity, "Delete complete", Toast.LENGTH_LONG).show()
        } else if (operation == 4) {
            Toast.makeText(activity, "Please fill up correct informations", Toast.LENGTH_LONG).show()
        }

    }


}
