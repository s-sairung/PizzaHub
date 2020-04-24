package chula.project.pizzahub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import chula.project.pizzahub.classes.FileInteract;

public class HistoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollHistory);

        TextView rawHistory = new TextView(getContext());
        rawHistory.setText(FileInteract.readRawHistoryFile(getContext()));
        layout.addView(rawHistory);

        return view;
    }
}
