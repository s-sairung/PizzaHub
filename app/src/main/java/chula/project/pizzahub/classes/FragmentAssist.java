package chula.project.pizzahub.classes;

import androidx.fragment.app.Fragment;

import chula.project.pizzahub.ComboFragment;
import chula.project.pizzahub.FamilyFragment;
import chula.project.pizzahub.OthersFragment;
import chula.project.pizzahub.PizzaFragment;

public class FragmentAssist {

    public static Fragment getFragment(String cat) {
        Fragment fragment;
        switch (cat) {
            case "Pizza": fragment = new PizzaFragment(); break;
            case "Others": fragment = new OthersFragment(); break;
            case "Combo Set": fragment = new ComboFragment(); break;
            case "Family Set": fragment = new FamilyFragment(); break;
            default: fragment = new OthersFragment(); break;
        }
        return fragment;
    }

}
