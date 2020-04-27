package chula.project.pizzahub;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.InputStringConvert;

public class HistoryFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollHistory);

        String[] processedHistory = InputStringConvert.getHistoryArray(FileInteract.readRawHistoryFile(getContext()));
        for (int i = 0; i < processedHistory.length; i++) {
            String order = processedHistory[i];
            order = order.trim();
            if (!order.equals("")) {
                TextView topicTextView = new TextView(getContext());
                topicTextView.setText("Order No: " + (i + 1));
                topicTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                topicTextView.setTypeface(topicTextView.getTypeface(), Typeface.BOLD_ITALIC);
                layout.addView(topicTextView);
                String[] orderSplit = order.split("\n");
                for (int j = 0; j < orderSplit.length - 4; j++) {
                    TextView orderTextView = new TextView(getContext());
                    orderTextView.setText(orderSplit[j]);
                    orderTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    layout.addView(orderTextView);
                }

                double orderPrice = Double.parseDouble(orderSplit[orderSplit.length - 3].replace("Price:", ""));
                TextView priceTextView = new TextView(getContext());
                priceTextView.setText("Total: " + orderPrice);
                priceTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                priceTextView.setTypeface(priceTextView.getTypeface(), Typeface.BOLD);
                layout.addView(priceTextView);

                String date = orderSplit[orderSplit.length - 2].replace("Date:", "");
                TextView dateTextView = new TextView(getContext());
                dateTextView.setText("Order Date: " + date);
                dateTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                dateTextView.setTypeface(dateTextView.getTypeface(), Typeface.BOLD);
                layout.addView(dateTextView);

                String receiptNo = orderSplit[orderSplit.length - 1].replace("Receipt:", "");
                TextView receiptNoTextView = new TextView(getContext());
                receiptNoTextView.setText("Receipt Number: " + receiptNo);
                receiptNoTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                receiptNoTextView.setTypeface(receiptNoTextView.getTypeface(), Typeface.BOLD);
                layout.addView(receiptNoTextView);

                Button viewDetailsButton = new Button(getContext());
                viewDetailsButton.setText("View Details");
                viewDetailsButton.setId(i);
                viewDetailsButton.setOnClickListener(this);
                layout.addView(viewDetailsButton);
            }
        }

//        TextView rawHistory = new TextView(getContext());
//        rawHistory.setText(FileInteract.readRawHistoryFile(getContext()));
//        layout.addView(rawHistory);

        return view;
    }

    public void onClick(View v) {

    }

}
