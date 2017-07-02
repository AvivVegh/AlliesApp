package vegh.aviv.alliesapp.sequences.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.content_login.*
import vegh.aviv.alliesapp.R
import java.io.IOException

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViews()
    }

    private fun initViews() {
        loginFrameLayout.visibility = View.INVISIBLE

        supportFragmentManager.beginTransaction()
                .replace(R.id.loginFrameLayout, LoginFragment()).commit()

        try {
            loginViewView.setRawData(R.raw.allies_video_1)
            loginViewView.isLooping = true
            loginViewView.prepare({ loginViewView.start() })
        } catch (e: IOException) {
            e.printStackTrace()
        }

        slideUp()
    }

    private fun slideUp() {
        val bottomUp = AnimationUtils.loadAnimation(this, R.anim.slide_in_up)

        loginFrameLayout.startAnimation(bottomUp)
        loginFrameLayout.visibility = View.VISIBLE
    }
}
