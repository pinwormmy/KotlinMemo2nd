package com.eol.memo2nd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.eol.memo2nd.databinding.MypageFragmentBinding
import com.google.firebase.auth.FirebaseAuth

class MyPageFragment : Fragment() {

    lateinit var binding: MypageFragmentBinding
    lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = MypageFragmentBinding.inflate(inflater, container, false)

        auth = FirebaseAuth.getInstance()

        if(auth.currentUser == null){
            binding.buttonLogin.visibility = View.VISIBLE
            binding.buttonLogout.visibility = View.INVISIBLE
            binding.memberView.text = "로그인할 수도 있쥐"
        }
        else{
            binding.buttonLogin.visibility = View.INVISIBLE
            binding.buttonLogout.visibility = View.VISIBLE
            binding.memberView.text = auth.currentUser?.email + ":: Logging in~!"
        }

        binding.buttonLogout.setOnClickListener {
            Toast.makeText(context,"로그아웃하셨습니다.", Toast.LENGTH_LONG).show()
            auth.signOut()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.mainFrame, DisplayTest1Fragment())?.commit()
        }

        binding.buttonAddWatch.setOnClickListener {
            if(auth.currentUser == null)
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.mainFrame, LoginFragment())?.commit()
            else
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.mainFrame, AddWatchFragment())?.commit()
        }
        return binding.root
    }
}