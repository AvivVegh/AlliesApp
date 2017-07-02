package vegh.aviv.alliesapp.sequences.global.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import vegh.aviv.alliesapp.sequences.explore.ExploreFragment
import vegh.aviv.alliesapp.sequences.messages.MessagesFragment
import vegh.aviv.alliesapp.sequences.profile.ProfileFragment

/**
 * Created by avivvegh on 19/05/2017.
 */
class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager)
{
    private val ITEMS_COUNT = 3

    override fun getItem(position: Int): Fragment
    {
        if (position == 0)
        {
            return ExploreFragment()
        }
        else if (position == 1)
        {
            return MessagesFragment()
        }
        else if (position == 2)
        {
            return ProfileFragment()
        }

        return Fragment()
    }

    override fun getCount(): Int
    {
        return ITEMS_COUNT
    }
}