package com.example.ishop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.hbb20.CountryCodePicker

class LoginActivity : AppCompatActivity() {

    private lateinit var phoneInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var loginButton: Button
    private lateinit var createAccountButton: Button
    private lateinit var forgotPasswordButton: Button
    private lateinit var loadingIndicator: ProgressBar
    private lateinit var backButton: ImageView
    private lateinit var rememberMeCheckBox: CheckBox
    private lateinit var countryCodePicker: CountryCodePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        // Initialize Views
        phoneInput = findViewById(R.id.login_phone_edittext)
        passwordInput = findViewById(R.id.login_password_editText)
        loginButton = findViewById(R.id.login_button)
        createAccountButton = findViewById(R.id.create_account_button)
        forgotPasswordButton = findViewById(R.id.forgot_password_button)
        loadingIndicator = findViewById(R.id.loading_indicator)
        backButton = findViewById(R.id.login_back_button)
        rememberMeCheckBox = findViewById(R.id.remember_me)
        countryCodePicker = findViewById(R.id.login_country_code_picker)

        // Navigate back when back button is clicked
        backButton.setOnClickListener {
            finish()
        }

        // Navigate to SignUpActivity when "Sign Up" is clicked
        createAccountButton.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        // Forgot Password button click
        forgotPasswordButton.setOnClickListener {
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
            // You can add ForgotPasswordActivity navigation here
        }

        // Login button click
        loginButton.setOnClickListener {
            val phoneNumber = phoneInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val fullPhone = "+${countryCodePicker.selectedCountryCode}$phoneNumber"

            if (validateInputs(phoneNumber, password)) {
                performLogin(fullPhone, password)
            }
        }
    }

    private fun validateInputs(phone: String, password: String): Boolean {
        return when {
            phone.isEmpty() -> {
                Toast.makeText(this, "Please enter phone number", Toast.LENGTH_SHORT).show()
                false
            }
            password.isEmpty() -> {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }

    private fun performLogin(phone: String, password: String) {
        loadingIndicator.visibility = View.VISIBLE
        loginButton.isEnabled = false

        // Simulate login process (Replace with Firebase or API login)
        loginButton.postDelayed({
            loadingIndicator.visibility = View.GONE
            loginButton.isEnabled = true

            if (phone == "+233123456789" && password == "123456") {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }, 2000)
    }
}
