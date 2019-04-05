package home.learn.hmt.learnandroid.ui.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.ui.screen.home.HomeFragment
import home.learn.hmt.learnandroid.ui.screen.search.SearchArtistFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            /*supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance(), HomeFragment.TAG)
                .commit()*/

            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchArtistFragment.newInstance(), SearchArtistFragment.TAG)
                .commit()
        }
    }
}
