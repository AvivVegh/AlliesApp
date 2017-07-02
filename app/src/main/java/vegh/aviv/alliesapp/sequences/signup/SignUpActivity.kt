package vegh.aviv.alliesapp.sequences.signup

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import kotlinx.android.synthetic.main.content_sign_up.*
import vegh.aviv.alliesapp.R
import vegh.aviv.alliesapp.globals.managers.RestManager

class SignUpActivity : AppCompatActivity() {
    private var viewModel: SignupViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(SignupViewModel::class.java)

        initClickListeners()
    }

    private fun initClickListeners() {
        signupView.setOnClickListener {

            RestManager.register("aa@ddssdrs.c", "12345678")?.subscribe({ user ->
                Log.d("user",user.email)
            }, { error ->
                Log.d("error","eeer")
            })

//            viewModel?.register(emailEditText.text.toString()
//                    , passwordEditText.text.toString())?.subscribe({ user ->
//                startActivity(Intent(this, MainActivity::class.java))
//            }, { error ->
//
//            })
        }
    }

}
