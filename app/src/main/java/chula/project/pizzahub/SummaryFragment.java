package chula.project.pizzahub;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.InputStringConvert;

public class SummaryFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollSummary);
        String[] processedOrder = InputStringConvert.getOrderArray(FileInteract.readRawOrderFile(getContext()));

        for (int i = 0; i < processedOrder.length; i++) {
            String order = processedOrder[i];
            order = order.trim();
            if (!order.equals("")) {
                TextView orderTextView = new TextView(getContext());
                orderTextView.setText(order);
                orderTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                layout.addView(orderTextView);
            }
        }

        Button confirmButton = new Button(getContext());
        confirmButton.setText("Confirm and Pay");
        confirmButton.setOnClickListener(this);
        layout.addView(confirmButton);

        return view;
    }

    public void onClick(View v) {

    }

}
