package chula.project.pizzahub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.FragmentAssist;
import chula.project.pizzahub.classes.InputStringConvert;

public class HomeFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        //clear back stack
//        FragmentManager fm = getActivity().getSupportFragmentManager();
//        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
//            fm.popBackStack();
//        }

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.imageButtonFlash);
        imageButton.setOnClickListener(this);

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScroll);
        ArrayList<String> categories = InputStringConvert.getMainCategoriesArrayList(InputStringConvert.getCategories(FileInteract.readInputFile(getContext())));

        for (int i = 0; i < categories.size(); i++) {
            ImageView image = new ImageView(getContext());
            switch (categories.get(i)) { //ขนาดรูป 300x200 นะ ไปลองเปลี่ยนเป็นรูปปั่น ๆ ได้
                case "Pizza": image.setImageResource(R.drawable.catpizza); break;
                case "Others": image.setImageResource(R.drawable.catothers); break;
                case "Combo Set": image.setImageResource(R.drawable.catcombo); break;
                case "Family Set": image.setImageResource(R.drawable.catfamily); break;
                default: image.setImageResource(R.drawable.catdefault); break;
            }
            layout.addView(image);
            Button button = new Button(getContext());
            button.setId(i);
            button.setText(categories.get(i));
            button.setOnClickListener(this);
            layout.addView(button);
        }

        return view;
    }

    public void onClick(View v) {
        ArrayList<String> categories = InputStringConvert.getMainCategoriesArrayList(InputStringConvert.getCategories(FileInteract.readInputFile(getContext())));
        String category;
        Fragment newFragment;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.imageButtonFlash:
                newFragment = new FlashdealFragment();
                break;
            case R.id.imageButtonOther:
                newFragment = new PizzaFragment();
                break;
            case 0:
                category = categories.get(0);
                newFragment = FragmentAssist.getFragment(category);
                break;
            case 1:
                category = categories.get(1);
                newFragment = FragmentAssist.getFragment(category);
                break;
            case 2:
                category = categories.get(2);
                newFragment = FragmentAssist.getFragment(category);
                break;
            case 3:
                category = categories.get(3);
                newFragment = FragmentAssist.getFragment(category);
                break;
            case 4:
                category = categories.get(4);
                newFragment = FragmentAssist.getFragment(category);
                break;
            case 5:
                category = categories.get(5);
                newFragment = FragmentAssist.getFragment(category);
                break;
            default:
                newFragment = new OthersFragment();
                break;
        }
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
