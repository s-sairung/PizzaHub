package chula.project.pizzahub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    ArrayList<Food> foodArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_others, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollOthers);
        ArrayList<String> categories = InputStringConvert.getOtherCategoriesArrayList(InputStringConvert.getCategories(FileInteract.readInputFile(getContext())));

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
                System.out.println(food);
                if (food instanceof FoodNoSize) {
                    Button button = new Button(getContext());
                    button.setText(((FoodNoSize) food).toButton());
                    button.setId(i*100+j*10);
                    button.setOnClickListener(this);
                    layout.addView(button);
                    foodArrayList.add(food);
                }
                else if (food instanceof FoodWithSize) {
                    FoodWithSize fws = (FoodWithSize) food;
                    String[] sizes = fws.getSizeNameArray();
                    for (int l = 0; l < sizes.length; l++) {
                        Button button = new Button(getContext());
                        button.setText(fws.toButton(sizes[l], (fws.getPrice(sizes[l]))));
                        button.setId(i*100+j*10+l);
                        button.setOnClickListener(this);
                        layout.addView(button);
                        foodArrayList.add(food);
                    }
                }
            }
        }
        return view;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case 0:
                if (foodArrayList.get(0) instanceof FoodNoSize) {
                    FoodNoSize fns = (FoodNoSize) foodArrayList.get(0);
                    FileInteract.addNewOrder(getContext(), (fns.toOrder(fns.getCategory())));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            case 10:
                if (foodArrayList.get(1) instanceof FoodNoSize) {
                    FoodNoSize fns = (FoodNoSize) foodArrayList.get(1);
                    FileInteract.addNewOrder(getContext(), (fns.toOrder(fns.getCategory())));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            case 100:
                if (foodArrayList.get(2) instanceof FoodNoSize) {
                    FoodNoSize fns = (FoodNoSize) foodArrayList.get(2);
                    FileInteract.addNewOrder(getContext(), (fns.toOrder(fns.getCategory())));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            case 110:
                if (foodArrayList.get(3) instanceof FoodNoSize) {
                    FoodNoSize fns = (FoodNoSize) foodArrayList.get(3);
                    FileInteract.addNewOrder(getContext(), (fns.toOrder(fns.getCategory())));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            case 120:
                if (foodArrayList.get(4) instanceof FoodNoSize) {
                    FoodNoSize fns = (FoodNoSize) foodArrayList.get(4);
                    FileInteract.addNewOrder(getContext(), (fns.toOrder(fns.getCategory())));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            case 200:
                if (foodArrayList.get(5) instanceof FoodNoSize) {
                    FoodNoSize fns = (FoodNoSize) foodArrayList.get(5);
                    FileInteract.addNewOrder(getContext(), (fns.toOrder(fns.getCategory())));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            case 210:
                if (foodArrayList.get(6) instanceof FoodNoSize) {
                    FoodNoSize fns = (FoodNoSize) foodArrayList.get(6);
                    FileInteract.addNewOrder(getContext(), (fns.toOrder(fns.getCategory())));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            case 220:
                if (foodArrayList.get(7) instanceof FoodNoSize) {
                    FoodNoSize fns = (FoodNoSize) foodArrayList.get(7);
                    FileInteract.addNewOrder(getContext(), (fns.toOrder(fns.getCategory())));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            case 300:
                if (foodArrayList.get(8) instanceof FoodWithSize) {
                    FoodWithSize fws = (FoodWithSize) foodArrayList.get(8);
                    FileInteract.addNewOrder(getContext(), (fws.toOrder(fws.getCategory(), "0.5L", 15.0)));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            case 301:
                if (foodArrayList.get(9) instanceof FoodWithSize) {
                    FoodWithSize fws = (FoodWithSize) foodArrayList.get(9);
                    FileInteract.addNewOrder(getContext(), (fws.toOrder(fws.getCategory(), "1L", 20.0)));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            case 310:
                if (foodArrayList.get(10) instanceof FoodWithSize) {
                    FoodWithSize fws = (FoodWithSize) foodArrayList.get(10);
                    FileInteract.addNewOrder(getContext(), (fws.toOrder(fws.getCategory(), "0.5L", 15.0)));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            case 311:
                if (foodArrayList.get(11) instanceof FoodWithSize) {
                    FoodWithSize fws = (FoodWithSize) foodArrayList.get(11);
                    FileInteract.addNewOrder(getContext(), (fws.toOrder(fws.getCategory(), "1L", 20.0)));
                    Toast.makeText(getActivity(),"Added to Order", Toast.LENGTH_SHORT).show();
                }
                break;
            default: break;
        }

    }

}
