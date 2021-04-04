package ru.mirea.sorokin.bsbo0819.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class ProgressDialogActivity extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle saveInstance){
        ProgressDialog progressDialog = new ProgressDialog(ProgressDialogActivity.this.getContext());
        progressDialog.setProgressStyle(ProgressDialogActivity.STYLE_NORMAL);
        progressDialog.setMessage("Загрузка");
        return progressDialog;
    }
}
