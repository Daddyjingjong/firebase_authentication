package com.example.quarantine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        signup_btn.setOnClickListener {
            perfomRegister()
        }

    }
    private fun perfomRegister(){
        val name = name_text.text.toString()
        val email = email_text.text.toString()
        val password = password_text.text.toString()

        if ( name.isEmpty() || email.isEmpty() && password.isEmpty()){
            Toast.makeText(this,"Please finish filling in the fields above", Toast.LENGTH_LONG).show()
            return
        }
        //Firebase authentication
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (!it.isSuccessful)return@addOnCompleteListener
                //else if successful
                Log.d("MainActivity","Successfully created user with uid:${it.result?.user?.uid}")
                Toast.makeText(this,"Hi $name, you have successfully logged in", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Log.d("MainActivity","Failed to create user:${it.message}")
                Toast.makeText(this,"Failed to create user:${it.message} ", Toast.LENGTH_LONG).show()
            }
    }
}
