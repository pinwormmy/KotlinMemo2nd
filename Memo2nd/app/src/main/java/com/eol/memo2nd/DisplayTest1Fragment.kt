package com.eol.memo2nd

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.ActivityMainBinding
import com.eol.memo2nd.databinding.Test1Binding
import com.eol.memo2nd.databinding.WatchListFragmentBinding

class DisplayTest1Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val bindingPretty = Test1Binding.inflate(inflater, container, false)

        return bindingPretty.root
    }

}