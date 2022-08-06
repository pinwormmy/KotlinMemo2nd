package com.eol.memo2nd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eol.memo2nd.databinding.CameraFragmentBinding


class CameraFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var binding = CameraFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

}