package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    private var user:EditText? = null
    private var pass:EditText? = null
    private var btnLog:Button? = null
    private var forgot:TextView?=null
    private var chAccept:CheckBox?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        connectViews()
        login()
        forget()
    }

    private fun connectViews() {
        user = findViewById(R.id.etUsername)
        pass = findViewById(R.id.etPass)
        btnLog = findViewById(R.id.btnLogin)
        forgot = findViewById(R.id.tvForgot)
        chAccept = findViewById(R.id.checkAccept)
    }
    private fun login(){
        btnLog?.setOnClickListener {
            val i = Intent(this, LibraryActivity::class.java)
            startActivity(i)
        }
    }
    private fun forget(){
        forgot?.setOnClickListener {

        }
    }



}