 package com.example.myappkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myappkotlin.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import androidx.appcompat.widget.Toolbar

 class MainMenu : AppCompatActivity() {
     private val TAG = "MyActivity"
    private lateinit var user :FirebaseAuth

     override fun onCreate(savedInstanceState: Bundle?) {



         super.onCreate(savedInstanceState)
         enableEdgeToEdge()
         setContentView(R.layout.main_menu)

         val gameButton = findViewById<Button>(R.id.game_button)
         val educationButton = findViewById<Button>(R.id.education_button)

         //val toolbar =findViewById<Toolbar>(R.id.toolbar)
         //setSupportActionBar(toolbar)


        gameButton.setOnClickListener(){
             // Open game activity
             startActivity(Intent(this, MainMenu::class.java))
         }

         educationButton.setOnClickListener {
             // Open education activity
             startActivity(Intent(this, MainMenu::class.java))
         }
         user = FirebaseAuth.getInstance()
     }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         return super.onCreateOptionsMenu(menu)
         
     }
     /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.menu_menu, menu)
         return true
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         when (item.itemId) {
             R.id.action_logout -> {
                 // Handle logout
                 // For example, sign out user and navigate to login screen
                 // Replace the code below with your logout implementation
                 FirebaseAuth.getInstance().signOut()
                 startActivity(Intent(this, Login::class.java))
                 finish() // Close current activity
                 return true
             }
         }
         return super.onOptionsItemSelected(item)
     }*/

     fun onTextClicked(view: View) {
         Log.e(TAG,"asd ciktik")

         user.signOut()
         val intent1 = Intent(this, Login::class.java)
         startActivity(intent1)

         finish()


     }
 }
