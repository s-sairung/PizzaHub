package chula.project.pizzahub;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

    private ArrayList<Food> foodArrayList = new ArrayList<>();
    private ArrayList<Integer> idList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_others, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollOthers);
        ArrayList<String> categories = InputStringConvert.getOtherCategoriesArrayList(InputStringConvert.getCategories(FileInteract.readInputFile(getContext())));

        for (int i = 0; i < categories.size(); i++) {
            String specificCat = InputStringConvert.getSpecificFood(InputStringConvert.getFood(FileInteract.readInputFile(getContext())), categories.get(i));
            ArrayList<Food> foods = InputStringConvert.getSpecificFoodArrayList(specificCat);
            TextView tv = new TextView(getContext());
            tv.setText("        " + categories.get(i));
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
            layout.addView(tv);
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
                    FoodNoSize fns = (FoodNoSize) food;
                    FoodNoSize fns2 = new FoodNoSize(fns.getName(), fns.getTime(), fns.getPrice());
                    Button button = new Button(getContext());
                    button.setText(fns2.toButton());
                    button.setId(i*100+j*10);
                    button.setOnClickListener(this);
                    layout.addView(button);
                    foodArrayList.add(fns2);
                    idList.add(i*100+j*10);
                }
                else if (food instanceof FoodWithSize) {
                    FoodWithSize fws = (FoodWithSize) food;
                    String[] sizes = fws.getSizeNameArray();
                    for (int l = 0; l < sizes.length; l++) {
                        FoodWithSize fws2 = new FoodWithSize(fws.getName());
                        fws2.addSize(sizes[l], fws.getTime(sizes[l]), fws.getPrice(sizes[l]));
                        Button button = new Button(getContext());
                        button.setText(fws2.toButton(sizes[l], (fws2.getPrice(sizes[l]))));
                        button.setId(i*100+j*10+l);
                        button.setOnClickListener(this);
                        layout.addView(button);
                        foodArrayList.add(fws2);
                        idList.add(i*100+j*10+l);
                    }
                }
            }
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        addOrder(v.getId());
        Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
    }

    private void addOrder(int butIdCase) {
        for (int i = 0; i < idList.size(); i++) {
            if (idList.get(i) == butIdCase) {
                if (foodArrayList.get(i) instanceof FoodNoSize) {
                    FoodNoSize fns = (FoodNoSize) foodArrayList.get(i);
                    FileInteract.addNewOrder(getContext(), (fns.toOrder(fns.getCategory())));
                    break;
                }
                else {
                    FoodWithSize fws = (FoodWithSize) foodArrayList.get(i);
                    FileInteract.addNewOrder(getContext(), (fws.toOrder(fws.getCategory(), fws.getSizeNameArray()[0], fws.getPrice(fws.getSizeNameArray()[0]))));
                    break;
                }
            }
        }
    }

}
