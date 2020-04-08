package chula.project.pizzahub;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import chula.project.pizzahub.classes.DataTranfer;
import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.Profile;
import chula.project.pizzahub.classes.Users;

public class ProfileSignupFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_signup, container, false);
        Button signupButton = (Button) view.findViewById(R.id.signupButton);
        final EditText userIDInput = (EditText) view.findViewById(R.id.userIDEditText2);
        final EditText passwordInput = (EditText) view.findViewById(R.id.passwordEditText2);
        final EditText cardNumberInput = (EditText) view.findViewById(R.id.cardEditText2);
//        signupButton.setOnClickListener(this);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userID = userIDInput.getText().toString();
                String password = passwordInput.getText().toString();
                String cardNumber = cardNumberInput.getText().toString();
                Profile newProfile = new Profile(userID, password, cardNumber);
                Users users = new Users();
                users.addProfile(newProfile);
                DataTranfer dt = new DataTranfer(users, newProfile);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", dt);
                Fragment newFragment = new ProfileInfoFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                newFragment.setArguments(bundle);
                transaction.commit();
            }
        });
        return view;
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.signupButton:
//                Fragment newFragment = new ProfileSignupFragment();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, newFragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
//                break;
//        }
//    }


}
