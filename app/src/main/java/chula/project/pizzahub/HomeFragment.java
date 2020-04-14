package chula.project.pizzahub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.InputStringConvert;

public class HomeFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //clear back stack
        FragmentManager fm = getActivity().getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.imageButtonFlash);
        imageButton.setOnClickListener(this);

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScroll);
        ArrayList<String> categories = InputStringConvert.getMainCategoriesArrayList(InputStringConvert.getCategories(FileInteract.readInputFile(getContext())));

//        for (int i = 0; i < 5; i++) {
//            Button button = new Button(getContext());
//            button.setId(i);
//            button.setText("Button No " + (i+1));
//            layout.addView(button);
//        }

        for (int i = 0; i < categories.size(); i++) {
            Button button = new Button(getContext());
            button.setId(i);
            button.setText(categories.get(i));
            layout.addView(button);
        }

        return view;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButtonFlash:
                Fragment newFragment = new SetComboFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case R.id.imageButtonOther:
                Fragment x = new PizzaFragment();
                FragmentTransaction y = getFragmentManager().beginTransaction();
                y.replace(R.id.fragment_container, x);
                y.addToBackStack(null);
                y.commit();
                break;
        }
    }
}
