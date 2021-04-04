package ru.mirea.sorokin.bsbo0819.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void ShowDialogOnClick(View v) {
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Отлично!", Toast.LENGTH_SHORT).show();
    }

    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Не останавливайся!", Toast.LENGTH_SHORT).show();
    }

    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Скорее возвращайся!", Toast.LENGTH_SHORT).show();
    }

    public void onClickDatePickDialog(View view) {
        DialogFragment dialogFragment = new DatePickDialog();
        dialogFragment.show(getSupportFragmentManager(), "datePick");
    }

    public void onClickTimePickDialog(View view) {
        DialogFragment dialogFragment = new TimePickDialog();
        dialogFragment.show(getSupportFragmentManager(),"timePick");
    }

    public void onClickProgressDialog(View view) {
        DialogFragment dialogFragment = new ProgressDialogActivity();
        dialogFragment.show(getSupportFragmentManager(),"progress");
    }
}
