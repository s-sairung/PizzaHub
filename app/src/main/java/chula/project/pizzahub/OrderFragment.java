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
import androidx.fragment.app.FragmentTransaction;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.InputStringConvert;


public class OrderFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] processedOrder = InputStringConvert.getOrderArray(FileInteract.readRawOrderFile(getContext()));
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollOrder);
        Button clearOrder = (Button) view.findViewById(R.id.clearOrderButton);
        clearOrder.setOnClickListener(this);

        for (int i = 0; i < processedOrder.length; i++) {
            String order = processedOrder[i];
            order = order.trim();
            if (!order.equals("")) {
                TextView orderTextView = new TextView(getContext());
                orderTextView.setText(order);
                orderTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                layout.addView(orderTextView);
                Button removeButton = new Button(getContext());
                removeButton.setText("Remove this Order");
                removeButton.setId(i);
                removeButton.setOnClickListener(this);
                layout.addView(removeButton);
            }
        }

        return view;
    }

    public void onClick(View v) {
        String[] processedOrder = InputStringConvert.getOrderArray(FileInteract.readRawOrderFile(getContext()));
        switch (v.getId()) {
            case R.id.clearOrderButton:
                FileInteract.clearOrder(getContext());
                Toast.makeText(getActivity(),"Order Cleared", Toast.LENGTH_SHORT).show();
                break;
            default:
                FileInteract.removeOrder(getContext(), processedOrder, v.getId());
                Toast.makeText(getActivity(),"Order Removed", Toast.LENGTH_SHORT).show();
                break;
        }
        Fragment newFragment = new OrderFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.commit();
    }

}
