package com.example.android_retrofit_sqlite.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.android_retrofit_sqlite.R
import com.example.android_retrofit_sqlite.ViewPagerAdapter
import com.example.android_retrofit_sqlite.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    val tabssArray = arrayOf(
        "Hoje",
        "Timer"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupDrawer()
        setupTabLayout()
    }

    private fun setupDrawer(){
        val draweLayout : DrawerLayout = binding.drawerLayout
        val navView : NavigationView = binding.navView

        toggle = ActionBarDrawerToggle(this,draweLayout, R.string.open, R.string.close)
        draweLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.nav_gym -> Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show()
                R.id.nav_auto_training -> Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    private fun setupTabLayout() {
        val viewPager = binding.appBarMain.viewpager
        val tabLayout = binding.appBarMain.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabssArray[position]
        }.attach()
    }
}