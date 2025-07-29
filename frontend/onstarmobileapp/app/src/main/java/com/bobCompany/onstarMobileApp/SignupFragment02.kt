package com.bobCompany.onstarMobileApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.bobCompany.onstarMobileApp.databinding.FragmentSignup02Binding


class SignUpFragment02 : Fragment() {

    private var _binding: FragmentSignup02Binding? = null
    private val binding get() = _binding!!

    private var isValild = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding =  FragmentSignup02Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val emailInput = binding.emailInputFiled

        emailInput.doAfterTextChanged {
            val emailText = emailInput.text.toString()
            val emailRegex = Regex("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")

            if (emailRegex.matches(emailText)) {
                binding.errorEmail.visibility = View.GONE
                binding.btnNext.visibility = View.VISIBLE
            } else {
                binding.errorEmail.text = "올바른 이메일 형식이 아닙니다."
                binding.errorEmail.visibility = View.VISIBLE
                binding.btnNext.visibility = View.GONE
            }
        }

        view.findViewById<Button>(R.id.btn_next).setOnClickListener {
            val currentEmail = binding.emailInputFiled.text.toString()

            val bundle = Bundle().apply {
                putString("email", currentEmail)  // ✅ 최신 값 전달
            }

            val nextFragment = SignUpFragment03().apply {
                arguments = bundle
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout8, nextFragment)
                .addToBackStack(null)
                .commit()
        }
// 이전 단계로 되돌리기
//        view.findViewById<Button>(R.id.btn_back).setOnClickListener {
//            parentFragmentManager.popBackStack()
//        }
    }
}