package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

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
        //forget()
    }

    private fun connectViews() {
        user = findViewById(R.id.etUsername)
        pass = findViewById(R.id.etPass)
        btnLog = findViewById(R.id.btnLogin)
        forgot = findViewById(R.id.tvForgot)
        chAccept = findViewById(R.id.checkAccept)
    }
    private fun login(){
        val arr:ArrayList<User> = ArrayList()
        arr.add(User("test@test.com", "123"))
        arr.add(User("t@t.com", "1234"))
        arr.add(User("b@test.com", "12345"))

        btnLog?.setOnClickListener {
            val username = user?.text.toString()
            val password = pass?.text.toString()

            val user = User(username,password)

            for (userArray in arr){
                if(userArray.email == user.email
                    && userArray.password == user.password){
                  //  Toast.makeText(this, "Welcome ${user.email}", Toast.LENGTH_SHORT).show()
                      val i = Intent(this, MainActivity::class.java)
                        i.putExtra("email", userArray.email)
                        startActivity(i)
                        break
                }else{
                    Toast.makeText(this, "check your data", Toast.LENGTH_SHORT).show()
                }
            }

//            if(user?.text?.isEmpty() == true
//                || pass?.text?.isEmpty()== true
//                ||chAccept?.isChecked != true){
//                Toast.makeText(this, "Enter your data", Toast.LENGTH_SHORT).show()
//            }
//            val i = Intent(this, LibraryActivity::class.java)
//            startActivity(i)
        }
    }
    private fun forget(){
        forgot?.setOnClickListener {

        }
    }



}