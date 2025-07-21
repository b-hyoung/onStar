package com.bobCompany.onstarMobileApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // fragment_login.xml을 inflate해서 반환
        return inflater.inflate(R.layout.fragment_signup_03, container, false)
    }
}