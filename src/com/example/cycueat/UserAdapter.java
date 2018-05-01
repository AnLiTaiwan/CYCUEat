package com.example.cycueat;

import java.util.ArrayList;
import java.util.Vector;

import com.example.threecountryeat.R;

import db.ItemDAO;
import db.RecordDAO;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserAdapter extends BaseAdapter {

  private ItemDAO db ;
  private Context con ;
  public UserAdapter(Context context ) {
    super() ;
    db = new ItemDAO( context ) ;
    con = context ;
  } // UserAdapter()
  
  @Override
  public int getCount() {
    // TODO Auto-generated method stub
    return db.getSize() ;
  }

  @Override
  public Object getItem(int position) {
    // TODO Auto-generated method stub
    return db.getAllList().get( position ) ;
  }

  @Override
  public long getItemId(int position) {
    // TODO Auto-generated method stub
    return position ;
  }

  @Override
  public View getView(int position, View view, ViewGroup parent) {
    // TODO Auto-generated method stub
    view = LinearLayout.inflate( con, R.layout.defdata, null) ;
    TextView defdate = (TextView) view.findViewById( R.id.defdate ) ;
    TextView deffood = (TextView) view.findViewById( R.id.deffood ) ;
    TextView defprice = (TextView) view.findViewById( R.id.defprice ) ;
    TextView defboss = (TextView) view.findViewById( R.id.defboss ) ;
    TextView deftype = (TextView) view.findViewById( R.id.deftype ) ;
    
    Vector< ArrayList<String> > data = db.getAllList() ;
    defdate.setText( data.get( position ).get( ItemDAO.ID ) ) ;
    deffood.setText( data.get( position ).get( ItemDAO.NAME ) ) ;
    defprice.setText( data.get( position ).get( ItemDAO.PRICE ) ) ;
    defboss.setText( data.get( position ).get( ItemDAO.BOSS ) ) ;
    deftype.setText( data.get( position ).get( ItemDAO.TYPE ) ) ;
    return view;
  }

}
