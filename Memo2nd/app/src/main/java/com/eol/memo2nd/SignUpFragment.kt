package com.eol.memo2nd

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.eol.memo2nd.databinding.LoginFragmentBinding
import com.eol.memo2nd.databinding.SignupFragmentBinding
import com.eol.memo2nd.databinding.WatchListFragmentBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : Fragment() {

    lateinit var binding: SignupFragmentBinding

    lateinit var auth: FirebaseAuth

    // 1. Context를 할당할 변수를 프로퍼티로 선언(어디서든 사용할 수 있게)
    private lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = SignupFragmentBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()

        binding.buttonSignUp.setOnClickListener {
            var email = binding.editEmail.text.toString()
            var password = binding.editPw.text.toString()
            var password2 = binding.editPw2.text.toString()

            if (password == password2) singUp(email, password)
            else Toast.makeText(mainActivity,"비밀번호 두 번 입력 똑같이 해주세요",Toast.LENGTH_LONG).show()
        }
        return binding.root
    }

    private fun singUp(email:String, password:String){
        auth.createUserWithEmailAndPassword(email,password) // 회원 가입
            .addOnCompleteListener {
                    result ->
                if(result.isSuccessful){
                    Toast.makeText(mainActivity,"회원가입 완료! 환영합니다~~~",Toast.LENGTH_LONG).show()
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.mainFrame, MyPageFragment())?.commit()
                }
                else{
                    Toast.makeText(mainActivity,"회원가입 입력 오류~~~~이메일과 비밀번호 확인해주세요",Toast.LENGTH_LONG).show()
                }
            }
    }
}