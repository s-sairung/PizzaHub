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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import chula.project.pizzahub.classes.DataTranfer;
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
        DataTranfer data = (DataTranfer) bundle.getSerializable("data");
        Profile profile = data.getProfile();
        Users users = data.getUsers();
        userID.setText(profile.getUserID());
        password.setText(profile.getPassword());
        cardNo.setText(profile.getCardNumber());
        return view;
    }

//    public static ProfileInfoFragment newInstance(Users users) {
//
//    }

}
