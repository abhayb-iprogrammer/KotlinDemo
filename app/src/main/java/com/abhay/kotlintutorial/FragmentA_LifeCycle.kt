package com.abhay.kotlintutorial

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.jetbrains.annotations.Nullable


class FragmentA_LifeCycle : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_fragment_a__life_cycle, container, false)
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Toast.makeText(activity, "onAttach in Fragment was Called", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(activity, "onCreate in Fragment was Called", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Toast.makeText(activity, "onActivityCreated in Fragment was Called", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(activity, "onStart in Fragment was Called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(activity, "onResume in Fragment was Called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(activity, "onPause in Fragment was Called", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Toast.makeText(activity, "onSaveInstanceState in Fragment was Called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(activity, "onStop in Fragment was Called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(activity, "onDestroyView in Fragment was Called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(activity, "onDestroy in Fragment was Called", Toast.LENGTH_SHORT).show()
    }

    override fun onDetach() {
        super.onDetach()
        Toast.makeText(activity, "onDetach in Fragment was Called", Toast.LENGTH_SHORT).show()
    }


}// Required empty public constructor
