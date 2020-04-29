package chula.project.pizzahub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.Profile;

public class ProfileSignupFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_signup, container, false);
        Button signupButton = (Button) view.findViewById(R.id.signupButton);
        Button goLoginButton = (Button) view.findViewById(R.id.goToLoginButton);
        final EditText userIDInput = (EditText) view.findViewById(R.id.userIDEditText2);
        final EditText passwordInput = (EditText) view.findViewById(R.id.passwordEditText2);
        final EditText cardNumberInput = (EditText) view.findViewById(R.id.cardEditText2);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = userIDInput.getText().toString();
                String password = passwordInput.getText().toString();
                String cardNumber = cardNumberInput.getText().toString();
                if (!userID.trim().isEmpty() && !password.trim().isEmpty()) {
                    Profile newProfile = new Profile(userID, password, cardNumber);
                    FileInteract.addNewUserAccount(getContext(), newProfile);
                    FileInteract.saveLoginStatus(getContext(), true);
                    Fragment newFragment = new ProfileLoginFragment();
                    Toast.makeText(getActivity(),"Signup Successful", Toast.LENGTH_SHORT).show();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, newFragment);
                    transaction.commit();
                }
            }
        });

        goLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new ProfileLoginFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.commit();
            }
        });

        return view;
    }

}
