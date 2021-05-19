package com.example.todotracker.ui.ongoing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.todotracker.R

class OngoingFragment : Fragment() {

    private lateinit var ongoingViewModel: OngoingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        ongoingViewModel =
                ViewModelProvider(this).get(OngoingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ongoing, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        ongoingViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}