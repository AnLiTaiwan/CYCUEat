package com.example.cycueat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import com.example.threecountryeat.R;

import db.ItemDAO;
import db.RecordDAO;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FindEatWhat extends ActionBarActivity {
  
  private Bundle foods ;
  private TextView food1 ;
  private TextView food1boss ;
  private TextView food1price ;
  private TextView food2 ;
  private TextView food2boss ;
  private TextView food2price ;
  private ArrayList<String> food1List ;
  private ArrayList<String> food2List ;
  private Button changeFood ;
  private Button eat ;
  private OnClickListener changeFoodLis = new OnClickListener() {

    @Override
    public void onClick(View v) {
      Intent rtnGo = new Intent() ;
      rtnGo.setClass( getApplicationContext(), SeeEatChoose.class ) ;
      Bundle bundle = new Bundle() ; // 砞﹚肚癳把计
      bundle.putString( "status", "reChoose" ) ;
      rtnGo.putExtras( bundle ) ;
      setResult( RESULT_OK, rtnGo ) ;
      finish();
    } // onClick()
    
  } ;
  
  private OnClickListener eatLis = new OnClickListener() {

    @Override
    public void onClick(View v) {
      Vector<String> saveData = new Vector<String>() ;
      SimpleDateFormat sdf = new SimpleDateFormat( "EEE, dら  MMM yyyy HH:mm:ss Z" );
      Date date = new Date() ;
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      saveData.add( sdf.format( calendar.getTime() ) ) ;
      saveData.add( food1List.get( ItemDAO.PRICE ) ) ;
      saveData.add( food1List.get( ItemDAO.NAME ) ) ;
      saveData.add( food1List.get( ItemDAO.BOSS ) ) ;
      saveData.add( food2List.get( ItemDAO.PRICE ) ) ;
      saveData.add( food2List.get( ItemDAO.NAME ) ) ;
      saveData.add( food2List.get( ItemDAO.BOSS ) ) ;
      RecordDAO userDB = new RecordDAO( getApplicationContext() ) ;
      userDB.insert( saveData ) ;
      userDB.close() ;
      
      Intent rtnGo = new Intent() ;
      rtnGo.setClass( getApplicationContext(), SeeEatChoose.class ) ;
      Bundle bundle = new Bundle() ; // 砞﹚肚癳把计
      bundle.putString( "status", "ok" ) ;
      rtnGo.putExtras( bundle ) ;
      setResult( RESULT_OK, rtnGo ) ;
      finish();
    } // onClick()
    
  } ;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_find_eat_what);
    this.food1 = (TextView) findViewById( R.id.food1 ) ;
    this.food2 = (TextView) findViewById( R.id.food2 ) ;
    this.food1boss = (TextView) findViewById( R.id.food1boss ) ;
    this.food2boss = (TextView) findViewById( R.id.food2boss ) ;
    this.food1price = (TextView) findViewById( R.id.food1price ) ;
    this.food2price = (TextView) findViewById( R.id.food2price ) ;
    foods = this.getIntent().getExtras() ;
    this.food1List = foods.getStringArrayList( "food1" ) ;
    this.food2List = foods.getStringArrayList( "food2" ) ;
    food1.setText( food1List.get( ItemDAO.NAME ) ) ;
    food1boss.setText( food1List.get( ItemDAO.BOSS ) ) ;
    food1price.setText( food1List.get( ItemDAO.PRICE ) + " $" ) ;
    food2.setText( food2List.get( ItemDAO.NAME ) ) ;
    food2boss.setText( food2List.get( ItemDAO.BOSS ) ) ;
    food2price.setText( food2List.get( ItemDAO.PRICE ) + " $" ) ;
    
    changeFood = (Button) findViewById( R.id.changeBtn ) ;
    changeFood.setOnClickListener( changeFoodLis ) ;
    eat = (Button) findViewById( R.id.eatBtn ) ;
    eat.setOnClickListener( eatLis ) ;
  } // onCreate()

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.find_eat_what, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
