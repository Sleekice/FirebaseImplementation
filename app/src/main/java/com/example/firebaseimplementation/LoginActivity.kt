package com.example.firebaseimplementation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseimplementation.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        //var database = FirebaseDatabase.getInstance().reference


        binding.textViewSignUp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


            binding.buttonSignIn.setOnClickListener {
                val email = binding.editTextEmailAddress.text.toString()
                val pass = binding.editTextPassword.text.toString()

                if (email.isNotEmpty() && pass.isNotEmpty()) {

                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {

                            val user = firebaseAuth.currentUser
                            updateSignedInUser(user)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                } else {
                    Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

                }
            }
        }}

        override fun onStart() {
            super.onStart()

                // Check if user is signed in (non-null) and update UI accordingly.
                var currentUser = firebaseAuth.currentUser


            if(firebaseAuth.currentUser != null){
                    updateSignedInUser(currentUser)

            }
        }

    private fun updateSignedInUser(user: FirebaseUser?){
        Toast.makeText(this, "Taste Like Bread !!", Toast.LENGTH_SHORT).show()

    }
    }


