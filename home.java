package lsinf1225.uclove;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class home extends AppCompatActivity {

    /** Valid character for a username: not an invisible or control character. */
    private static final String VALID_USERNAME_CHAR = "[a-zA-Z0-9_-]{3,15}$";
    /** Valid character for a password: not a control character. */
    private static final String VALID_PASSWORD_CHAR = "[a-zA-Z0-9_-]{6,20}$";

    // Login fields.
    private EditText login, password;
    // Register fields.
    private EditText confirmPassword, email;
    // Buttons.
    private Button signInButton, registerButton;
    // Whether the registering part is shown.
    private boolean isRegisterShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        signInButton = (Button) findViewById(R.id.signin);
        registerButton = (Button) findViewById(R.id.register);
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        registerButton = (Button) findViewById(R.id.register);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptToLogIn();

                /*if(email.getText().toString().equals("admin") &&
                        password.getText().toString().equals("password")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                    text.setVisibility(View.VISIBLE);
                    text.setBackgroundColor(Color.RED);
                    count--;
                    text.setText(Integer.toString(count));

                    if (count == 0) {
                        login.setEnabled(false);
                    }
                }*/
            }
        });

        confirmPassword = (EditText) findViewById(R.id.confirmpassword);
        email = (EditText) findViewById(R.id.email);
        confirmPassword.setVisibility(View.GONE);
        email.setVisibility(View.GONE);

        registerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegister();
            }
        });
    }

    private void userLogin(String username, String stringpassword) {

        if (User.isLoginAvailable(username)) {

            User user = new User();

            if (user == null) {
                sendError(password, "Error: Incorrect Password");
            } else {
                setUserAndSwitch(user);
            }
        } else {
            showRegister();
        }
    }

    private void setUserAndSwitch(User user) {
        Intent intent = new Intent(this, profileActivity.class);
        startActivity(intent);
    }

    private void showRegister() {
        isRegisterShown = true;

        // Hide login button
        signInButton.setVisibility(View.GONE);

        // Display additional fields and register button.
        confirmPassword.setVisibility(View.VISIBLE);
        email.setVisibility(View.VISIBLE);
        registerButton.setVisibility(View.VISIBLE);

        // Change focus to the next field to fill.
        confirmPassword.requestFocus();
    }

    /**
     * Hides the registering part of the form.
     */
    private void hideRegister() {
        isRegisterShown = false;

        // Hide additional fields and register button.
        registerButton.setVisibility(View.GONE);
        email.setVisibility(View.GONE);
        confirmPassword.setVisibility(View.GONE);

        // Display login button.
        signInButton.setVisibility(View.VISIBLE);

        // Change focus to the username field.
        login.requestFocus();
    }

    @Override
    public void onBackPressed() {
        if (isRegisterShown) {
            hideRegister();
        } else {
            finish();
        }
    }

    private void attemptToLogIn() {

        resetErrors();

        String username = login.getText().toString();
        String stringpassword = password.getText().toString();

        if (TextUtils.isEmpty(username)) {
            sendError(login, "Error field required: please fill all the fields");
            return;
        }
        if (TextUtils.isEmpty(stringpassword)) {
            sendError(password, "Error field required: please fill all the fields");
            return;
        }

        if (!isUsernameValid(username)) {
            sendError(login, "Error: Login is invalid");
            return;
        }
        if (!isPasswordValid(stringpassword)) {
            sendError(password, "Error: Password is invalid");
            return;
        }

        userLogin(username, stringpassword);
    }

    private void attemptRegister() {

        resetErrors();
        showRegister();
        String username = login.getText().toString();
        String stringpassword = password.getText().toString();
        String stringconfirmPassword = confirmPassword.getText().toString();
        String stringemail = email.getText().toString();

        // All fields are required.
        if (TextUtils.isEmpty(username)) {
            sendError(login, "Error field required: please fill all the fields");
            return;
        }
        if (TextUtils.isEmpty(stringpassword)) {
            sendError(password, "Error field required: please fill all the fields");
            return;
        }
        if (TextUtils.isEmpty(stringconfirmPassword)) {
            sendError(confirmPassword, "Error field required: please fill all the fields");
            return;
        }
        if (TextUtils.isEmpty(stringemail)) {
            sendError(email, "Error field required: please fill all the fields");
            return;
        }

        // All fields must be valid.
        if (!isUsernameValid(username)) {
            sendError(login, "Error: Login is invalid");
            return;
        }
        if (!isPasswordValid(stringpassword)) {
            sendError(password, "Error: Password is invalid");
            return;
        }
        if (!isEmailValid(stringemail)) {
            sendError(email, "Error: Email is invalid");
            return;

        }

        // The passwords must match.
        if (!stringpassword.equals(stringconfirmPassword)) {
            sendError(confirmPassword, "Error: password mismatch");
            return;
        }

        userRegister(username, stringpassword, stringemail);
    }

    private void userRegister(String username, String stringpassword, String stringemail) {

        if (!User.isLoginAvailable(username)) {
            sendError(login, "Error: This username has already been taken");
            return;
        }
        /*if (DaoUser.isEmailTaken(stringemail)) {
            reportError(mEmailView, getString(R.string.error_email_taken));
            return;
        }*/
        setUserAndSwitch(new User());
    }

    private boolean isUsernameValid(String username) {
        return Pattern.compile("^"+VALID_USERNAME_CHAR+"{3,20}$").matcher(username).matches();
    }

    private boolean isPasswordValid(String password) {
        return Pattern.compile("^"+VALID_PASSWORD_CHAR+"{5,50}$").matcher(password).matches();
    }

    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void sendError(EditText field, String message) {
        field.setError(message);
        field.requestFocus();
    }

    private void resetErrors() {
        login.setError(null);
        password.setError(null);
        confirmPassword.setError(null);
        email.setError(null);
    }
}
