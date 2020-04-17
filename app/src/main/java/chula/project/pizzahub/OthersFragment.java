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
import chula.project.pizzahub.classes.Food;
import chula.project.pizzahub.classes.FoodNoSize;
import chula.project.pizzahub.classes.FoodWithSize;
import chula.project.pizzahub.classes.InputStringConvert;

public class OthersFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_others, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollOthers);
        ArrayList<String> categories = InputStringConvert.getOtherCategoriesArrayList(InputStringConvert.getCategories(FileInteract.readInputFile(getContext())));
        System.out.println(categories);

        for (int i = 0; i < categories.size(); i++) {
            String specificCat = InputStringConvert.getSpecificFood(InputStringConvert.getFood(FileInteract.readInputFile(getContext())), categories.get(i));
            ArrayList<Food> foods = InputStringConvert.getSpecificFoodArrayList(specificCat);
            ImageView image = new ImageView(getContext());
            switch (categories.get(i)) {
                case "Drinks": image.setImageResource(R.drawable.catodrinks); break;
                case "Pasta": image.setImageResource(R.drawable.catopasta); break;
                case "French Fries": image.setImageResource(R.drawable.catofrenchfries); break;
                case "Chicken Wings": image.setImageResource(R.drawable.catochickenwings); break;
                default: image.setImageResource(R.drawable.catodefault); break;
            }
            layout.addView(image);
            for (int j = 0; j < foods.size(); j++) {
                Food food = foods.get(j);
                if (food instanceof FoodNoSize) {
                    Button button = new Button(getContext());
                    button.setText(((FoodNoSize) food).toButton());
                    button.setId(i*100+j*10);
                    System.out.println(i*100+j*10);
                    button.setOnClickListener(this);
                    layout.addView(button);
                }
                else if (food instanceof FoodWithSize) {
                    FoodWithSize fws = (FoodWithSize) food;
                    String[] sizes = fws.getSizeNameArray();
                    for (int l = 0; l < sizes.length; l++) {
                        Button button = new Button(getContext());
                        button.setText(fws.toButton(sizes[l], (fws.getPrice(sizes[l]))));
                        button.setId(i*100+j*10+l);
                        System.out.println(i*100+j*10+l);
                        button.setOnClickListener(this);
                        layout.addView(button);
                    }
                }
            }
        }
        return view;
    }

    public void onClick(View v) {

    }

}
