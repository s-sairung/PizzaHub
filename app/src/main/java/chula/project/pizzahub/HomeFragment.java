package chula.project.pizzahub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import chula.project.pizzahub.PizzaFragment;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_home, container, false);
    }
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageButtonFlash:
//                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileSignupFragment()).commit();
                    Fragment newFragment =  PizzaFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, newFragment);
//                transaction.addToBackStack(null);
                    transaction.commit();
                    break;
            }
        }
    }
}
