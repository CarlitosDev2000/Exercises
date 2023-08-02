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

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "++ ON CREATE ++");
        list = new ArrayList<>();
        setContentView(R.layout.activity_main);
        saveButton = findViewById(R.id.save_data_button);
        showRecordsButton = findViewById(R.id.show_button);
        cleanRecordsButton = findViewById(R.id.clear_records);
        ageEditText = findViewById(R.id.age_option);
        nameEditText = findViewById(R.id.name_option);
        emailEditText = findViewById(R.id.email_option);
        saveButton.setOnClickListener(v -> {
            saveFormValues();

        });
        showRecordsButton.setOnClickListener(view -> showDialog());
        cleanRecordsButton.setOnClickListener(v -> {
            if (list.isEmpty()){
                showToast("no records to show");
            }else
            showToast("Deleted records" + list.size());
            // TODO: do something with the variable list to clear all the items;
            list.clear();
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
            emailEditText.setError("put your true email");
        }
        if(isValidName(nameString)) {
            isNameValid = true;
        } else {
            nameEditText.setError("put correct your name");
        }
        if(isAgeValid(ageString)) {
            isAgeValid = true;
        } else {
            ageEditText.setError("put your real age");
        }
        if(isNameValid && isEmailValid && isAgeValid) {
            list.add(nameString + " : " + emailString + " : " + ageString);
            showToast("Added records.");
            clearEditTextFields();
        }
    }

    private void showDialog() {
        StringBuilder sb = new StringBuilder();
        list.forEach( str-> {
            sb.append(str);
            sb.append("\n");
        });
        if (sb.length() == 0) {
            sb.append("No hay registros disponibles");
        }
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
        if (!email.contains("@") && !email.contains(".")) {
            showToast("Falta los simbolos @ o . en el email.");
            return false;
        } if (email.length() < 5 || email.length() > 40) {
            showToast("El email debe tener entre 5 y 40 caracteres.");
            return false;
        }else
            return true;
    }
    private boolean isValidName(String name){
        //TODO
        // validate here if name length is not empty , and has at least 3 characters
        // then resolve as true otherwise is false
        if (name.length() >= 3 && name.length() <= 20){
            return true;
        }else
            showToast("nombre debe tiene que tener de 3 a 20 caracteres");
            return false;
    }
    private boolean isAgeValid(String age){
        //TODO
        // validate here if age is greater of equals thatn 18 and less than 99
        // then resolve as true otherwise is false
        // This is a string you need to parse it from string to int
        try {
            int ageValues = Integer.parseInt(age);
            return ageValues >= 18 && ageValues < 99 && !age.isEmpty();
        } catch (NumberFormatException ega){
            showToast("numero incorrecto");
            return false;
        }
    }
    private void showToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
}
