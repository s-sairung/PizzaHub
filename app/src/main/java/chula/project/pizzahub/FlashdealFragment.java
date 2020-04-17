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
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.InputStringConvert;
import chula.project.pizzahub.classes.SetMenu;

public class FlashdealFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flashdeal, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollFlashDeal);

        final SetMenu setMenu = InputStringConvert.getSetMenuSetMenu(InputStringConvert.getSetMenuString(FileInteract.readInputFile(getContext()), "Flash Deal"));
        ArrayList<String> names = setMenu.getAllFoodName();
        ArrayList<String> size = setMenu.getFoodSizeWithDup();

        for (int i = 0; i < names.size(); i++) {
            TextView tv = new TextView(getContext());
            String text = names.get(i) + " " + size.get(i);
            tv.setText(text);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
            layout.addView(tv);
        }

        TextView tv2 = new TextView(getContext());
        tv2.setText("Only " + setMenu.getPrice() + " Baht!!");
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        tv2.setTypeface(tv2.getTypeface(), Typeface.BOLD_ITALIC);
        layout.addView(tv2);
        Button addToCart = new Button(getContext());
        addToCart.setText("Add To Order");
        layout.addView(addToCart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FileInteract.addNewOrder(getContext(), setMenu);
                FileInteract.addNewOrder(getContext(), setMenu.toString());
//                Fragment newFragment = new OrderFragment();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, newFragment);
//                transaction.commit();
            }
        });
        return view;
    }

}
