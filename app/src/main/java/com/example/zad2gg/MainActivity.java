package com.example.zad2gg;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextSurname;
    private EditText editNumberPhone;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //Powiązanie widoków z kodem
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSurname = findViewById(R.id.editTextSurname);
        editNumberPhone = findViewById(R.id.editNumberPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = findViewById(R.id.editTextPasswordConfirm);

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //pobranie wprowadzonych danych
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String numberphone = editNumberPhone.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordconfirm = editTextPasswordConfirm.getText().toString().trim();
                //walidacja danych
                if (name.isEmpty()) {
                    showToast("Wprowadź imię!");
                } else if (surname.isEmpty()) {
                    showToast("Wprowadź nazwisko!");
                } else if (email.isEmpty()) {
                    showToast("Wprowadź adres e-mail!");
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    showToast("Wprowadzony adres e-mail jest niepoprawny");
                } else if (numberphone.isEmpty()) {
                    showToast("Wprowadź nr telefonu");
                } else if (numberphone.length() < 9) {
                    showToast("Wprowadzono niepoprawny nr telefonu");
                } else if (password.isEmpty()) {
                    showToast("Wprowadź hasło!");
                } else if (password.length() < 6) {
                    showToast("Hasło jest za krótkie!");
                } else if (passwordconfirm.isEmpty()) {
                    showToast("Potwierdź hasło!");
                } else if (!passwordconfirm.equals(password)) {
                    showToast("Hasła się nie zgadzają!");
                } else {
                    showToast("Formularrz przesłany poprawnie");
                }
            }

            private void showToast(String m) {
            }
        });
    }
}