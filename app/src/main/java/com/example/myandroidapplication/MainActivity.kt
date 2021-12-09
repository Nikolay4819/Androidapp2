package com.example.myandroidapplication





import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM="item"


class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener(){ item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.gallery -> {
                    fragment = BlankFragment()
                }
                R.id.about -> {
                    fragment = About()
                }
            }
            replaceFragment(fragment!!)
            true
        }

        bottomNavigationView.selectedItemId = if (savedInstanceState!=null) savedInstanceState.getInt(
            LAST_SELECTED_ITEM) else R.id.gallery

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationView.selectedItemId)
        val currentFragment= supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(outState, currentFragment.javaClass.name, currentFragment)
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}




