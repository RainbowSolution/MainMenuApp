package com.alpha.mainmenu.restaurant_pkg.Menu_details_pkg;

import android.view.View;
import android.widget.TextView;

import com.alpha.mainmenu.R;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ArtistViewHolder extends ChildViewHolder {

  private TextView childTextView;

  public ArtistViewHolder(View itemView) {
    super(itemView);
    childTextView = (TextView) itemView.findViewById(R.id.list_item_artist_name);
  }

  public void setArtistName(String name) {
    childTextView.setText(name);
  }
}
