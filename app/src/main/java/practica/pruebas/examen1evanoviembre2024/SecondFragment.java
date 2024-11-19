package practica.pruebas.examen1evanoviembre2024;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import practica.pruebas.examen1evanoviembre2024.R;

public class SecondFragment extends Fragment {

    private TextView displayTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        displayTextView = view.findViewById(R.id.displayTextView);
        return view;
    }

    public void updateTextColor(int color) {
        if (displayTextView != null) {
            displayTextView.setTextColor(color);
            System.out.println("Text color updated to: " + color);
        } else {
            System.out.println("displayTextView is null");
        }
    }
}