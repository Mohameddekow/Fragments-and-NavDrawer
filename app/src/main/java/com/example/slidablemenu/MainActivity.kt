package com.example.slidablemenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        displayFragment(-1)

        navView.setNavigationItemSelectedListener {
           displayFragment(it.itemId)
        }
    }
    private fun displayFragment(id: Int): Boolean{

        val fragment =  when(id){

                        R.id.homes -> {
                            HomeFragment()
                        }

                        R.id.contact -> {
                            ContactFragment()
                        }

                        R.id.help -> {
                            HelpFragment()
                        }

                        R.id.setting -> {
                            SettingFragment()
                        }
                        else -> {
                            HomeFragment()
                        }
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.myFrameLayout, fragment)
            commit()
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
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