package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var drawer: DrawerLayout? = null
    private var toolbar: Toolbar?=null
    private var navigation: NavigationView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email = intent.getStringExtra("email")

        cntView()
        setSupportActionBar(toolbar!!)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()
        navItemsClicks()
        updateEmailInHeader(email!!)
    }

    private fun cntView() {
        drawer = findViewById(R.id.drawerView)
        toolbar = findViewById(R.id.toolBarView)
        navigation = findViewById(R.id.navView)

    }
    private fun updateEmailInHeader(eamil:String){
        val headerView = navigation?.getHeaderView(0)
        val textHeaderView = headerView?.findViewById<TextView>(R.id.viewEmail)
        textHeaderView?.text = eamil
    }

    private fun setupDrawer(){
        val toggleDrawer: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer!!,R.string.open,R.string.close)
        drawer?.addDrawerListener(toggleDrawer)
        toggleDrawer.syncState()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                drawer?.openDrawer(GravityCompat.START)
                true
            }else -> true
        }
    }
    private fun navItemsClicks(){
        navigation?.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    Toast.makeText(this,"Home Screen", Toast.LENGTH_SHORT).show()
                    drawer?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {
                    val i = Intent(this, LoginActivity::class.java)
                    startActivity(i)
//                    Toast.makeText(this,"Logged Out", Toast.LENGTH_SHORT).show()
//                    drawer?.closeDrawer(GravityCompat.START)
                    true
                }else -> true
            }
        }

    }
}