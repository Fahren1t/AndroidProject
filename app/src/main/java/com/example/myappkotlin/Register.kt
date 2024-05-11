package com.example.myappkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myappkotlin.databinding.ActivityLoginBinding
import com.example.myappkotlin.databinding.ActivityRegisterBinding
import com.example.myappkotlin.ui.theme.MyAppKotlinTheme
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class Register : ComponentActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var fireBaseAuth: FirebaseAuth
    private val TAG = "MyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fireBaseAuth = FirebaseAuth.getInstance()

        /*binding.clickableText.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }*/
        binding.registerButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()
            val confirmPassword = binding.rePasswordInput.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    fireBaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener() {
                            if (it.isSuccessful) {
                                val intent = Intent(this, Login::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                } else {
                    Toast.makeText(this, "passwords are not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty fields are not allowed!", Toast.LENGTH_SHORT).show()
            }

        }

    }
    fun onTextClicked(view: View) {
        Log.e(TAG,"asd ben kemal")
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

}


