package com.example.todotracker.ui.queue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.todotracker.R

class OverdueFragment : Fragment() {

    private lateinit var queueViewModel: OverdueViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        queueViewModel =
                ViewModelProvider(this).get(OverdueViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_queue, container, false)
//        val textView: TextView = root.findViewById(R.id.text)
//        queueViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}