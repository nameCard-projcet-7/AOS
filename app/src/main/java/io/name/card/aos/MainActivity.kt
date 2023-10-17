package io.name.card.aos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.name.card.aos.Making.nameCard_Making
import io.name.card.aos.Management.nameCard_Management
import io.name.card.aos.Scan.nameCard_Scan

class MainActivity : AppCompatActivity() {

    private val namecardScan = nameCard_Scan()
    private val namecardManagement = nameCard_Management()
    private val namecardMaking = nameCard_Making()

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