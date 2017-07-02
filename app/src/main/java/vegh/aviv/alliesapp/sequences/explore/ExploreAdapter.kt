package vegh.aviv.alliesapp.sequences.explore

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vegh.aviv.alliesapp.R

/**
 * Created by avivvegh on 19/05/2017.
 */
class ExploreAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder
    {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_user, parent, false) as UserViewHolder
        return v
    }

    override fun getItemCount(): Int
    {
        return 0
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindViews()
        {

        }
    }
}