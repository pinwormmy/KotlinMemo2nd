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
import com.google.android.gms.auth.api.identity.BeginSignInRequest
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
/*
클라이언트 아이디 찾아서 다시 수정
    val signInRequest = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                // Your server's client ID, not your Android client ID.
                .setServerClientId(getString(R.string.default_web_client_id))
                // Only show accounts previously used to sign in.
                .setFilterByAuthorizedAccounts(true)
                .build()
        )
        .build()
*/


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = LoginFragmentBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()



        binding.buttonLogin.setOnClickListener{
            var email = binding.emailEt.text.toString()
            var password = binding.pwdEt.text.toString()

            login(email, password)
        }
        binding.buttonSignUp.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.mainFrame, SignUpFragment())?.commit()
        }
        return binding.root
    }

    private fun login(email:String, password:String){
        auth.signInWithEmailAndPassword(email,password) // 로그인
            .addOnCompleteListener {
                    result->
                if(result.isSuccessful){
                    Toast.makeText(mainActivity,"접속 성공",Toast.LENGTH_LONG).show()
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.mainFrame, MyPageFragment())?.commit()
                }
                else{
                    Toast.makeText(mainActivity,"접속 실패. 이메일과 비밀번호를 확인해주세요",Toast.LENGTH_LONG).show()
                }
            }
    }

}