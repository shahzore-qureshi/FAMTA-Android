package com.shahzorequreshi.famta.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.shahzorequreshi.famta.R
import com.shahzorequreshi.famta.objects.Subway.SubwayLine

/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class SubwayLineFragment : Fragment() {
    private var mListener: OnSubwayLineFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_subway_line, container, false)

        view.findViewById<LinearLayout>(R.id.subway_line_blue).setOnClickListener {
            mListener?.onSubwayLineFragmentInteraction(SubwayLine("blue", arrayOf("A", "C", "E")))
        }

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnSubwayLineFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFeedFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnSubwayLineFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onSubwayLineFragmentInteraction(item: SubwayLine)
    }

    companion object {
        @Volatile private var INSTANCE: SubwayLineFragment? = null

        fun getInstance(): SubwayLineFragment =
            INSTANCE ?: synchronized(this) {
                    INSTANCE ?: SubwayLineFragment().also { INSTANCE = it }
            }
    }
}
