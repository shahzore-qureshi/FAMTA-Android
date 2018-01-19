package com.shahzorequreshi.famta.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.shahzorequreshi.famta.R
import android.support.v7.widget.DividerItemDecoration
import com.shahzorequreshi.famta.fragments.adapters.SubwayBoundRecyclerViewAdapter
import com.shahzorequreshi.famta.database.objects.SubwayStation
import com.shahzorequreshi.famta.database.objects.SubwayBound

/**
 * A fragment representing subway bound information.
 *
 */
class SubwayBoundFragment : Fragment() {
    private var mSubwayBound: SubwayBound? = null
    private var mListener: OnSubwayBoundFragmentInteractionListener? = null

    companion object {
        private val ARG_SUBWAY_BOUND = "subway-bound"

        fun newInstance(subwayBound: SubwayBound): SubwayBoundFragment {
            val fragment = SubwayBoundFragment()
            val args = Bundle()
            args.putSerializable(ARG_SUBWAY_BOUND, subwayBound)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mSubwayBound = arguments[ARG_SUBWAY_BOUND] as SubwayBound
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_subway_service, container, false)
        if (view is RecyclerView) {
            val context = view.getContext()
            view.layoutManager = LinearLayoutManager(context)
            //view.adapter = SubwayBoundRecyclerViewAdapter(mSubwayBound!!.stations, mListener, activity)
            view.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnSubwayBoundFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnSubwayBoundFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnSubwayBoundFragmentInteractionListener {
        fun onSubwayBoundFragmentInteraction(item: SubwayStation)
    }
}