package vegh.aviv.alliesapp.sequences.profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vegh.aviv.alliesapp.R

/**
 * Created by avivvegh on 19/05/2017.
 */
class ProfileFragment : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater!!.inflate(R.layout.fragment_profile,container,false)

        return view
    }
}