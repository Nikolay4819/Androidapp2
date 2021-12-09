package com.example.myandroidapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

private const val LAST_ROLLED_IMAGE="image"

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var diceImageView: ImageView
    lateinit var rollButton: Button

    private val diceImageList= listOf<Int>(
      R.drawable.logo,
      R.drawable.map,
      R.drawable.tech
        )




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_blank, container, false)
        // Inflate the layout for this fragment
        diceImageView = view.findViewById(R.id.dice_image_view)
        rollButton = view.findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            var resourceId : Int
            when (diceImageView.tag) {
                R.drawable.logo -> resourceId = R.drawable.tech
                R.drawable.tech -> resourceId = R.drawable.map
                R.drawable.map -> resourceId = R.drawable.logo
                else -> resourceId = R.drawable.tech

            }

            val lastRolledImageRes="0"

            diceImageView.setImageResource(resourceId)
            diceImageView.tag=resourceId
        }

        return view

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ROLLED_IMAGE, diceImageList.random())

}}