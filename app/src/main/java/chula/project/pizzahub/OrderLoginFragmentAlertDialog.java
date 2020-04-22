package chula.project.pizzahub;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class OrderLoginFragmentAlertDialog extends DialogFragment {

//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//
//        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//
//        builder.setTitle("Error");
//        builder.setMessage("Please login before checkout.");
//
////        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialogInterface, int i) {
////
////            }
////        });
////
////        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialogInterface, int i) {
////
////            }
////        });
//
//        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                builder.create().dismiss();
//            }
//        });
//
//        builder.show();
//
//        return super.onCreateDialog(savedInstanceState);


//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.dialog_order_login, container, false);
//            TextView okay = view.findViewById(R.id.order_action_ok);
//            okay.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    getDialog().dismiss();
//                }
//            });
//        return view;
//    }

    public static OrderLoginFragmentAlertDialog newInstance() {
        OrderLoginFragmentAlertDialog frag = new OrderLoginFragmentAlertDialog();
        Bundle args = new Bundle();
//        args.putInt("Error", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
//                .setIcon(R.drawable.alert_dialog_icon)
                .setTitle("Error")
                .setMessage("Please login before checkout.")
//                .setPositiveButton(R.string.alert_dialog_ok,
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int whichButton) {
//                                ((FragmentAlertDialog)getActivity()).doPositiveClick();
//                            }
//                        }
//                )
//                .setNegativeButton(R.string.alert_dialog_cancel,
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int whichButton) {
//                                ((FragmentAlertDialog)getActivity()).doNegativeClick();
//                            }
//                        }
//                )
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDialog().dismiss();
                    }
                })
                .create();
    }

}
