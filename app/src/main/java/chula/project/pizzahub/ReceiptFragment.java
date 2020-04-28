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
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.Profile;

public class ReceiptFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receipt, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollReceipt);
        String[] receiptLines = FileInteract.readReceiptFile(getContext()).trim().split("\n");

        TextView storeTextView = new TextView(getContext());
        storeTextView.setText("-----------PizzaHub-----------" + "\n" + "    Thank you for ordering" + "\n" + "------------------------------");
        storeTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        storeTextView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.roboto_mono));
        layout.addView(storeTextView);

        Profile profile = FileInteract.loadProfile(getContext());
        TextView userTextView = new TextView(getContext());
        userTextView.setText("User: " + profile.getUserID());
        userTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        userTextView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.roboto_mono));
        layout.addView(userTextView);

        String receiptNo = receiptLines[receiptLines.length - 2].replace("Receipt:", "");
        TextView receiptNoTextView = new TextView(getContext());
        receiptNoTextView.setText("Receipt Number: " + receiptNo);
        receiptNoTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        receiptNoTextView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.roboto_mono));
        layout.addView(receiptNoTextView);

        String date = receiptLines[receiptLines.length - 3].replace("Date:", "");
        TextView dateTextView = new TextView(getContext());
        dateTextView.setText("Order Date: " + date);
        dateTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        dateTextView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.roboto_mono));
        layout.addView(dateTextView);

        String orderNo = receiptLines[receiptLines.length - 1].replace("OrderNumber:", "");
        TextView orderNoTextView = new TextView(getContext());
        orderNoTextView.setText("Order Number: " + orderNo);
        orderNoTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        orderNoTextView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.roboto_mono));
        layout.addView(orderNoTextView);


        TextView order1TextView = new TextView(getContext());
        order1TextView.setText("\nYour orders:\n\n     " + receiptLines[0]);
        order1TextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        order1TextView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.roboto_mono));
        layout.addView(order1TextView);

        for (int i = 1; i < receiptLines.length - 4; i++) {
            TextView orderTextView = new TextView(getContext());
            orderTextView.setText("     " + receiptLines[i]);
            orderTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            orderTextView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.roboto_mono));
            layout.addView(orderTextView);
        }

        double orderPrice = Double.parseDouble(receiptLines[receiptLines.length - 4].replace("Price:", ""));
        TextView priceTextView = new TextView(getContext());
        priceTextView.setText("\nTotal: " + orderPrice + "\n" + "------------------------------");
        priceTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        priceTextView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.roboto_mono));
        layout.addView(priceTextView);

        return view;
    }

}
