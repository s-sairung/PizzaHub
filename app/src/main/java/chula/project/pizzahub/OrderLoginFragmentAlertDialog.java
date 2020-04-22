package chula.project.pizzahub;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class OrderLoginFragmentAlertDialog extends DialogFragment {

    public static OrderLoginFragmentAlertDialog newInstance() {
        return new OrderLoginFragmentAlertDialog();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setTitle("Error")
                .setMessage("Please login before checkout.")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDialog().dismiss();
                    }
                })
                .create();
    }

}
