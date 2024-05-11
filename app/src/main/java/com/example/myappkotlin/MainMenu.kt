 package com.example.myappkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

 class MainMenu : AppCompatActivity() {
     private val TAG = "MyActivity"
    private lateinit var user :FirebaseAuth
     override fun onCreate(savedInstanceState: Bundle?) {



         super.onCreate(savedInstanceState)
         enableEdgeToEdge()
         setContentView(R.layout.main_menu)

         user = FirebaseAuth.getInstance()
     }

     fun onTextClicked(view: View) {
         Log.e(TAG,"asd ciktik")

         user.signOut()
         val intent1 = Intent(this, Login::class.java)
         startActivity(intent1)

         finish()


     }
 }
