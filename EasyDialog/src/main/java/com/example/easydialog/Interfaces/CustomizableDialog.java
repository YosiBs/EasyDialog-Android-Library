package com.example.easydialog.Interfaces;

public interface CustomizableDialog {
    void setTitle(String title);
    void setMessage(String message);
    void setPositiveButtonText(String text);
    void setNegativeButtonText(String text);
    void setDialogListener(DialogListener listener);
    void show();
    void dismiss();
}
