package com.example.ud3_ejemplo1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Método que lanza un intent implícito a la web de Google.
     * @param view
     */
    public void abrirIntent(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));

        // Verificamos si existe una aplicación para gestionarlo.
        if(intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

}
