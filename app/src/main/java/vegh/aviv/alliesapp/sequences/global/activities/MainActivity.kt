package vegh.aviv.alliesapp.sequences.global.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.content_main.*
import vegh.aviv.alliesapp.R
import vegh.aviv.alliesapp.globals.managers.TestManager
import vegh.aviv.alliesapp.sequences.global.adapters.MainPagerAdapter
import vegh.aviv.alliesapp.views.CustomTabView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        initViews()
    }

    private fun initViews()
    {
        TestManager.foo2()
        mainViewPager.adapter = MainPagerAdapter(supportFragmentManager)
        mainTabLayout.setupWithViewPager(mainViewPager)

        mainTabLayout.getTabAt(0)!!.customView = CustomTabView(this, R.drawable.home_selector,0)
        mainTabLayout.getTabAt(1)!!.customView = CustomTabView(this, R.drawable.message_selector, 0)
        mainTabLayout.getTabAt(2)!!.customView = CustomTabView(this, R.drawable.profile_selector, 0)
    }
}
