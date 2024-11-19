package practica.pruebas.examen1evanoviembre2024;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import practica.pruebas.examen1evanoviembre2024.R;
import practica.pruebas.examen1evanoviembre2024.SecondActivity;

public class FirstFragment extends Fragment {

    private EditText inputText;
    private SeekBar fontSeekBar;
    private Button changeTextButton;
    private float fontSize = 24f;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        inputText = view.findViewById(R.id.inputText);
        fontSeekBar = view.findViewById(R.id.fontSeekBar);
        changeTextButton = view.findViewById(R.id.changeTextButton);

        fontSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fontSize = 12 + (progress / 4f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        changeTextButton.setOnClickListener(v -> {
            String text = inputText.getText().toString();
            if (getActivity() instanceof SecondActivity) {
                ((SecondActivity) getActivity()).updateText(text, fontSize);
            }
        });

        return view;
    }
}
