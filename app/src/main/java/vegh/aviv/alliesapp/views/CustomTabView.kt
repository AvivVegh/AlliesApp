package vegh.aviv.alliesapp.views

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_cutstom_tab.view.*
import vegh.aviv.alliesapp.R

/**
 * Created by avivvegh on 19/05/2017.
 */
class CustomTabView(context: Context, @DrawableRes imageResource: Int, @StringRes text : Int) : RelativeLayout(context)
{
    init
    {
        View.inflate(context, R.layout.view_cutstom_tab, this)
//        this.tabTextView.setText(text)
        this.tabImageView.setImageResource(imageResource)
    }
}