package tech.lightion.tmdb.ui.fragments

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Transition
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import tech.lightion.tmdb.R
import tech.lightion.tmdb.databinding.FragmentLoginBinding
import tech.lightion.tmdb.viewmodel.LoginViewModel

/**
 * A [Fragment] subclass used for the authentication including user login and user sign up
 */
class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpButton.setOnClickListener {
            val set = ConstraintSet()
            val transition: Transition = ChangeBounds()
            set.clone(context, R.layout.signin_layout)
            set.applyTo(binding.rootLayout)
            transition.interpolator = OvershootInterpolator()
            transition.duration = 2000
            TransitionManager.beginDelayedTransition(binding.rootLayout, transition)
        }

        binding.registerLoginButton.setOnClickListener {
            val set = ConstraintSet()
            val transition: Transition = ChangeBounds()
            set.clone(context, R.layout.fragment_login)
            set.applyTo(binding.rootLayout)
            transition.interpolator = OvershootInterpolator()
            transition.duration = 2000
            TransitionManager.beginDelayedTransition(binding.rootLayout, transition)
        }

        initObserver()
    }

    private fun initObserver() {
        viewModel.loginButton.observe(requireActivity(), Observer {
            viewModel.performLogin(
                binding.loginUserName.text.toString(),
                binding.loginPassword.text.toString()
            )
        })
        viewModel.canUserLogin.observe(requireActivity(), Observer {
            if (it) {
                Toast.makeText(context, "User Can Login", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            } else {
                binding.loginUserNameInputLayout.error = "Incorrect Username"
                binding.loginUserName.error = ""
            }
        })
        viewModel.loginUserError.observe(requireActivity(), Observer {
            if (it) {
                Toast.makeText(context, "Nope", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.registerButton.observe(requireActivity(), Observer {
            viewModel.signUp(binding.registerUserName.text.toString(), binding.registerPassword.text.toString())
        })
        viewModel.userAlreadyExistError.observe(requireActivity(), Observer {
            if(it){
                binding.registerUserNameInputLayout.error = "User already Exists"
            }
        })
    }

}
