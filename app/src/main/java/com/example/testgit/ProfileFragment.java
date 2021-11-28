package com.example.testgit;
import android.app.AlertDialog; import android.content.DialogInterface; import android.os.Bundle; import android.view.LayoutInflater; import android.view.View; import android.view.ViewGroup; import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable; import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    @Nullable     @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        Button submit = view.findViewById(R.id.submit);         MainActivity act = (MainActivity) getActivity();         submit.setOnClickListener(v -> {
            android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(requireContext());             alertDialogBuilder.setTitle("Login");             alertDialogBuilder
                    .setMessage("Login Successfull")
                    .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {

                            act.bottomNavigationView.setSelectedItemId(R.id.menu_home);
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();             alertDialog.show();
        });
        return view;
    }
}
