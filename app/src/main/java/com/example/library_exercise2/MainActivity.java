package com.example.library_exercise2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.easydialog.DialogTypes.EasyAlertDialog;
import com.example.easydialog.DialogTypes.EasyInputDialog;
import com.example.easydialog.Interfaces.DialogListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_alert_dialog).setOnClickListener(v -> {
            EasyAlertDialog alertDialog = new EasyAlertDialog(this);
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("This is an alert dialog.");
            alertDialog.setPositiveButtonText("OK");
            alertDialog.setNegativeButtonText("Cancel");
            alertDialog.setDialogListener(new DialogListener() {
                @Override
                public void onPositiveButtonClick() {
                    Toast.makeText(MainActivity.this, "OK clicked", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNegativeButtonClick() {
                    Toast.makeText(MainActivity.this, "Cancel clicked", Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.show();
        });

        findViewById(R.id.show_input_dialog).setOnClickListener(v -> {
            EasyInputDialog inputDialog = new EasyInputDialog(this);
            inputDialog.setTitle("Input");
            inputDialog.setPositiveButtonText("Submit");
            inputDialog.setNegativeButtonText("Cancel");
            inputDialog.setDialogListener(new DialogListener() {
                @Override
                public void onPositiveButtonClick() {
                    String input = inputDialog.getInputText();
                    Toast.makeText(MainActivity.this, "Input: " + input, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNegativeButtonClick() {
                    Toast.makeText(MainActivity.this, "Cancel clicked", Toast.LENGTH_SHORT).show();
                }
            });
            inputDialog.show();
        });


    }
}