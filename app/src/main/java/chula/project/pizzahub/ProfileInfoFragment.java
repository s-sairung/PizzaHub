package chula.project.pizzahub;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import chula.project.pizzahub.classes.DataTranfer;
import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.InputStringConvert;
import chula.project.pizzahub.classes.Profile;
import chula.project.pizzahub.classes.Users;

public class ProfileInfoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile_info, container, false);
        Profile profile = FileInteract.loadProfile(getContext());
        TextView userID = (TextView) view.findViewById(R.id.showUserIDtextView);
        TextView password = (TextView) view.findViewById(R.id.showPasswordTextView);
        TextView cardNo = (TextView) view.findViewById(R.id.showCardTextView);

        userID.setText(profile.getUserID());
        password.setText(InputStringConvert.convertStar(profile.getPassword()));
        cardNo.setText(profile.getCardNumber());
        Button logoutButton = (Button) view.findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
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
