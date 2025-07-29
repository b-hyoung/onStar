package com.bobCompany.onstarMobileApp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bobCompany.onstarMobileApp.databinding.FragmentSignup03Binding  // ✅ 수정된 바인딩 클래스


class SignUpFragment03 : Fragment() {

    private var _binding: FragmentSignup03Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSignup03Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = arguments?.getString("email") ?: ""

        binding.CheckedEmailId.text="${email}\n 해당 이메일로 인증번호를 발송했습니다."

        setupEditTextAutoMove() // ✅ 꼭 호출
        binding.finishBtn.setOnClickListener {
            startActivity(Intent(requireContext(), HomeActivity::class.java))
        }
    }



    //한글자 포커스 이동
    private fun setupEditTextAutoMove() {
        val editTexts = listOf(
            binding.textView4,
            binding.textView5,
            binding.textView6,
            binding.textView10,
            binding.textView11
        )

        for (i in editTexts.indices) {
            val current = editTexts[i]
            val next = editTexts.getOrNull(i + 1)
            
            //포커스 다음으로 이동
            current.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if (!s.isNullOrEmpty()) {
                        next?.requestFocus()
                    }
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })
            //이전포커스로 이동
            current.setOnKeyListener { _, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN && current.text.isEmpty()) {
                    val previous = editTexts.getOrNull(i - 1)
                    previous?.requestFocus()
                }
                false
            }
        }



    }
}