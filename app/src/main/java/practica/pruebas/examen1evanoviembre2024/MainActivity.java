package practica.pruebas.examen1evanoviembre2024;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout sky = findViewById(R.id.sky);
        View sun = findViewById(R.id.sun);

        // Título en la toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Posta de Sol");
        }

        // Configurar Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Añadir palabra a la izquierda
        toolbar.setNavigationIcon(null); // Opcional, quita el icono predeterminado
        TextView leftText = new TextView(this);
        leftText.setText("\n \n Posta de Sol");
        leftText.setTextSize(18f);
        leftText.setTextColor(getResources().getColor(android.R.color.white));
        toolbar.addView(leftText);

        sky.setOnClickListener(v -> startSunsetAnimation(sun, sky));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // poner el archivo de menú
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    private void startSunsetAnimation(View sun, View sky) {

        sun.setTranslationX(0);
        sun.setTranslationY(0);

        // Animación del Sol hacia abajo
        ObjectAnimator sunDown = ObjectAnimator.ofFloat(sun, "translationY", 500);

        sunDown.setDuration(3000);

        // Cambio de color del cielo
        ObjectAnimator skyColor = ObjectAnimator.ofArgb(sky, "backgroundColor",
                Color.parseColor("#87CEEB"), // Azul claro (día)
                Color.parseColor("#FF4500"), // Naranja (atardecer)
                Color.parseColor("#000000")); // Negro (noche)
        skyColor.setDuration(4500);

        // Combinar animaciones
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(sunDown).with(skyColor);
        animatorSet.start();
    }
}
