package home.learn.hmt.learnandroid.ui.screen.home

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.ui.screen.topRate.TopRateFragment

class BottomActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom)
        /*supportFragmentManager.beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance(), HomeFragment.TAG)
                    .commit()*/

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TopRateFragment.newInstance(), TopRateFragment.TAG)
            .commit()
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
