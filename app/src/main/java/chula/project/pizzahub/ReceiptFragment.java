package chula.project.pizzahub;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.Profile;

public class ReceiptFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receipt, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollReceipt);

        Profile profile = FileInteract.loadProfile(getContext());
        TextView userTextView = new TextView(getContext());
        userTextView.setText("User: " + profile.getUserID());
        userTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        userTextView.setTypeface(userTextView.getTypeface(), Typeface.BOLD_ITALIC);
        layout.addView(userTextView);

        String[] receiptLines = FileInteract.readReceiptFile(getContext()).trim().split("\n");

        TextView order1TextView = new TextView(getContext());
        order1TextView.setText("\n" + receiptLines[0]);
        order1TextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        layout.addView(order1TextView);

        for (int i = 1; i < receiptLines.length - 4; i++) {
            TextView orderTextView = new TextView(getContext());
            orderTextView.setText(receiptLines[i]);
            orderTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            layout.addView(orderTextView);
        }

        double orderPrice = Double.parseDouble(receiptLines[receiptLines.length - 3].replace("Price:", ""));
        TextView priceTextView = new TextView(getContext());
        priceTextView.setText("\nTotal: " + orderPrice);
        priceTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        priceTextView.setTypeface(priceTextView.getTypeface(), Typeface.BOLD);
        layout.addView(priceTextView);

        String date = receiptLines[receiptLines.length - 2].replace("Date:", "");
        TextView dateTextView = new TextView(getContext());
        dateTextView.setText("Order Date: " + date);
        dateTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        dateTextView.setTypeface(dateTextView.getTypeface(), Typeface.BOLD);
        layout.addView(dateTextView);

        String receiptNo = receiptLines[receiptLines.length - 1].replace("Receipt:", "");
        TextView receiptNoTextView = new TextView(getContext());
        receiptNoTextView.setText("Receipt Number: " + receiptNo);
        receiptNoTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        receiptNoTextView.setTypeface(receiptNoTextView.getTypeface(), Typeface.BOLD);
        layout.addView(receiptNoTextView);



        return view;
    }

}
