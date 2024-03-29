package chula.project.pizzahub;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.InputStringConvert;


public class OrderFragment extends Fragment implements View.OnClickListener {

    private String[] processedOrder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollOrder);
        processedOrder = InputStringConvert.getOrderArray(FileInteract.readRawOrderFile(getContext()));
        Button checkout = (Button) view.findViewById(R.id.checkoutButton);
        checkout.setOnClickListener(this);
        Button clearOrder = (Button) view.findViewById(R.id.clearOrderButton);
        clearOrder.setOnClickListener(this);

        for (int i = 0; i < processedOrder.length; i++) {
            String order = processedOrder[i];
            order = order.trim();
            if (!order.equals("")) {
                String[] orderSplit = order.split("\n");
                TextView topicTextView = new TextView(getContext());
                topicTextView.setText(orderSplit[0]);
                topicTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                topicTextView.setTypeface(topicTextView.getTypeface(), Typeface.BOLD_ITALIC);
                layout.addView(topicTextView);
                for (int j = 1; j < orderSplit.length - 1; j++) {
                    TextView orderTextView = new TextView(getContext());
                    orderTextView.setText(orderSplit[j]);
                    orderTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    layout.addView(orderTextView);
                }
                double orderPrice = Double.parseDouble(orderSplit[orderSplit.length - 1].replace("B", ""));
                TextView priceTextView = new TextView(getContext());
                priceTextView.setText("Price: " + orderPrice);
                priceTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                priceTextView.setTypeface(priceTextView.getTypeface(), Typeface.BOLD);
                layout.addView(priceTextView);

                Button removeButton = new Button(getContext());
                removeButton.setText("Remove this Order");
                removeButton.setId(i);
                removeButton.setOnClickListener(this);
                layout.addView(removeButton);
            }
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment newFragment;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.checkoutButton:
                if (processedOrder.length != 0) {
                    if (Boolean.parseBoolean(FileInteract.loadLoginStatus(getContext()))) {
                        newFragment = new SummaryFragment();
                        transaction.addToBackStack(null);
                        break;
                    }
                    else {
                        newFragment = new OrderFragment();
                        DialogFragment alertDialog = new OrderLoginFragmentAlertDialog();
                        alertDialog.show(getFragmentManager(), "LoginAlert");
                        break;
                    }
                }
                else {
                        newFragment = new OrderFragment();
                        DialogFragment alertDialog = new OrderEmptyFragmentAlertDialog();
                        alertDialog.show(getFragmentManager(), "EmptyAlert");
                        break;
                }
            case R.id.clearOrderButton:
                newFragment = new OrderFragment();
                DialogFragment clearDialog = new OrderClearFragmentAlertDialog();
                clearDialog.show(getFragmentManager(), "ClearAlert");
                break;
            default:
                FileInteract.removeOrder(getContext(), processedOrder, v.getId());
                newFragment = new OrderFragment();
                Toast.makeText(getActivity(),"Order Removed", Toast.LENGTH_SHORT).show();
                break;
        }
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.commit();
    }

}
