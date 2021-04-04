package ru.mirea.sorokin.bsbo0819.practice2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ActivityLifecycle extends AppCompatActivity {

    private String TAG = ActivityLifecycle.class.getSimpleName();

    public  void onClickNewActivity(View view){
        EditText nameText = findViewById(R.id.name);
        String name = nameText.getText().toString();
        Intent intent = new Intent(ActivityLifecycle.this, SecondActivity.class);
        intent.putExtra("key",name);
        startActivity(intent);
    }
    public void onClickShare(View view){
        EditText nameText = findViewById(R.id.name);
        String name = nameText.getText().toString();
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"MIREA");
        shareIntent.putExtra(Intent.EXTRA_TEXT,name);
        startActivity(Intent.createChooser(shareIntent,"Фамилия имя отчество"));
    }
    public void onClickBrowser(View View){
        Uri address = Uri.parse("https://www.mirea.ru/");
        Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
        if (openLinkIntent.resolveActivity(getPackageManager()) != null){
            startActivity(openLinkIntent);
        }
        else{
            Log.d("Inten","Невозможно обработать намерение");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"Запущен метод onCreate");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG,"Запущен метод onStart");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"Запущен метод on onRestoreInstanceState");
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        Log.i(TAG,"Запущен метод onPostCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Запущен метод onResum");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i(TAG,"Запущен метод onResum");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG,"Запущен метод onAttachedToWindow");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"Запущен метод onPause");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG,"Запущен метод onSaveInstance");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"Запущен метод onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Запущен метод onDestroy");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(TAG,"Запущен метод onDetachedToWindow");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"Запущен метод onRestart");
    }
}