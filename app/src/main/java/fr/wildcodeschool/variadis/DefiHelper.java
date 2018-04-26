package fr.wildcodeschool.variadis;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by perrine on 09/04/18.
 */

public class DefiHelper {



    public static Dialog openDialogDefi(final Context context, String vegetal, String url, final LatLng location, final GoogleMap map) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View subView = inflater.inflate(R.layout.layout_popup, null);


        TextView defiTitle = subView.findViewById(R.id.congrats);
        TextView message = subView.findViewById(R.id.tv_message);
        ImageView vegetalImg = subView.findViewById(R.id.img_found_vegetal);
        TextView vegetalName = subView.findViewById(R.id.vegetal_name);
        Button goTo = subView.findViewById(R.id.btn_goto_vegetal);
        Button back = subView.findViewById(R.id.btn_quit);

        defiTitle.setText(R.string.nouveau_d_fi);
        message.setText(R.string.find_tree);
        Glide.with(context).load(url).into(vegetalImg);
        vegetalName.setText(vegetal);
        goTo.setText(R.string.visualiser_sur_la_carte);


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(subView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        goTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.moveCamera(CameraUpdateFactory.newLatLng(location));
                alertDialog.dismiss();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });

        return alertDialog;
    }



}
