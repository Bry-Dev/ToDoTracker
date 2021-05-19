package com.example.todotracker.ui.completed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.todotracker.R

class CompletedFragment : Fragment() {

    private lateinit var completedViewModel: CompletedViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        completedViewModel =
                ViewModelProvider(this).get(CompletedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_completed, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        completedViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}