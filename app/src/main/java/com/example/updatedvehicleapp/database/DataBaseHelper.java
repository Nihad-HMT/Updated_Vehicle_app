package com.example.updatedvehicleapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.example.updatedvehicleapp.model.UserModel;
import com.example.updatedvehicleapp.model.VehicleModel;

import java.time.DayOfWeek;


public class DataBaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db1 = getWritableDatabase();
    public SQLiteDatabase db = getWritableDatabase();

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCreateTableUser = "CREATE TABLE IF NOT EXISTS tbl_user(userId INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR, password VARCHAR, email VARCHAR, role VARCHAR, phone VARCHAR, nic VARCHAR, image VARCHAR)";
        db.execSQL(sqlCreateTableUser);
        String createTableVehicle = "CREATE TABLE IF NOT EXISTS tbl_vehicle(vehicleId INTEGER PRIMARY KEY AUTOINCREMENT, plateNumber VARCHAR, owner VARCHAR, email VARCHAR, type VARCHAR, phone VARCHAR, colour VARCHAR, timeIn VARCHAR, timeOut VARCHAR)";
        db.execSQL(createTableVehicle);
    }

    public void open() throws SQLException
    {
        db1 = getWritableDatabase();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUser(UserModel userModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("userId",userModel.getUserId());
        cv.put("username",userModel.getUsername());
        cv.put("password",userModel.getPassword());
        cv.put("email",userModel.getEmail());
        cv.put("role",userModel.getRole());
        cv.put("phone",userModel.getPhone());
        cv.put("nic",userModel.getNic());
        cv.put("image",userModel.getImage());


        long insert = db.insert("tbl_user", null, cv);

        if(insert == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public boolean addVehicle(VehicleModel vehicleModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("vehicleId",vehicleModel.getVehicleId());
        cv.put("plateNumber",vehicleModel.getPlateNumber());
        cv.put("owner",vehicleModel.getOwner());
        cv.put("email",vehicleModel.getEmail());
        cv.put("type",vehicleModel.getType());
        cv.put("phone",vehicleModel.getPhone());
        cv.put("colour",vehicleModel.getColor());
        cv.put("timeIn",vehicleModel.getTimeIn());
        cv.put("timeOut",vehicleModel.getTimeOut());


        long insert = db.insert("tbl_vehicle", null, cv);

        if(insert == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public DataBaseHelper(@Nullable Context context) {
        super(context,"parkme.db",null,1);
    }

    public String getUserRole(String uname)
    {
        String role;
        db = this.getWritableDatabase();
        String selectTableStatement="select role from tbl_user WHERE username = '" + uname + "'";
        Cursor res = db.rawQuery(selectTableStatement,null);
        res.moveToFirst();
        if (res.getCount() == 0) {
            role = "";
        } else {
            Log.e("GET ROLE ", res.getString(0)+"");
            role = res.getString(0);;
        }
        return role;
    }

    public boolean Login(String email, String password) throws SQLException
    {
        Cursor mCursor = db.rawQuery("SELECT * FROM tbl_user WHERE email=? AND password=?", new String[]{email,password});
        if (mCursor != null) {
            return mCursor.getCount() > 0;
        }
        return false;
    }
}