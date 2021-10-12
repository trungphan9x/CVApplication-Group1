package com.trung.cvapplication.contact

import android.content.Intent
import android.content.Intent.*
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import com.trung.cvapplication.R
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        tvPhoneNo.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${tvPhoneNo.text.trim()}")
            })
        }

        tvEmail.setOnClickListener {
            val selectorIntent = Intent(ACTION_SENDTO)
                .setData("mailto:${tvEmail.text}".toUri())

            val emailIntent = Intent(ACTION_SEND).apply {
                putExtra(EXTRA_EMAIL, arrayOf(tvEmail.text))
                putExtra(EXTRA_SUBJECT, getString(R.string.email_subject))
                putExtra(EXTRA_TEXT, getString(R.string.email_content))
                selector = selectorIntent
            }
            startActivity(Intent.createChooser(emailIntent, "Choose APP to send email:"))
        }
    }

    companion object {
        fun newInstance() = ContactFragment()
    }
}