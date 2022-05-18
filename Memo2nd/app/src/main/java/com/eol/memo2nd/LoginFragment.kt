package com.eol.memo2nd

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.eol.memo2nd.databinding.LoginFragmentBinding
import com.eol.memo2nd.databinding.WatchListFragmentBinding
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginFragment : Fragment() {

    lateinit var binding: LoginFragmentBinding
    lateinit var auth: FirebaseAuth
    private val RC_SIGN_IN = 8922

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

        // 구글로그인
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("191086478531-7oavs5lk84n3os5t315do8ha0k8fpup6.apps.googleusercontent.com")
            .requestEmail()
            .build()

        var googleSignInClient = GoogleSignIn.getClient(mainActivity, gso)

        binding.buttonGoogleLogin.setOnClickListener{
            val signInIntent = googleSignInClient.signInIntent

            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try{
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            }catch (e: ApiException){
                Toast.makeText(mainActivity,"접속 실패. 구글 계정 연동확인",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(mainActivity){ task ->
                if(task.isSuccessful){
                    val user = auth.currentUser
                    Log.d("구글로그인 성공", user.toString())
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.mainFrame, MyPageFragment())?.commit()
                }else{
                    Log.d("구글로그인 실패", "signInWithCredential:failure", task.exception)
                }

            }
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