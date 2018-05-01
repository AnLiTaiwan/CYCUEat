package com.example.cycueat;

import com.example.threecountryeat.R;

import db.RecordDAO;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class UserRecord extends Activity {

  private Button backBtn ;
  private ListView recordData ;
  
  private OnClickListener backLis = new OnClickListener() {

    @Override
    public void onClick(View v) {
      finish() ;
    } // onClick()
    
  } ;
  
  private OnItemClickListener listVLis = new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
      Builder alert = new Builder( UserRecord.this ) ;
      alert.setTitle( "好吃嗎?") ;
      alert.setMessage( "滿足了，要把紀錄刪除嗎?" ) ;
      alert.setIcon( R.drawable.ic_launcher ) ;
      alert.setPositiveButton( "繼續回味", new DialogInterface.OnClickListener() {

          @Override
          public void onClick(DialogInterface dialog, int which) {
            // grandpa say : nothing to do~  
          } // onClick()
        } // OnClickListener()
      ) ;
      alert.setNegativeButton( "刪除", new DialogInterface.OnClickListener() {

          @Override
          public void onClick(DialogInterface dialog, int which) {
             
            TextView tView = (TextView) view.findViewById( R.id.date ) ;
            RecordDAO db = new RecordDAO( UserRecord.this ) ;
            db.delete( tView.getText().toString() ) ;
            db.close();
            recordData.setAdapter( new baseAdapter( getApplicationContext() ) ) ;

          } // onClick()
        } // OnClickListener()
      ) ;
      
      alert.show() ;
    } // onItemClick()
    
  } ; // listVLis
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_record);
    backBtn = (Button) findViewById( R.id.backBtn ) ;
    backBtn.setOnClickListener( backLis ) ;
    recordData = (ListView) findViewById( R.id.recordData ) ;
    recordData.setAdapter( new baseAdapter( getApplicationContext() ) ) ;
    recordData.setOnItemClickListener( listVLis ) ;
  } // onCreate()
} // class UserRecord
