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

public class ReceiptFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receipt, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollReceipt);

        TextView rawReceiptTextView = new TextView(getContext());
        rawReceiptTextView.setText(FileInteract.readReceiptFile(getContext()));
        layout.addView(rawReceiptTextView);

        return view;
    }

}
