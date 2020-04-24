package chula.project.pizzahub;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.InputStringConvert;

public class SummaryFragment extends Fragment implements View.OnClickListener {

    private double totalPrice;

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
                String[] orderSplit = order.split("\n");
                TextView topicTextView = new TextView(getContext());
                topicTextView.setText(orderSplit[0]);
                topicTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                topicTextView.setTypeface(topicTextView.getTypeface(), Typeface.BOLD_ITALIC);
                layout.addView(topicTextView);
                for (int j = 1; j < orderSplit.length; j++) {
                    TextView orderTextView = new TextView(getContext());
                    orderTextView.setText(orderSplit[j]);
                    orderTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    layout.addView(orderTextView);
                }
                totalPrice += Double.parseDouble(orderSplit[orderSplit.length - 1].replace("B", ""));
            }
        }

        TextView priceTextView = new TextView(getContext());
        priceTextView.setText("\nTotal: ฿" + totalPrice);
        priceTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        priceTextView.setTypeface(priceTextView.getTypeface(), Typeface.BOLD);
        layout.addView(priceTextView);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c);
        TextView timeTextView = new TextView(getContext());
        timeTextView.setText("Date: " + formattedDate);
        timeTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        timeTextView.setTypeface(timeTextView.getTypeface(), Typeface.BOLD);
        layout.addView(timeTextView);

        Button confirmButton = (Button) view.findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(this);

//          Button confirmButton = new Button(getContext());
//          confirmButton.setText("Confirm and Pay");
//          confirmButton.setOnClickListener(this);
//          layout.addView(confirmButton);

        return view;
    }

    public void onClick(View v) {
        Fragment newFragment;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.confirmButton:
                newFragment = new ReceiptFragment();
                FileInteract.addNewHistory(getContext(), FileInteract.readRawOrderFile(getContext()));
                FileInteract.clearOrder(getContext());
                break;
            default: newFragment = new SummaryFragment(); break;
        }
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.commit();
    }

}
