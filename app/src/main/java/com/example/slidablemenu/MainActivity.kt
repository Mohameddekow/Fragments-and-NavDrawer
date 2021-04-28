package com.example.slidablemenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homes -> {
                    Toast.makeText(applicationContext, "you clicked "+ it.title, Toast.LENGTH_SHORT).show()
                }

                R.id.setting -> {
                    Toast.makeText(applicationContext, "you clicked "+ it.title, Toast.LENGTH_SHORT).show()
                }

                R.id.contact -> {
                    Toast.makeText(applicationContext, "you clicked "+ it.title, Toast.LENGTH_SHORT).show()
                }

                R.id.help -> {
                    Toast.makeText(applicationContext, "you clicked "+ it.title, Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}