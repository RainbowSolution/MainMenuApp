package com.alpha.mainmenu.restaurant_pkg.Menu_details_pkg;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alpha.mainmenu.R;

import com.alpha.mainmenu.cart_pkg.CartActivity;
import com.alpha.mainmenu.product_details.ProductDetailsActivity;
import com.alpha.mainmenu.restaurant_pkg.Activity_Restaurant_Details;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class FavoriteArtistViewHolder extends ChildViewHolder {

  private TextView favoriteArtistName;

  public FavoriteArtistViewHolder(View itemView, final Context context) {
    super(itemView);
    favoriteArtistName = (TextView) itemView.findViewById(R.id.list_item_favorite_artist_name);
    itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        context.startActivity(new Intent(context, ProductDetailsActivity.class));
      }
    });
  }

  public void setArtistName(String name) {
    favoriteArtistName.setText(name);
  }

}
