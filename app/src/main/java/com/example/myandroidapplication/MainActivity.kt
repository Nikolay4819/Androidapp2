package com.example.myandroidapplication





import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private lateinit var switchFragmentsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchFragmentsButton = findViewById(R.id.switch_fragments_button)

        val startFragment = BlankFragment()
        val endFragment = EndFragment()

        switchFragmentsButton.setOnClickListener {
            val fragment =
                when (supportFragmentManager.findFragmentById(R.id.fragment_container)) {
                    is BlankFragment -> endFragment
                    is EndFragment -> startFragment
                    else -> startFragment
                }

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }
}





