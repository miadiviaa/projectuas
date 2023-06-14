package com.si5b.bimbelku;

import static com.si5b.bimbelku.R.color.purple_500;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.os.Bundle;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.content.Intent;
import android.view.MenuItem;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(purple_500)));
    }
}