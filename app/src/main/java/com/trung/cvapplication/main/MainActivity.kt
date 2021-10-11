package com.trung.cvapplication.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.trung.cvapplication.R
import com.trung.cvapplication.aboutme.AboutMeFragment
import com.trung.cvapplication.contact.ContactFragment
import com.trung.cvapplication.home.HomeFragment
import com.trung.cvapplication.work.WorkFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_contact.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setCurrentFragment(HomeFragment.newInstance())
        setListener()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_menu_facebook -> {
                openImplicitIntent(getString(R.string.facebook_package), getString(R.string.facebook_name))
                true
            }
            R.id.option_menu_instagram -> {
                openImplicitIntent(getString(R.string.instagram_package), getString(R.string.instagram_name))
                true
            }
            R.id.option_menu_linkedin -> {
                openImplicitIntent(getString(R.string.linkedin_package), getString(R.string.linkedin_name))
                true
            }
            R.id.option_menu_skype -> {
                openImplicitIntent(getString(R.string.skype_package), getString(R.string.skype_name))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun setListener() {
        bnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> setCurrentFragment(HomeFragment.newInstance())
                R.id.menu_about_me -> setCurrentFragment(AboutMeFragment.newInstance())
                R.id.menu_work -> setCurrentFragment(WorkFragment.newInstance())
                R.id.menu_contact -> setCurrentFragment(ContactFragment.newInstance())
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer,fragment)
            commit()
        }
    }

    private fun openImplicitIntent(appPackage: String, appName: String) {
        val implicitIntent = packageManager.getLaunchIntentForPackage(appPackage)
        if(implicitIntent!=null)
            startActivity(implicitIntent)
        else
            Toast.makeText(applicationContext,"$appName is not installed",Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View?) {
        view?.let {
            when(view.id) {
                R.id.btnFacebook -> {
                    openImplicitIntent(getString(R.string.facebook_package), getString(R.string.facebook_name))
                }
                R.id.btn_skype -> {
                    openImplicitIntent(getString(R.string.skype_package), getString(R.string.skype_name))
                }
                R.id.btn_instagram -> {
                    openImplicitIntent(getString(R.string.instagram_package), getString(R.string.instagram_name))
                }

            }
        }
    }
}