package com.alpha.mainmenu.user_account_pkg;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import com.alpha.mainmenu.R;
import com.alpha.mainmenu.authenticationModule.Splash_Activity;
import com.alpha.mainmenu.history_pkg.MyHistory_Activity;


public class AccountFragment  extends Fragment implements View.OnClickListener{
    LinearLayout li_history,li_language,li_contact,li_edit_profile;
    AppCompatButton btn_logout;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.account_fragment, container, false);
        init(v);
        return v;
    }
    public void init(View v ){
        li_history = v.findViewById(R.id.li_history);
        btn_logout = v.findViewById(R.id.btn_logout);
        li_language = v.findViewById(R.id.li_language);
        li_contact = v.findViewById(R.id.li_contact);
        li_edit_profile = v.findViewById(R.id.li_edit_profile);
        li_history.setOnClickListener(this);
        btn_logout.setOnClickListener(this);
        li_language.setOnClickListener(this);
        li_contact.setOnClickListener(this);
        li_edit_profile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.li_history:
                startActivity(new Intent(getActivity(), MyHistory_Activity.class));
                break;
            case R.id.btn_logout:
                Intent intent = new Intent(getContext(), Splash_Activity.class);
                startActivity(intent);
                getActivity().finishAffinity();
                break;
            case R.id.li_language:
                dialog_change_language();
                break;
            case R.id.li_contact:
                startActivity(new Intent(getActivity(), ContactActivity.class));
                break;
            case R.id.li_edit_profile:
                startActivity(new Intent(getActivity(), EditProfileActivity.class));
                break;
        }
    }

    public void dialog_change_language() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_change_language);
        dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        AppCompatImageView icon_cross = dialog.findViewById(R.id.ivlogoutCloseId);

        icon_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}
