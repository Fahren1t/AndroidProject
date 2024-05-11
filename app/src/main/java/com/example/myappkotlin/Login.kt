package com.example.myappkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myappkotlin.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var fireBaseAuth: FirebaseAuth
    private val TAG = "MyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fireBaseAuth = FirebaseAuth.getInstance()

        /*binding.clickableText.setOnClickListener(){
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }*/
        binding.loginButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()


            if (email.isNotEmpty() && password.isNotEmpty()) {

                fireBaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener() {
                        if (it.isSuccessful) {
                            Log.e(TAG,"basardik")
                            val intent1 = Intent(this, MainMenu::class.java)
                            startActivity(intent1)
                        } else {
                            Log.e(TAG,"basarisiaz olduk")
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

            } else {
                Toast.makeText(this, "Empty fields are not allowed!", Toast.LENGTH_SHORT).show()
            }
        }


    }



    override fun onStart() {
        super.onStart()
        Log.e(TAG,"asd ben kemal")
        if (fireBaseAuth.currentUser != null && intent.component?.className != Register::class.java.name){
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
    }


    fun onTextClicked(view: View) {
        //Log.e(TAG,"asd ben kemal")
        val intent2 = Intent(this, Register::class.java)
        startActivity(intent2)
    }
}
