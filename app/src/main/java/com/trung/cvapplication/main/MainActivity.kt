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
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity(), View.OnClickListener{

    val fragmentHome: Fragment = HomeFragment()
    val fragmentAboutMe: Fragment = AboutMeFragment()
    val fragmentWork: Fragment = WorkFragment()
    val fragmentContact: Fragment = ContactFragment()
    val fm: FragmentManager = supportFragmentManager
    var active = fragmentHome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeFragments()
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

    private fun initializeFragments() {
        fm.beginTransaction().add(R.id.fragmentContainer, fragmentContact, "contact").hide(fragmentContact).commit()
        fm.beginTransaction().add(R.id.fragmentContainer, fragmentWork, "work").hide(fragmentWork).commit()
        fm.beginTransaction().add(R.id.fragmentContainer, fragmentAboutMe, "aboutme").hide(fragmentAboutMe).commit()
        fm.beginTransaction().add(R.id.fragmentContainer,fragmentHome, "home").commit();
    }

    private fun setListener() {
        bnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    fm.beginTransaction().hide(active).show(fragmentHome).commit()
                    active = fragmentHome
                    return@setOnItemSelectedListener true
                }
                R.id.menu_about_me -> {
                    fm.beginTransaction().hide(active).show(fragmentAboutMe).commit()
                    active = fragmentAboutMe
                    return@setOnItemSelectedListener true
                }
                R.id.menu_work -> {
                    fm.beginTransaction().hide(active).show(fragmentWork).commit()
                    active = fragmentWork
                    return@setOnItemSelectedListener true
                }
                R.id.menu_contact -> {
                    fm.beginTransaction().hide(active).show(fragmentContact).commit()
                    active = fragmentContact
                    return@setOnItemSelectedListener true
                }
            }
            return@setOnItemSelectedListener false
        }

        bnv.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    fm.beginTransaction().detach(fragmentHome).commit()
                    fm.beginTransaction().attach(fragmentHome).commit()
                }
                R.id.menu_about_me -> {
                    fm.beginTransaction().detach(fragmentAboutMe).commit()
                    fm.beginTransaction().attach(fragmentAboutMe).commit()
                }
                R.id.menu_work -> {
                    fm.beginTransaction().detach(fragmentWork).commit()
                    fm.beginTransaction().attach(fragmentWork).commit()
                }
                R.id.menu_contact -> {
                    fm.beginTransaction().detach(fragmentContact).commit()
                    fm.beginTransaction().attach(fragmentContact).commit()
                }
            }
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