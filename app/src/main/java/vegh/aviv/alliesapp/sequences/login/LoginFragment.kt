package vegh.aviv.alliesapp.sequences.login

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.*
import vegh.aviv.alliesapp.R
import vegh.aviv.alliesapp.sequences.global.activities.MainActivity
import vegh.aviv.alliesapp.sequences.signup.SignUpActivity


/**
 * Created by avivvegh on 21/05/2017.
 */
class LoginFragment : Fragment() {
    private var viewModel: LoginViewModel? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_login, container, false)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        initViews(view)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickListeners()
    }

    private fun initViews(view: View?) {

    }

    private fun initClickListeners() {
        this.createAccountLayout.setOnClickListener {
            startActivity(Intent(activity, SignUpActivity::class.java))
        }

        this.confirmLoginButton.setOnClickListener {
            viewModel?.login(emailEditText.text.toString(), passwordEditText.text.toString())
                    ?.subscribe({ token ->
                        startActivity(Intent(activity, MainActivity::class.java))
                        activity.finish()
                    }, { error ->

                    })
        }
    }
}
