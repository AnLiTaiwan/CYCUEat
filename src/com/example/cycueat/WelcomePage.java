package com.example.cycueat;

import com.example.threecountryeat.R;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomePage extends Activity {

  private Button goToEatBtn ;
  private Button recordBtn ;
  private Button userDefBtn ;
  private Intent goChoosePage ;
  private OnClickListener goChooseLis = new OnClickListener() {
    @Override
    public void onClick(View v) {
      // TODO Auto-generated method stub
      goChoosePage = new Intent( WelcomePage.this, SeeEatChoose.class ) ;
      startActivity( goChoosePage );  // 不�?��?��?��?��??
      // startActivityForResult( perInput, 4 ) ; 
    } // onClick()
  } ; // OnClickListener()
  
  private OnClickListener recordLis = new OnClickListener() {
    @Override
    public void onClick(View v) {
      // TODO Auto-generated method stub
      goChoosePage = new Intent( WelcomePage.this, UserRecord.class ) ;
      startActivity( goChoosePage );
      // startActivityForResult( perInput, 4 ) ; 
    } // onClick()
  } ; // OnClickListener()
  
  private OnClickListener userAddLis = new OnClickListener() {
    @Override
    public void onClick(View v) {
      // TODO Auto-generated method stub
      goChoosePage = new Intent( WelcomePage.this, UserDefineList.class ) ;
      startActivity( goChoosePage );
      // startActivityForResult( perInput, 4 ) ; 
    } // onClick()
  } ; // OnClickListener()
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome_page);
    goToEatBtn = (Button) findViewById( R.id.goToEatBtn ) ;
    goToEatBtn.setOnClickListener( goChooseLis ) ;
    recordBtn = (Button) findViewById( R.id.eattenBtn ) ;
    recordBtn.setOnClickListener( recordLis );
    userDefBtn = (Button) findViewById( R.id.userAddBtn ) ;
    userDefBtn.setOnClickListener( userAddLis ) ;
  } // onCreate

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.welcome_page, menu);
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
