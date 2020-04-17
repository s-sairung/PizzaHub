package chula.project.pizzahub;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import chula.project.pizzahub.classes.FileInteract;

public class OrderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollOrder);
//        final TextView rawOrder = new TextView(getContext());
//        rawOrder.setText(FileInteract.readRawOrderFile(getContext()));
//        rawOrder.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
//        layout.addView(rawOrder);

        Button clearOrder = (Button) view.findViewById(R.id.clearOrderButton);
        clearOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInteract.clearOrder(getContext());
                Toast.makeText(getActivity(),"Order Cleared", Toast.LENGTH_SHORT).show();
//                rawOrder.setText(FileInteract.readRawOrderFile(getContext()));
            }
        });
        return view;
    }
}
