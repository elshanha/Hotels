package com.example.hotels.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.common.base.BaseFragment
import com.example.common.base.BaseViewModel
import com.example.hotels.R
import com.example.hotels.databinding.FragmentRegisterBinding
import com.example.hotels.viewmodels.HotelsViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: HotelsViewModel by viewModels()
    override fun mViewModel(): BaseViewModel {
        return viewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpButton.setOnClickListener {
            register()
        }

    }



    private fun register() {
        val auth = Firebase.auth
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
            auth.createUserWithEmailAndPassword(
                email, password
            )
                .addOnSuccessListener {

                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                }
                .addOnFailureListener {
                    Toast.makeText(
                        context,
                        it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
        } else {
            Toast.makeText(
                context,
                getString(R.string.Fill_fields),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}