package com.example.cycueat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

import com.example.threecountryeat.R;

import db.ItemDAO;
import db.MyDBHelper;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class SeeEatChoose extends ActionBarActivity {

  private Button toFindBtn ;
  private OnClickListener toFindBtnLis = new OnClickListener() {

    @Override
    public void onClick(View v) {
      // TODO Auto-generated method stub
      Vector<String> mainChoose = getMainChecked() ;
      Vector<String> snackChoose = getSnackChecked() ;
      Vector< ArrayList<String> > okData = RandomChoose( mainChoose, snackChoose ) ;
      Bundle chooseData = new Bundle() ;
      chooseData.putStringArrayList( "food1",  okData.get(0) );
      chooseData.putStringArrayList( "food2", okData.get(1) );
      seeFinal.putExtras( chooseData ) ;
      startActivityForResult( seeFinal, 1 ) ;
    } // onClick()
    
  } ;
  
  private CheckBox chB1 ;
  private CheckBox chB2 ;
  private CheckBox chB3 ;
  private CheckBox chB4 ;
  private CheckBox chB5 ;
  private CheckBox chB6 ;
  private CheckBox chB7 ;
  private CheckBox chB8 ;
  private CheckBox chB9 ;
  private ItemDAO db ;
  
  private Intent seeFinal ;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_see_eat_choose);
    toFindBtn = (Button) findViewById( R.id.findEatBtn ) ;
    toFindBtn.setOnClickListener( toFindBtnLis ) ;
    chB1 = (CheckBox) findViewById( R.id.chB1 ) ;
    chB2 = (CheckBox) findViewById( R.id.chB2 ) ;
    chB3 = (CheckBox) findViewById( R.id.chB3 ) ;
    chB4 = (CheckBox) findViewById( R.id.chB4 ) ;
    chB5 = (CheckBox) findViewById( R.id.chB5 ) ;
    chB6 = (CheckBox) findViewById( R.id.chB6 ) ;
    chB7 = (CheckBox) findViewById( R.id.chB7 ) ;
    chB8 = (CheckBox) findViewById( R.id.chB8 ) ;
    chB9 = (CheckBox) findViewById( R.id.chB9 ) ;
    db = new ItemDAO( getApplicationContext() ) ;
    
    seeFinal = new Intent( SeeEatChoose.this, FindEatWhat.class ) ;
  } // onCreate()

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.see_eat_choose, menu);
    return true;
  } // onCreateOptionsMenu()

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
  } // onOptionsItemSelected()
  
  @Override
  protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
    // 資料回傳接收
    super.onActivityResult( requestCode, resultCode, data ) ;
    if ( requestCode == 1 && resultCode == RESULT_OK ) {
      Bundle bundle = data.getExtras() ;
      if ( bundle.getString( "status" ).compareTo( "reChoose" ) == 0 ) {
        return ;
      } // if
      else {
        finish() ;
      } // else
    } // if
  } // onActivityResult()
  
  // -----------------------------------------------
  
  public Vector<String> getMainChecked() {
    Vector<String> rtn = new Vector<String>() ;
    
    if ( this.chB1.isChecked() )
      rtn.add( this.chB1.getText().toString() ) ;
    if ( this.chB2.isChecked() )
      rtn.add( this.chB2.getText().toString() ) ;
    if ( this.chB3.isChecked() )
      rtn.add( this.chB3.getText().toString() ) ;
    if ( this.chB4.isChecked() )
      rtn.add( this.chB4.getText().toString() ) ;
    if ( this.chB5.isChecked() )
      rtn.add( this.chB5.getText().toString() ) ;
    if ( this.chB6.isChecked() )
      rtn.add( this.chB6.getText().toString() ) ;
    return rtn;
  } // getChecked()
  
  public Vector<String> getSnackChecked() {
    Vector<String> rtn = new Vector<String>() ;
    
    if ( this.chB7.isChecked() )
      rtn.add( this.chB7.getText().toString() ) ;
    if ( this.chB8.isChecked() )
      rtn.add( this.chB8.getText().toString() ) ;
    if ( this.chB9.isChecked() )
      rtn.add( this.chB9.getText().toString() ) ;
    return rtn;
  } // getChecked()
  
  // -----------------------------------------------
  
  public Vector< ArrayList<String> > RandomChoose( Vector<String> main, Vector<String> snack ) {
    Vector< ArrayList<String> > allData = db.getAllListIncludeSys() ;
    Random ran = new Random();
    Vector< ArrayList<String> > mainFood = new Vector< ArrayList<String> >() ;
    Vector< ArrayList<String> > snackFood = new Vector< ArrayList<String> >() ;
    
    // 選出指定物品
    if ( main.size() > 0 ) {
      for ( int i = 0 ; i < allData.size() ; i++ )
        for ( int j = 0 ; j < main.size() ; j++ )
           if ( allData.get( i ).get( ItemDAO.TYPE ).compareTo( main.get( j ) ) == 0 ) {
              mainFood.add( allData.get( i ) ) ;
              break ;
            } // if
    } // if
    else {
      for ( int i = 0 ; i < allData.size() ; i++ )
        if ( allData.get( i ).get( 3 ).compareTo( "湯" ) != 0 &&
             allData.get( i ).get( 3 ).compareTo( "飲料" ) != 0 &&
             allData.get( i ).get( 3 ).compareTo( "小點心" ) != 0 )
          mainFood.add( allData.get( i ) ) ;
    } // else
    
    if ( snack.size() > 0 ) {
      for ( int i = 0 ; i < allData.size() ; i++ )
        for ( int j = 0 ; j < snack.size() ; j++ )
          if ( allData.get( i ).get( 3 ).compareTo( snack.get( j ) )  == 0 ) {
            snackFood.add( allData.get( i ) ) ;
            break ;
          } // if
    } // if
    else {
      for ( int i = 0 ; i < allData.size() ; i++ )
        if ( allData.get( i ).get( 3 ).compareTo( "湯" ) == 0 ||
             allData.get( i ).get( 3 ).compareTo( "飲料" ) == 0 ||
             allData.get( i ).get( 3 ).compareTo( "小點心" ) == 0 )
          snackFood.add( allData.get( i ) ) ;
    } // else
    
    Vector< ArrayList<String> > rtn = new Vector< ArrayList<String> >() ;
    
    rtn.add( mainFood.get( ran.nextInt( mainFood.size() ) ) ) ;
    rtn.add( snackFood.get( ran.nextInt( snackFood.size() ) ) ) ;
    return rtn ;
  } // RandomChoose()

} // class SeeEatChoose
