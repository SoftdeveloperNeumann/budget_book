package com.example.budgetbook


import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        toggle = ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close)

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()


        nav_view.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_buchen -> {

                    navController!!.navigate(R.id.action_mainActivity_to_buchenFragment)
                }
                R.id.nav_shopping -> {

                    navController!!.navigate(R.id.action_mainActivity_to_shoppingListFragment)
                }
                R.id.nav_fix -> {

                    navController!!.navigate(R.id.action_mainActivity_to_fixKostenFragment)
                }
                R.id.nav_auswertung -> {

                    navController!!.navigate(R.id.action_mainActivity_to_auswertungFragment)
                }
                R.id.nav_konten-> {

                    navController!!.navigate(R.id.action_mainActivity_to_kontonFragment)
                }
                R.id.nav_Help -> {

                    navController!!.navigate(R.id.action_mainActivity_to_helpFragment)
                }
                R.id.nav_settings -> {

                    navController!!.navigate(R.id.action_mainActivity_to_settingsFragment)
                }
                R.id.nav_exit -> {
                    finish()
//                    System.exit(0)
                }

            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }

    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)

        toggle.syncState()
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
