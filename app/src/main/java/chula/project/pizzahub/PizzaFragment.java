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
import chula.project.pizzahub.classes.FoodWithSize;
import chula.project.pizzahub.classes.InputStringConvert;

public class PizzaFragment extends Fragment implements View.OnClickListener {

    private ArrayList<Food> foodArrayList = new ArrayList<>();
    private ArrayList<Integer> idList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pizza, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layoutScrollPizza);
        ArrayList<Food> pizza = InputStringConvert.getSpecificFoodArrayList(InputStringConvert.getSpecificFood(InputStringConvert.getFood(FileInteract.readInputFile(getContext())), "Pizza"));
        for (int i = 0; i < pizza.size(); i++) {
            FoodWithSize piz = (FoodWithSize) pizza.get(i);
            TextView tv = new TextView(getContext());
            tv.setText("        " + piz.getName());
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
            layout.addView(tv);
            ImageView image = new ImageView(getContext());
            switch (piz.getName()) {
                case "pizza-hawaiian": image.setImageResource(R.drawable.hawaiian); break;
                case "pizza-bbq-chicken": image.setImageResource(R.drawable.bbqchicken); break;
                default: image.setImageResource(R.drawable.pizzdefault); break;
            }
            layout.addView(image);
            for (int j = 0; j < piz.getSizeArrayList().size(); j++) {
                Button button = new Button(getContext());
                String sizeName = piz.getSizeArrayList().get(j)[0];
                Double price = Double.parseDouble(piz.getSizeArrayList().get(j)[2]);
                button.setText(piz.toButton(sizeName, price));
                button.setId(i*10+j);
                button.setOnClickListener(this);
                layout.addView(button);
                FoodWithSize fws = new FoodWithSize(piz.getName());
                fws.addSize(sizeName, piz.getTime(sizeName), piz.getPrice(sizeName));
                foodArrayList.add(fws);
                idList.add(i*10+j);
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
                FoodWithSize fws = (FoodWithSize) foodArrayList.get(i);
                FileInteract.addNewOrder(getContext(), (fws.toOrder(fws.getCategory(), fws.getSizeNameArray()[0], fws.getPrice(fws.getSizeNameArray()[0]))));
                break;
            }
        }
    }

}
