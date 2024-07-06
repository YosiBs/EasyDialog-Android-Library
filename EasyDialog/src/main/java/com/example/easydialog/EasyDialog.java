package com.example.easydialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

import androidx.annotation.NonNull;

import com.example.easydialog.Interfaces.CustomizableDialog;
import com.example.easydialog.Interfaces.DialogListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public abstract class EasyDialog extends Dialog implements CustomizableDialog {

    protected MaterialTextView titleView;
    protected MaterialTextView messageView;
    protected MaterialButton positiveButton;
    protected MaterialButton negativeButton;
    protected DialogListener listener;

    public EasyDialog(@NonNull Context context){
        super(context);
        init();
    }

    private void init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom);

        titleView = findViewById(R.id.dialog_title);
        messageView = findViewById(R.id.dialog_message);
        positiveButton = findViewById(R.id.dialog_positive_button);
        negativeButton = findViewById(R.id.dialog_negative_button);

        positiveButton.setOnClickListener(v -> {
            if (listener != null) listener.onPositiveButtonClick();
            dismiss();
        });

        negativeButton.setOnClickListener(v -> {
            if (listener != null) listener.onNegativeButtonClick();
            dismiss();
        });
    }
    @Override
    public void setTitle(String title) {
        titleView.setText(title);
    }

    @Override
    public void setMessage(String message) {
        messageView.setText(message);
    }

    @Override
    public void setPositiveButtonText(String text) {
        positiveButton.setText(text);
    }

    @Override
    public void setNegativeButtonText(String text) {
        negativeButton.setText(text);
    }

    @Override
    public void setDialogListener(DialogListener listener) {
        this.listener = listener;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }


}
