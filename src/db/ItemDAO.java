package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import defaultDATA.DefaultDATA;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ItemDAO {
  
  private static final String DATABASE_NAME = "eatData" ;
  public static final String ID_COL = "id";
  public static final String PRICE_COL = "price";
  public static final String NAME_COL = "name";
  public static final String TYPE_COL = "type";
  public static final String BOSS_COL = "boss";
  public static final String SYSTEM_COL = "system";
  
  public static final int ID = 0 ;
  public static final int PRICE = 1 ;
  public static final int NAME = 2 ;
  public static final int TYPE = 3 ;
  public static final int BOSS = 4 ;
  public static final int SYSTEM = 5 ;
  //資料庫物件    
  private SQLiteDatabase db;

  // 建構子，一般的應用都不需要修改
  public ItemDAO(Context context) {
    DefaultDATA defData = new DefaultDATA() ;
    db = MyDBHelper.getDatabase(context);
    HashMap< String, Vector<String> > allData = getAll() ;
    for ( int i = 0 ; i < defData.getSize() ; i++ )
      if ( allData.get( i + "" ) == null ) {
        insert( defData.getItem( i ) ) ;
      } // if
  } // ItemDAO()
  
  //關閉資料庫，一般的應用都不需要修改
  public void close() {
    db.close();
  } // close()
  
  public void insert( Vector<String> item ) {
    // 建立準備新增資料的ContentValues物件
    ContentValues cv = new ContentValues();
    
    //  準備輸出的格式，如：星期四 2009/01/01
    /*
    SimpleDateFormat sdf = new SimpleDateFormat("E yyyy/MM/dd");
    Date date = new Date() ;
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    */
    // 加入ContentValues物件包裝的新增資料
    // 第一個參數是欄位名稱， 第二個參數是欄位的資料
    cv.put(ID_COL, item.get( 0 ) );
    cv.put(PRICE_COL, item.get( 1 ) );
    cv.put(NAME_COL, item.get( 2 ) );
    cv.put(TYPE_COL, item.get( 3 ) );
    cv.put(BOSS_COL, item.get( 4 ) );
    cv.put(SYSTEM_COL, item.get( 5 ) );
    // 新增一筆資料並取得編號
    // 第一個參數是表格名稱
    // 第二個參數是沒有指定欄位值的預設值
    // 第三個參數是包裝新增資料的ContentValues物件
    db.insert( DATABASE_NAME, null, cv ) ;

  } // insert()
  
  public boolean update( String id, String sMoney ) {
    // 建立準備修改資料的ContentValues物件
    ContentValues cv = new ContentValues();
    return false;

    // 加入ContentValues物件包裝的修改資料
    // 第一個參數是欄位名稱， 第二個參數是欄位的資料        
    // cv.put( MONEY_COL, sMoney );

    // 設定修改資料的條件為編號
    // 格式為「欄位名稱＝資料」
    // String where = ID_COL + "=" + id ;

    // 執行修改資料並回傳修改的資料數量是否成功
    // return db.update( DATABASE_NAME, cv, where, null) > 0 ;         
  } // update()
  
  public boolean delete(String id){
    // 設定條件為編號，格式為「欄位名稱=資料」
    String where = ID_COL + "='" + id + "'" ;
    // 刪除指定編號資料並回傳刪除是否成功
    return db.delete( DATABASE_NAME, where , null) > 0;
  } // delete()
  
  public HashMap< String, Vector<String> > getAll() {
    Vector<String> result = new Vector<String>();
    HashMap< String, Vector<String> > rtn = new HashMap< String, Vector<String> >() ;
    Cursor cursor = db.query(
                    DATABASE_NAME, null, null, null, null, null, null, null);

    while ( cursor.moveToNext() ) {
        result.add( cursor.getString( ID ) );
        result.add( cursor.getString( PRICE ) );
        result.add( cursor.getString( NAME ) );
        result.add( cursor.getString( TYPE ) );
        result.add( cursor.getString( BOSS ) );
        result.add( cursor.getString( SYSTEM ) );
        rtn.put( result.get( 0 ), result ) ;
        result = new Vector<String>();
    } // while

    cursor.close();
    return rtn ;
  } // getAll()

  public Vector< ArrayList<String> > getAllList() {
    ArrayList<String> result = new ArrayList<String>();
    Vector< ArrayList<String> > rtn = new Vector< ArrayList<String> >() ;
    Cursor cursor = db.query(
                    DATABASE_NAME, null, null, null, null, null, null, null);

    while ( cursor.moveToNext() ) {
      if ( cursor.getString( SYSTEM ).compareTo( "1" ) != 0 ) {
        result.add( cursor.getString( ID ) );
        result.add( cursor.getString( PRICE ) );
        result.add( cursor.getString( NAME ) );
        result.add( cursor.getString( TYPE ) );
        result.add( cursor.getString( BOSS ) );
        result.add( cursor.getString( SYSTEM ) );
        rtn.add( result ) ;
        result = new ArrayList<String>();
      } // if
    } // while

    cursor.close();
    return rtn ;
  } // getAll()
  
  public Vector< ArrayList<String> > getAllListIncludeSys() {
    ArrayList<String> result = new ArrayList<String>();
    Vector< ArrayList<String> > rtn = new Vector< ArrayList<String> >() ;
    Cursor cursor = db.query(
                    DATABASE_NAME, null, null, null, null, null, null, null);

    while ( cursor.moveToNext() ) {
        result.add( cursor.getString( ID ) );
        result.add( cursor.getString( PRICE ) );
        result.add( cursor.getString( NAME ) );
        result.add( cursor.getString( TYPE ) );
        result.add( cursor.getString( BOSS ) );
        result.add( cursor.getString( SYSTEM ) );
        rtn.add( result ) ;
        result = new ArrayList<String>();
    } // while

    cursor.close();
    return rtn ;
  } // getAll()
  
  public int getSize() {
    // TODO Auto-generated method stub
    return getAllList().size() ;
  } // getSize()
  
} // class ItemDAO
