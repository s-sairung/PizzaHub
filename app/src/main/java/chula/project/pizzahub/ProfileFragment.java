package chula.project.pizzahub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Button registerButton = (Button) view.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerButton:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileRegisterFragment()).commit();
//                getFragmentManager().beginTransaction().addToBackStack(null);
//                getFragmentManager().beginTransaction().commit();
                break;
        }
    }

}
