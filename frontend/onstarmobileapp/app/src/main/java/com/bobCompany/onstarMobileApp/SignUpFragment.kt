package com.bobCompany.onstarMobileApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.core.widget.doAfterTextChanged
import com.bobCompany.onstarMobileApp.databinding.FragmentSignup01Binding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignup01Binding? = null
    private val binding get() = _binding!!

    private var idHasFocus = false
    private var pwHasFocus = false
    private var pwCheckHasFocus = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignup01Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val idInput = binding.idfield
        val pwInput = binding.passwordfield
        val pwCheckInput = binding.repasswordfield

        val idError = binding.errorId
        val pwError = binding.errorPwd
        val pwCheckError = binding.errorPwCheck

        val nextBtn = binding.nextBtn

        // ✅ 포커스 상태 추적 + 포커스 빠지면 에러 숨김
        idInput.setOnFocusChangeListener { _, hasFocus ->
            idHasFocus = hasFocus
        }
        pwInput.setOnFocusChangeListener { _, hasFocus ->
            pwHasFocus = hasFocus
        }
        pwCheckInput.setOnFocusChangeListener { _, hasFocus ->
            pwCheckHasFocus = hasFocus
        }

        // ✅ 실시간 검사 + 포커스 있을 때만 에러 표시
        idInput.doAfterTextChanged {
            val id = idInput.text.toString()
            if (id.length in 5 until 16) {
                idError.visibility = View.GONE
            } else if (idHasFocus) {
                idError.text = "아이디는 5~15자여야 합니다"
                idError.visibility = View.VISIBLE
            }
            updateButtonVisibility()
        }

        pwInput.doAfterTextChanged {
            val pw = pwInput.text.toString()
            val pwRegex = Regex("^(?=.*[!@#\$%^&*(),.?\":{}|<>]).{8,15}\$")

            if (pwRegex.matches(pw)) {
                pwError.visibility = View.GONE
            } else if (pwHasFocus) {
                pwError.text = "비밀번호는 8~15자 이상, 특수문자 포함"
                pwError.visibility = View.VISIBLE
            }
            updateButtonVisibility()
        }

        pwCheckInput.doAfterTextChanged {
            val pw = pwInput.text.toString()
            val pwCheck = pwCheckInput.text.toString()

            if (pw == pwCheck && pwCheck.isNotEmpty()) {
                pwCheckError.visibility = View.GONE
            } else if (pwCheckHasFocus) {
                pwCheckError.text = "비밀번호가 일치하지 않습니다"
                pwCheckError.visibility = View.VISIBLE
            }
            updateButtonVisibility()
        }

        // ✅ 버튼 클릭 시 전체 검증
        nextBtn.setOnClickListener {
            if (validateAll()) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout8, SignUpFragment02())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    private fun updateButtonVisibility() {
        val idOk = binding.idfield.text.toString().length in 5 until 16
        val pwOk = Regex("^(?=.*[!@#\$%^&*(),.?\":{}|<>]).{8,15}\$")
            .matches(binding.passwordfield.text.toString())
        val pwCheckOk = binding.passwordfield.text.toString() ==
                binding.repasswordfield.text.toString() &&
                binding.repasswordfield.text.isNotEmpty()

        if (idOk && pwOk && pwCheckOk) {
            // 모든 조건 만족 시 에러 숨기고 버튼 보이기
            binding.errorId.visibility = View.GONE
            binding.errorPwd.visibility = View.GONE
            binding.errorPwCheck.visibility = View.GONE
            binding.nextBtn.visibility = View.VISIBLE
        } else {
            binding.nextBtn.visibility = View.GONE
        }
    }

    private fun validateAll(): Boolean {
        var isValid = true
        val id = binding.idfield.text.toString()
        val pw = binding.passwordfield.text.toString()
        val pwCheck = binding.repasswordfield.text.toString()

        if (id.length in 5 until 16) {
            binding.errorId.visibility = View.GONE
        } else {
            binding.errorId.text = "아이디는 5~15자여야 합니다"
            binding.errorId.visibility = View.VISIBLE
            isValid = false
        }

        val pwRegex = Regex("^(?=.*[!@#\$%^&*(),.?\":{}|<>]).{8,15}\$")

        if (pwRegex.matches(pw)) {
            binding.errorPwd.visibility = View.GONE
        } else {
            binding.errorPwd.text = "비밀번호는 8~15자 이상, 특수문자 포함"
            binding.errorPwd.visibility = View.VISIBLE
            isValid = false
        }

        if (pw == pwCheck && pwCheck.isNotEmpty()) {
            binding.errorPwCheck.visibility = View.GONE
        } else {
            binding.errorPwCheck.text = "비밀번호가 일치하지 않습니다"
            binding.errorPwCheck.visibility = View.VISIBLE
            isValid = false
        }

        return isValid
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
