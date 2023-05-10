package com.first.mascotapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.first.mascotapp.databinding.ActivityMainBinding
import com.first.mascotapp.databinding.ActivityRegisterBinding
import com.first.mascotapp.fragments.viewModels.UserViewModel
import com.first.mascotapp.models.User

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    val viewModel : UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE) // will hide the title
        supportActionBar?.hide() // hide the title bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        } // enable full screen
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val createAccount: Button = binding.btnCreateAccount
        createAccount.setOnClickListener {
        val userName = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()



            //TODO Validar todo

            val user = User(userName,email,password)
            viewModel.createUser(this,user,{
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            },{
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
            })







        }
    }
}