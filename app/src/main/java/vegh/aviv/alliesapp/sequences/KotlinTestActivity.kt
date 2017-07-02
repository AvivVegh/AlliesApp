package vegh.aviv.alliesapp.sequences

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin_test.*
import vegh.aviv.alliesapp.R

class KotlinTestActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_test)

        initViews()
    }

    private fun initViews()
    {
        test_text_view?.text = "Aviv the king"
    }
}
