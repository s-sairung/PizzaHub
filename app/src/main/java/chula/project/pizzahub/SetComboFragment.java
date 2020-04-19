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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.InputStringConvert;
import chula.project.pizzahub.classes.SetMenu;

public class SetComboFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setcombo, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollSetCombo);

        for (int s = 1; s < 5; s++) {
            String set = "Combo Set " + s + ":";
            final SetMenu setMenu = InputStringConvert.getSetMenuSetMenu(InputStringConvert.getSetMenuString(FileInteract.readInputFile(getContext()), set));
            ArrayList<String> names = setMenu.getAllFoodName();
            ArrayList<String> size = setMenu.getFoodSizeWithDup();
            if (!names.isEmpty()) {
                TextView setNo = new TextView(getContext());
                setNo.setText(set);
                setNo.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                setNo.setTypeface(setNo.getTypeface(), Typeface.BOLD_ITALIC);
                layout.addView(setNo);
                TextView thisSetC = new TextView(getContext());
                thisSetC.setText("This set contains:");
                thisSetC.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                layout.addView(thisSetC);
                for (int i = 0; i < names.size(); i++) {
                    TextView contain = new TextView(getContext());
                    String text = names.get(i) + " " + size.get(i);
                    contain.setText(text);
                    contain.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    contain.setTypeface(contain.getTypeface(), Typeface.BOLD);
                    layout.addView(contain);
                }
                TextView price = new TextView(getContext());
                price.setText("Price: " + setMenu.getPrice());
                price.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                price.setTypeface(price.getTypeface(), Typeface.ITALIC);
                layout.addView(price);
                Button addToCart = new Button(getContext());
                addToCart.setText("Add To Order");
                layout.addView(addToCart);
                addToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FileInteract.addNewOrder(getContext(), setMenu.toOrder());
                        Toast.makeText(getActivity(), "Added to Order", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        return view;
    }
}