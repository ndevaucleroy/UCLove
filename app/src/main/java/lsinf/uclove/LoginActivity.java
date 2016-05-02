package lsinf1225.uclove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private static final String VALID_USERNAME_CHAR = "[a-zA-Z0-9_-]{3,15}$";
    private static final String VALID_PASSWORD_CHAR = "[a-zA-Z0-9_-]{6,20}$";

    private EditText login, password;
    private EditText confirmPassword, email;
    private Button signInButton, registerButton;
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

        signInButton.setOnClickListener(new View.OnClickListener()
            {@Override public void onClick(View v) { tryToLogIn(); }});

        confirmPassword = (EditText) findViewById(R.id.confirmpassword);
        email = (EditText) findViewById(R.id.email);
        confirmPassword.setVisibility(View.GONE);
        email.setVisibility(View.GONE);

        registerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                tryRegister();
            }
        });
    }

    private void userLogin(String username, String stringpassword) {

        if (User.isLoginAvailable(username)) {
            MyApplication.setUser(new User(username, this));
            if (MyApplication.getUser() == null)
                sendError(password, "Error: Incorrect Password");
            else{

                setUserAndSwitch();
            }
        } else showRegister();
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
    private void hideRegister(){
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

    private void tryToLogIn() {

        setErrorsToNull();

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

    private void tryRegister() {

        setErrorsToNull();
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

        MyApplication.setUser(new User(username, this));
        setUserAndSwitch();
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

    private void setUserAndSwitch() {

        Intent intent = new Intent(this, StartupActivity.class);
        Toast.makeText(LoginActivity.this, "Redirection...", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    private void sendError(EditText field, String message) {
        field.setError(message);
        field.requestFocus();
    }

    private void setErrorsToNull() {
        login.setError(null);
        password.setError(null);
        confirmPassword.setError(null);
        email.setError(null);
    }
}
