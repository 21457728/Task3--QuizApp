package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{
         val createUserWithEmailAndPassword =
             Firebase.auth.createUserWithEmailAndPassword(binding.email.editableText.toString(),
             binding.password.editableText.toString()).addOnCompleteListener{

                 if (it.isSuccessful){
                     Toast.makeText(this,"User created " , Toast.LENGTH_LONG).show()
                     val intent = Intent(this,quizActivity::class.java)
                     startActivity(intent);
                 } else{
                     Toast.makeText(this,"User  not created " , Toast.LENGTH_LONG).show()
                 }

             }


        }

         }
}