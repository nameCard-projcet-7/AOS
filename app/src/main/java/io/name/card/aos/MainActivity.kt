package io.name.card.aos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.name.card.aos.Making.NameCard_Making
import io.name.card.aos.Management.NameCard_Management
import io.name.card.aos.Scan.NameCard_Scan

class MainActivity : AppCompatActivity() {

    private val namecardScan = NameCard_Scan()
    private val namecardManagement = NameCard_Management()
    private val namecardMaking = NameCard_Making()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.scan -> {
                    switchFragment(namecardScan)
                    true
                }

                R.id.management -> {
                    switchFragment(namecardManagement)
                    true
                }

                R.id.making -> {
                    switchFragment(namecardMaking)
                    true
                }

                else -> false
            }
        }
        switchFragment(namecardScan)
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}