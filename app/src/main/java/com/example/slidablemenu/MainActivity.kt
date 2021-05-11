package com.example.slidablemenu

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.slidablemenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        displayFragment(-1)

        binding.navView.setNavigationItemSelectedListener {
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
            replace(R.id.mainFrameLayout, fragment)
            commit()
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
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