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
import chula.project.pizzahub.classes.CheckLogin;
import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.Profile;

public class ProfileLoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile_login, container, false);
        Button goSignupButton = (Button) view.findViewById(R.id.goToSignupButton);
        Button loginButton = (Button) view.findViewById(R.id.loginButton);
        final EditText userIDInput = (EditText) view.findViewById(R.id.userIDEditText);
        final EditText passwordInput = (EditText) view.findViewById(R.id.passwordEditText);

        goSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new ProfileSignupFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.commit();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = userIDInput.getText().toString();
                String password = passwordInput.getText().toString();
                if (CheckLogin.checkLogin(userID, password, getContext())) {
                    Profile newProfile = new Profile(userID, password);
                    FileInteract.saveProfile(getContext(), newProfile);
                    FileInteract.saveLoginStatus(getContext(), true);
                    Toast.makeText(getActivity(),"Login Successful", Toast.LENGTH_SHORT).show();
                    Fragment newFragment = new ProfileInfoFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, newFragment);
                    transaction.commit();
                }
                else {
                    Toast.makeText(getActivity(),"Incorrect Login Credential", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
