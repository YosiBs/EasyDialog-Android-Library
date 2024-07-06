package com.example.easydialog.DialogTypes;

import android.content.Context;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.easydialog.EasyDialog;
import com.example.easydialog.R;

public class EasyInputDialog extends EasyDialog {

    private EditText inputField;

    public EasyInputDialog(@NonNull Context context) {
        super(context);
        inputField = findViewById(R.id.dialog_input);
    }

    public String getInputText() {
        return inputField.getText().toString();
    }
}
