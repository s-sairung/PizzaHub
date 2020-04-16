package chula.project.pizzahub;
import android.os.Bundle;
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

        SetMenu setMenu = InputStringConvert.getFlashDealSetMenu(InputStringConvert.getSetMenu(FileInteract.readInputFile(getContext())));
        ArrayList<String> names = setMenu.getAllFoodName();

        for (int i = 0; i < setMenu.getFoodAmount(); i++) {
            TextView tv = new TextView(getContext());
            tv.setText(names.get(i));
            layout.addView(tv);
        }

        Button addToCart = new Button(getContext());
        addToCart.setText("Add To Order");
        layout.addView(addToCart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new OrderFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.commit();
            }
        });
        return view;
    }

}
