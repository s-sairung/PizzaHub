package chula.project.pizzahub;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.Food;
import chula.project.pizzahub.classes.InputStringConvert;

public class PizzaFragment extends Fragment{

    private ArrayList<Food> foodArrayList = new ArrayList<>();
    private ArrayList<Integer> idList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pizza, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollPizza);
        ArrayList<Food> pizza = InputStringConvert.getSpecificFoodArrayList(InputStringConvert.getSpecificFood(InputStringConvert.getFood(FileInteract.readInputFile(getContext())), "Pizza"));
        for (int i = 0; i < pizza.size(); i++) {
            TextView tv = new TextView(getContext());
            tv.setText("        " + pizza.get(i).getName());
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
            layout.addView(tv);
            ImageView image = new ImageView(getContext());
            switch (pizza.get(i).getName()) {
                case "pizza-hawaiian": image.setImageResource(R.drawable.hawaiian); break;
                case "pizza-bbq-chicken": image.setImageResource(R.drawable.bbqchicken); break;
                default: image.setImageResource(R.drawable.pizzdefault); break;
            }
            layout.addView(image);
        }

        return view;
    }
}
