package com.carloscordova.my_dialog_exercise;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import android.annotation.SuppressLint;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "mainActivity";
    private Button saveButton;
    private Button resetButton;
    private EditText ageEditText;
    private EditText nameEditText;
    private List<String> nameList = new ArrayList<>();
    private List<String> ageList = new ArrayList<>();
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "++ ON CREATE ++");
        setContentView(R.layout.activity_main);
        saveButton = findViewById(R.id.save_data_button);
        resetButton = findViewById(R.id.reset_button);
        ageEditText = findViewById(R.id.age_option);
        nameEditText = findViewById(R.id.name_option);
        InputFilter[] filtersName = new InputFilter[] { new AlphabetInputFilter() };
        nameEditText.setFilters(filtersName);
        InputFilter[] filtersAge = new InputFilter[] { new NumberInputFilter()};
        ageEditText.setFilters(filtersAge);
        int maxLengthLetter = 43;
        int maxLengthNumber =2;
        nameEditText.setFilters(new InputFilter[] { new AlphabetInputFilter(), new InputFilter.LengthFilter(maxLengthLetter) });
        ageEditText.setFilters(new InputFilter[] { new NumberInputFilter(), new InputFilter.LengthFilter(maxLengthNumber) });
        saveButton.setOnClickListener(v -> showPopupDialog());
        resetButton.setOnClickListener(view -> clearEditTextFields());
    }
    //editamos los filters a los editTexts
    private class AlphabetInputFilter implements InputFilter {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            StringBuilder stringBuilderA = new StringBuilder();
            for (int i = start; i < end; i++) {
                char character = source.charAt(i);
                if (Character.isLetter(character)) {
                    stringBuilderA.append(character);
                }
            }
            return stringBuilderA.toString();
        }
    }
    private class NumberInputFilter implements InputFilter {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            StringBuilder stringBuilderN = new StringBuilder();
            for (int i = start; i < end; i++) {
                char character = source.charAt(i);
                if (Character.isDigit(character)) {
                    stringBuilderN.append(character);
                }
            }
            return stringBuilderN.toString();
        }
    }
    private void clearEditTextFields() {
        nameEditText.setText("");
        ageEditText.setText("");
    }
    //funciones de pop_up_layout
    private void showPopupDialog() {
        AppCompatDialog dialog = new AppCompatDialog(this);
        dialog.setContentView(R.layout.pop_up_layout);
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        nameList.add(name);
        ageList.add(age);
        TextView nameTextView = dialog.findViewById(R.id.popup_name_textview);
        TextView ageTextView = dialog.findViewById(R.id.popup_age_textview);
        Button closeButton = dialog.findViewById(R.id.popup_ok_button);
        Button eliminarButton = dialog.findViewById(R.id.popup_eliminar_button);

        StringBuilder namesBuilder = new StringBuilder();
        StringBuilder agesBuilder = new StringBuilder();
        for (int i = 0; i < nameList.size(); i++) {
            namesBuilder.append("Nombre ").append(i + 1).append(": ").append(nameList.get(i)).append("\n");
            agesBuilder.append("Edad ").append(i + 1).append(": ").append(ageList.get(i)).append("\n");
        }
        nameTextView.setText(namesBuilder.toString());
        ageTextView.setText(agesBuilder.toString());

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                clearEditTextFields();
            }
        });
        eliminarButton.setOnClickListener(view -> {
            if (!nameList.isEmpty()) {
                nameList.remove(nameList.size() - 1);
            }
            if (!ageList.isEmpty()) {
                ageList.remove(ageList.size() - 1);
            }
            StringBuilder namesBuilder1 = new StringBuilder();
            StringBuilder agesBuilder1 = new StringBuilder();
            for (int i = 0; i < nameList.size(); i++) {
                namesBuilder1.append("Nombre ").append(i + 1).append(": ").append(nameList.get(i)).append("\n");
                agesBuilder1.append("Edad ").append(i + 1).append(": ").append(ageList.get(i)).append("\n");
            }
            nameTextView.setText(namesBuilder1.toString());
            ageTextView.setText(agesBuilder1.toString());
        });
        dialog.show();
    }
}
