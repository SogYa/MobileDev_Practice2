package ru.mirea.sorokin.bsbo0819.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        java.util.Calendar dateAndTime = java.util.Calendar.getInstance();
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hour, int minute) {
                dateAndTime.set(Calendar.HOUR, hour);
                dateAndTime.set(Calendar.MINUTE, minute);
            }
        };
        TimePickerDialog timePickDialog = new TimePickerDialog(getContext(), timeSetListener,
                dateAndTime.get(Calendar.HOUR),
                dateAndTime.get(Calendar.MINUTE),
                true);
        return timePickDialog;
    }
}
