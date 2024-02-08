package com.example.hotels.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.common.base.BaseFragment
import com.example.common.base.BaseViewModel
import com.example.hotels.R
import com.example.hotels.databinding.FragmentLoginBinding
import com.example.hotels.viewmodels.HotelsViewModel
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: HotelsViewModel by viewModels()
    override fun mViewModel(): BaseViewModel {
        return viewModel
    }

    private lateinit var auth: FirebaseAuth



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        binding.signInButton.setOnClickListener {
            loginGoogle()
        }

        binding.signUpTextButton.setOnClickListener {
            openRegister()
        }

//        binding.googleButton.setOnClickListener {
//            loginGoogle()
//        }
    }


    private lateinit var signInRequest: BeginSignInRequest

    private val REQ_ONE_TAP = 2  // Can be any integer unique to the Activity
    private lateinit var mGoogleSignInClient : GoogleSignInClient
     fun loginGoogle() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestServerAuthCode(getString(R.string.google_client_id))
            .requestIdToken(getString(R.string.google_client_id))
            .requestEmail().build()

        mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId(getString(R.string.google_client_id))
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(true)
                    .build())
            .build()

        val signInIntent = mGoogleSignInClient.signInIntent
        googleLauncher.launch(signInIntent)
    }

    private val googleLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: androidx.activity.result.ActivityResult ->

        result.data?.let {
            var result = Auth.GoogleSignInApi.getSignInResultFromIntent(it)
            if(result?.isSuccess == true) {
                val acct = result.signInAccount
                val authCode = acct!!.serverAuthCode
                val idToken = acct.idToken

                val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
                Firebase.auth.signInWithCredential(firebaseCredential)
                    .addOnCompleteListener(requireActivity()) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            openHome()
                            val user = auth.currentUser
                            //updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                context,
                                getString(R.string.login_failed),
                                Toast.LENGTH_SHORT
                            ).show()
                            //updateUI(null)
                        }
                    }
            }
        }

    }


    private fun login() {

        var email = binding.emailEditText.text.toString()
        var password = binding.passwordEditText.text.toString()

        val auth = Firebase.auth
        if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
            auth.signInWithEmailAndPassword(
                email, password
            )
                .addOnSuccessListener {
                    openHome()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        context,
                        getString(R.string.login_error),
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

    private fun openHome() {

        findNavController().navigate(R.id.action_loginFragment_to_hotelsFragment)

    }

    private fun openRegister() {

        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

}

