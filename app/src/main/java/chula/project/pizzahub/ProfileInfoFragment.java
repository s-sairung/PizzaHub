package chula.project.pizzahub;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Random;

import chula.project.pizzahub.classes.DataTranfer;
import chula.project.pizzahub.classes.FileInteract;
import chula.project.pizzahub.classes.InputStringConvert;
import chula.project.pizzahub.classes.Profile;
import chula.project.pizzahub.classes.Users;

public class ProfileInfoFragment extends Fragment {

    ImageView imageView;
    Button button;
    Random r;
    int[] images = {
            R.drawable.dog1,
            R.drawable.dog2,
            R.drawable.cat1,
            R.drawable.cat2,
            R.drawable.cat3
    };
    int pickedImage,lastPicked;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile_info, container, false);
        final Profile profile = FileInteract.loadProfile(getContext());
        TextView userID = (TextView) view.findViewById(R.id.showUserIDtextView);
        TextView password = (TextView) view.findViewById(R.id.showPasswordTextView);
        TextView cardNo = (TextView) view.findViewById(R.id.showCardTextView);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[FileInteract.loadProfilePicture(getContext())]);
        r = new Random();
        ImageButton randomButtom = (ImageButton) view.findViewById(R.id.randomImageButton);
        randomButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do {
                    pickedImage = r.nextInt(images.length);
                } while(pickedImage == lastPicked);
                lastPicked = pickedImage;
                imageView.setImageResource(images[pickedImage]);
                FileInteract.saveProfileWithPicture(getContext(), profile, pickedImage);
            }
        });
//        button = (Button) view.findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//              public void onClick(View v){
//                do{
//                    pickedImage = r.nextInt(images.length);
//                } while(pickedImage == lastPicked);
//                lastPicked = pickedImage;
//                imageView.setImageResource(images[pickedImage]);
//                FileInteract.saveProfileWithPicture(getContext(), profile, pickedImage);
//            }
//
//        });

        userID.setText(profile.getUserID());
        password.setText(InputStringConvert.convertStar(profile.getPassword()));
        cardNo.setText(profile.getCardNumber());
        Button logoutButton = (Button) view.findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new ProfileLoginFragment();
                Toast.makeText(getActivity(),"Logout Successful", Toast.LENGTH_SHORT).show();
                FileInteract.clearProfile(getContext());
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.commit();
            }
        });
        return view;
    }

}
