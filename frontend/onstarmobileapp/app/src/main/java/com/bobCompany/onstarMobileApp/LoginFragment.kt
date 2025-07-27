package com.bobCompany.onstarMobileApp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // fragment_login.xml을 inflate해서 반환
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //버튼 찾기
        val loginButton = view.findViewById<Button>(R.id.loginBtn)

        loginButton.setOnClickListener{
            val intent = Intent(requireContext(),HomeActivity::class.java)
            startActivity(intent)
        }
    }
}