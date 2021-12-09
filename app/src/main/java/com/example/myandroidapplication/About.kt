package com.example.myandroidapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class About : Fragment () {
    lateinit var developersRecycleView: RecyclerView
    lateinit var followOurWebsiteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        var developersNames:List<String> = listOf( "Nikolay Konarev", "Antonio" )

        developersRecycleView = view.findViewById(R.id.developers_recycler_view)

        developersRecycleView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        developersRecycleView.adapter = DeveloperAdapter(developersNames)

        followOurWebsiteButton = view.findViewById(R.id.welcome_button)
        followOurWebsiteButton.setOnClickListener {
            val link = Uri.parse("https://torex-npvp.ru")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)
        }

        return view    }
}
