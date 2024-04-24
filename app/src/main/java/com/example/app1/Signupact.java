package com.example.app1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class Signupact extends AppCompatActivity {

    EditText signupName, signupEmail, signupPassword, signupUsername;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override //used to indicate that a method is overriding a method of its superclass
//    Bundles are used for passing data between Android components
//    such as activities and fragments.
    protected void onCreate(Bundle savedInstanceState) {//called when the activity is being created.

        super.onCreate(savedInstanceState); //call this method to ensure that
        // the superclass's initialization code is executed properly.
        EdgeToEdge.enable(this); //edge-to-edge display
        setContentView(R.layout.activity_signupact);
        //find elements in the xml file
        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);
//        listens for clicks on the button and executes the code
//        inside the onClick method when the button is clicked.
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                 initialize the Firebase Realtime Database
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                HelperClass helperClass = new HelperClass(name, email, username, password);
//                saves the user's information to the Firebase
//                Realtime Database under a child node with the username as the key.
                reference.child(username).setValue(helperClass);
                Toast.makeText(Signupact.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
//               navigate from the current activity (Signupact) to
//               the Loginact activity nd starts the Loginact activity.
                Intent intent = new Intent(Signupact.this, Loginact.class);
                startActivity(intent);
            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signupact.this, Loginact.class);
                startActivity(intent);
            }
        });
    }
}