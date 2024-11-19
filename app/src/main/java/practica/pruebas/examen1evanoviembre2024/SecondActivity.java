package practica.pruebas.examen1evanoviembre2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // Referencia al botón
        findViewById(R.id.firstFragmentContainer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar a la segunda actividad
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        callFragments();
    }

    private void callFragments() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.firstFragmentContainer, new FirstFragment())
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.secondFragmentContainer, new SecondFragment())
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.thirdFragmentContainer, new ThirdFragment())
                .commit();
    }

    public void updateText(String text, float fontSize) {
        /*SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager()
                .findFragmentById(R.id.secondFragmentContainer);
        if (secondFragment != null) {
            secondFragment.updateText(text, fontSize);
        }*/
    }

    public void updateTextColor(int color) {
        /*SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager()
                .findFragmentById(R.id.secondFragmentContainer);
        if (secondFragment != null) {
            secondFragment.updateTextColor(color);
        }*/
    }
}
