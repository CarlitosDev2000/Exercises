package com.carloscordova.my_dialog_exercise;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "mainActivity";
    private Button saveButton;
    private Button showRecordsButton;
    private Button cleanRecordsButton;
    private EditText ageEditText;
    private EditText nameEditText;
    private EditText emailEditText;
    private List<String> list;

    private Toast toast;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "++ ON CREATE ++");
        list = new ArrayList<>();
        toast = new Toast(this);
        setContentView(R.layout.activity_main);
        saveButton = findViewById(R.id.save_data_button);
        showRecordsButton = findViewById(R.id.show_button);
        cleanRecordsButton = findViewById(R.id.clear_records);
        ageEditText = findViewById(R.id.age_option);
        nameEditText = findViewById(R.id.name_option);
        emailEditText = findViewById(R.id.email_option);
        saveButton.setOnClickListener(v -> saveFormValues());
        showRecordsButton.setOnClickListener(view -> showDialod());
        cleanRecordsButton.setOnClickListener(v -> {
            toast.setText("Deleted records : " + list.size());
            toast.show();
            // TODO: do something with the variable list to clear all the items;
            assert list.isEmpty();
        });
    }
    private void clearEditTextFields() {
        nameEditText.setText("");
        ageEditText.setText("");
        emailEditText.setText("");
    }
    private void saveFormValues() {
        boolean isNameValid = false;
        boolean isEmailValid = false;
        boolean isAgeValid = false;

        String emailString = emailEditText.getText().toString();
        String ageString = ageEditText.getText().toString();
        String nameString = nameEditText.getText().toString();

        if(isValidEmail(emailString)) {
            isEmailValid = true;
        } else {
            toast.setText("error message here for invalid email");
            toast.show();
        }
        if(isValidName(nameString)) {
            isNameValid = true;
        } else {
            toast.setText("error message here for invalid name");
            toast.show();
        }
        if(isAgeValid(ageString)) {
            isAgeValid = true;
        } else {
            toast.setText("error message here for invalid age");
            toast.show();
        }
        if(isNameValid && isEmailValid && isAgeValid) {
            list.add(nameString + " : " + emailString + " : " + ageString);
            clearEditTextFields();
        }
    }

    private void showDialod() {
        StringBuilder sb = new StringBuilder();
        list.forEach( str-> {
            sb.append(str);
            sb.append("\n");
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Records");
        builder.setMessage(sb.toString());
        builder.setPositiveButton("Aceptar", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private boolean isValidEmail(String email){
        //TODO
        // validate here if email contains [@] and has at least one [.] character and length is at least 5 characters,
        // then resolve as true otherwise is false
        return false;
    }
    private boolean isValidName(String name){
        //TODO
        // validate here if name length is not empty , and has at least 3 characters
        // then resolve as true otherwise is false
        return false;
    }
    private boolean isAgeValid(String age){
        //TODO
        // validate here if age is greater of equals thatn 18 and less than 99
        // then resolve as true otherwise is false
        // This is a string you need to parse it from string to int
        return false;
    }
}
