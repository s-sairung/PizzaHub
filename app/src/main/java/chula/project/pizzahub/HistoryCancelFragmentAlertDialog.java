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
    private static String[] receiptNumbersArray;
    private static int historyViewId;
    private static String orderNumber;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setHistoryOrderNumber();

        return new AlertDialog.Builder(getActivity())
                .setTitle("Notice")
                .setMessage("Cancel Order " + orderNumber + "?")
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                FileInteract.addNewCancelled(getContext(), historyArray[historyArray.length - 1 - historyViewId]);
                                FileInteract.removeHistory(getContext(), historyArray, historyArray.length - 1 - historyViewId);
                                FileInteract.removeReceiptNumber(getContext(), receiptNumbersArray, receiptNumbersArray.length - 1 - historyViewId);
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
        receiptNumbersArray = curReceiptNumbersArray;
    }

    private static void setHistoryOrderNumber() {
        String history = historyArray[historyArray.length - 1 - historyViewId];
        String[] historyLines = history.split("\n");
        orderNumber = historyLines[historyLines.length - 1].replace("OrderNumber:", "");
    }


}
