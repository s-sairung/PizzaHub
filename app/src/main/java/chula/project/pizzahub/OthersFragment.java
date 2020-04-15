package chula.project.pizzahub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.InputStringConvert;

public class OthersFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_others, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollOthers);
        ArrayList<String> categories = InputStringConvert.getOtherCategoriesArrayList(InputStringConvert.getCategories(FileInteract.readInputFile(getContext())));

        for (int i = 0; i < categories.size(); i++) {
            ImageView image = new ImageView(getContext());
            switch (categories.get(i)) {
                case "Drinks": image.setImageResource(R.drawable.catodrinks); break;
                case "Pasta": image.setImageResource(R.drawable.catopasta); break;
                case "French Fries": image.setImageResource(R.drawable.catofrenchfries); break;
                case "Chicken Wings": image.setImageResource(R.drawable.catochickenwings); break;
                default: image.setImageResource(R.drawable.catodefault); break;
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

    }

}
