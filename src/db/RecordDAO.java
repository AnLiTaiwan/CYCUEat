package db;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import defaultDATA.DefaultDATA;

public class RecordDAO {
  private static final String DATABASE_NAME = "eatRecord" ;
  public static final String DATE_COL = "date";
  public static final String PRICE1_COL = "price1";
  public static final String NAME1_COL = "name1";
  public static final String BOSS1_COL = "boss1";
  public static final String PRICE2_COL = "price2";
  public static final String NAME2_COL = "name2";
  public static final String BOSS2_COL = "boss2";
  
  public static final int DATE = 0 ;
  public static final int PRICE1 = 1 ;
  public static final int NAME1 = 2 ;
  public static final int BOSS1 = 3 ;
  public static final int PRICE2 = 4 ;
  public static final int NAME2 = 5 ;
  public static final int BOSS2 = 6 ;
  //資料庫物件    
  private SQLiteDatabase db;

  // 建構子，一般的應用都不需要修改
  public RecordDAO( Context context ) {
    db = UserDBHelper.getDatabase(context);
  } // ItemDAO()
  
  //關閉資料庫，一般的應用都不需要修改
  public void close() {
    db.close();
  } // close()
  
  public void insert( Vector<String> item ) {
    // 建立準備新增資料的ContentValues物件
    ContentValues cv = new ContentValues();
    
    // 加入ContentValues物件包裝的新增資料
    // 第一個參數是欄位名稱， 第二個參數是欄位的資料
    cv.put( DATE_COL, item.get( DATE ) );
    cv.put( PRICE1_COL, item.get( PRICE1 ) );
    cv.put( NAME1_COL, item.get( NAME1 ) );
    cv.put( BOSS1_COL, item.get( BOSS1 ) );
    cv.put( PRICE2_COL, item.get( PRICE2 ) );
    cv.put( NAME2_COL, item.get( NAME2 ) );
    cv.put( BOSS2_COL, item.get( BOSS2 ) );
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
    String where = DATE_COL + "='" + id + "'" ;
    // 刪除指定編號資料並回傳刪除是否成功
    return db.delete( DATABASE_NAME, where , null) > 0;
  } // delete()
  
  public Vector< Vector<String> > getAll() {
    Vector<String> result = new Vector<String>();
    Vector< Vector<String> > rtn = new Vector< Vector<String> >() ;
    Cursor cursor = db.query(
                    DATABASE_NAME, null, null, null, null, null, null, null);

    while ( cursor.moveToNext() ) {
        result.add( cursor.getString( DATE ) );
        result.add( cursor.getString( PRICE1 ) );
        result.add( cursor.getString( NAME1 ) );
        result.add( cursor.getString( BOSS1 ) );
        result.add( cursor.getString( PRICE2 ) );
        result.add( cursor.getString( NAME2 ) );
        result.add( cursor.getString( BOSS2 ) );
        rtn.add( result ) ;
        result = new Vector<String>();
    } // while

    cursor.close();
    return rtn ;
  } // getAll()
  
  public int getSize() {
    return getAll().size() ;
  } // getSize()
} // class RecordDAO
