package buu.informatics.s59160081.parkinglot


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160081.parkinglot.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        binding.LoginButton.setOnClickListener{view: View->
            checkUsername(view)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun checkUsername(view: View){
        if (username_text.text.toString().equals("admin") && password_text.text.toString().equals("1234")){
            view.findNavController()
                .navigate(R.id.action_loginFragment_to_mainFragment)
        }else{
            Toast.makeText(activity, "username is : admin , password is : 1234", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())
                ||super.onOptionsItemSelected(item)
    }


}
