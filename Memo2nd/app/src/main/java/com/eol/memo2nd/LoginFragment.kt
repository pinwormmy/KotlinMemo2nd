package com.eol.memo2nd

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.eol.memo2nd.databinding.LoginFragmentBinding
import com.eol.memo2nd.databinding.WatchListFragmentBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    lateinit var binding: LoginFragmentBinding

    lateinit var auth: FirebaseAuth

    // 1. Context를 할당할 변수를 프로퍼티로 선언(어디서든 사용할 수 있게)
    private lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = LoginFragmentBinding.inflate(inflater, container, false)

        auth = FirebaseAuth.getInstance()

        binding.buttonLogin.setOnClickListener {
            var email = binding.emailEt.text.toString()
            var password = binding.pwdEt.text.toString()

            auth.createUserWithEmailAndPassword(email,password) // 회원 가입
                .addOnCompleteListener {
                        result ->
                    if(result.isSuccessful){
                        Toast.makeText(mainActivity,"없는 이멜, 비번이라 그냥 이걸로 회원가입해드렸습니다.",Toast.LENGTH_SHORT).show()
                        if(auth.currentUser!=null){
                            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.mainFrame, MyPageFragment())?.commit()
                        }
                    }
                    else if(result.exception?.message.isNullOrEmpty()){
                        Toast.makeText(mainActivity,"입력 오류~~~~~~~~~~~~~",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        login(email, password)
                    }
                }
        }

        return binding.root
    }

    private fun login(email:String, password:String){
        auth.signInWithEmailAndPassword(email,password) // 로그인
            .addOnCompleteListener {
                    result->
                if(result.isSuccessful){
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.mainFrame, MyPageFragment())?.commit()
                }
            }
    }
}