package vegh.aviv.alliesapp.sequences.explore

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_explore.view.*
import vegh.aviv.alliesapp.R

/**
 * Created by avivvegh on 19/05/2017.
 */
class ExploreFragment : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater!!.inflate(R.layout.fragment_explore, container, false)

        initViews(view)

        return view
    }

    private fun initViews(view: View)
    {
        view.usersRecyclerView.layoutManager = GridLayoutManager(activity,3) as RecyclerView.LayoutManager?

    }
}