package com.example.cycueat;


import java.util.Vector;

import com.example.threecountryeat.R;

import db.RecordDAO;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


public class baseAdapter extends BaseAdapter {

  private RecordDAO db ;
  private Context con ;
  public baseAdapter(Context context ) {
    super() ;
    db = new RecordDAO( context ) ;
    con = context ;
  } // baseAdapter()
  
  @Override
  public int getCount() {
    // TODO Auto-generated method stub
    return db.getSize() ;
  }

  @Override
  public Object getItem(int position) {
    // TODO Auto-generated method stub
    return db.getAll().get( position ) ;
  }

  @Override
  public long getItemId(int position) {
    // TODO Auto-generated method stub
    return position ;
  }

  @Override
  public View getView(int position, View view, ViewGroup parent) {
    // TODO Auto-generated method stub
    view = LinearLayout.inflate( con, R.layout.udata, null) ;
    TextView date = (TextView) view.findViewById( R.id.date ) ;
    TextView food1 = (TextView) view.findViewById( R.id.food1 ) ;
    TextView price1 = (TextView) view.findViewById( R.id.price1 ) ;
    TextView boss1 = (TextView) view.findViewById( R.id.boss1 ) ;
    TextView food2 = (TextView) view.findViewById( R.id.food2 ) ;
    TextView price2 = (TextView) view.findViewById( R.id.price2 ) ;
    TextView boss2 = (TextView) view.findViewById( R.id.boss2 ) ;
    
    Vector< Vector<String> > data = db.getAll() ;
    date.setText( data.get( data.size() - 1 - position ).get( RecordDAO.DATE ) ) ;
    food1.setText( data.get( data.size() - 1 - position ).get( RecordDAO.NAME1 ) ) ;
    price1.setText( data.get( data.size() - 1 - position ).get( RecordDAO.PRICE1 ) ) ;
    boss1.setText( data.get( data.size() - 1 - position ).get( RecordDAO.BOSS1 ) ) ;
    food2.setText( data.get( data.size() - 1 - position ).get( RecordDAO.NAME2 ) ) ;
    price2.setText( data.get( data.size() - 1 - position ).get( RecordDAO.PRICE2 ) ) ;
    boss2.setText( data.get( data.size() - 1 - position ).get( RecordDAO.BOSS2 ) ) ;
    return view;
  }

} // class baseAdapter
