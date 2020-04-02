package chula.project.pizzahub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import chula.project.pizzahub.classes.Profile;
import chula.project.pizzahub.classes.Users;

public class ProfileInfoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_info, container, false);
        TextView userID = (TextView) view.findViewById(R.id.showUserIDtextView);
        TextView password = (TextView) view.findViewById(R.id.showPasswordTextView);
        TextView cardNo = (TextView) view.findViewById(R.id.showCardTextView);
        Bundle bundle = getArguments();
        Users users = (Users) bundle.getSerializable("users");
        Profile profile1 = users.getProfilesList().get(0);
        userID.setText(profile1.getUserID());
        password.setText(profile1.getPassword());
        cardNo.setText(profile1.getCardNumber());
        return view;
    }

}
