package chula.project.pizzahub;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import chula.project.pizzahub.classes.FileInteract;

public class HistoryCancelFragmentAlertDialog extends DialogFragment {

    private static String[] historyArray;
    private static String[] historyReceiptNumbersArray;
    private static int historyViewId;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setTitle("Notice")
                .setMessage("Cancel this order?")
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                FileInteract.removeHistory(getContext(), historyArray, historyArray.length - 1 - historyViewId);
                                FileInteract.removeReceiptNumber(getContext(), historyReceiptNumbersArray, historyReceiptNumbersArray.length - 1 - historyViewId);
                                Toast.makeText(getActivity(),"Order Cancelled", Toast.LENGTH_SHORT).show();
                                Fragment newFragment = new HistoryFragment();
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.replace(R.id.fragment_container, newFragment);
                                transaction.commit();
                            }
                        }
                )
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                getDialog().dismiss();
                            }
                        }
                )
                .create();
    }

    public static void setHistoryArray(String[] curHistoryArray) {
        historyArray = curHistoryArray;
    }

    public static void setHistoryViewId(int viewId) {
        historyViewId = viewId;
    }

    public static void setHistoryReceiptNumbersArray(String[] curReceiptNumbersArray) {
        historyReceiptNumbersArray = curReceiptNumbersArray;
    }


}
