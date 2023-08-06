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
        showRecordsButton.setOnClickListener(view -> renderListViewWithData());
        cleanRecordsButton.setOnClickListener(v -> {
            showToast("Deleted records" + list.size());
            list.clear();
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
            emailEditText.setError("Invalid email");
        }
        if(isValidName(nameString)) {
            isNameValid = true;
        } else {
            nameEditText.setError("Invalid name");
        }
        if(isAgeValid(ageString)) {
            isAgeValid = true;
        } else {
            ageEditText.setError("Invalid age");
        }
        if(isNameValid && isEmailValid && isAgeValid) {
            list.add(nameString + " : " + emailString + " : " + ageString);
            showToast("Added records.");
            clearEditTextFields();
        }
    }

    private void renderListViewWithData() {
       //TODO aqui es donde pasamos la lista al arrayAdaptor, utilizamos la lista

    }

    private boolean isValidEmail(String email){
        if (email.length() >= 6 && email.contains("@") && email.contains(".")) {
            int firstIndexAt = email.indexOf("@");
            int lastIndexAt = email.lastIndexOf("@");
            if (firstIndexAt == lastIndexAt && firstIndexAt > 0 && lastIndexAt < email.length()-4) {
                return true;
            } else {
                return false;
            }
        }
        showToast("email tiene que ser mayor que 6 chars  o falta el arroba o el punto");
        return false;
    }
    private boolean isValidName(String name){
        if (name.length() >= 3 && name.length() <= 20){
            return true;
        }else {
            showToast("nombre debe tiene que tener de 3 a 20 caracteres");
            return false;
        }
    }
    private boolean isAgeValid(String ageParan){
        try {
            int age = Integer.parseInt(ageParan);
            return age >= 18 && age < 99;
        } catch (NumberFormatException ega){
            showToast("numero incorrecto");
            return false;
        }
    }
    private void showToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
}
