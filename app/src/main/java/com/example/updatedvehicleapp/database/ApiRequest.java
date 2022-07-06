package com.example.updatedvehicleapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.updatedvehicleapp.model.UserModel;
import com.example.updatedvehicleapp.model.VehicleModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiRequest {

    final String URL = "http://192.168.80.249:6900/api/";
    public SQLiteDatabase db;

    public void getUser(final Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        DataBaseHelper db = new DataBaseHelper(context);
        String url = URL + "user";
        JsonArrayRequest objectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = response.getJSONObject(i);
                        String id = obj.getString("id");
                        String username = obj.getString("username");
                        String password = obj.getString("password");
                        String email = obj.getString("email");
                        String role = obj.getString("role");
                        Integer phone = Integer.valueOf(obj.getString("phone"));
                        String nic = obj.getString("nic");
                        String image = obj.getString("image");

                        UserModel user = new UserModel(id, username, password, email, role, phone, nic, image);
                        db.addUser(user);
                        Log.e("Id", id + "");
                        Log.e("Reponseuser", response+"");
                    }
                }
                catch (JSONException e) {
                    Log.e("error user", e.toString());
                    e.printStackTrace();
                }
            }
        }, error -> Log.e("Error response1", error.toString()));
        queue.add(objectRequest);
    }

    public void getVehicle(final Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        DataBaseHelper db = new DataBaseHelper(context);
        String url = URL + "vehicle";
        JsonArrayRequest objectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject obj = response.getJSONObject(i);
                        String vehicleId = obj.getString("id");
                        String plateNumber = obj.getString("plate_no");
                        String owner = obj.getString("owner");
                        String email = obj.getString("email");
                        String type = obj.getString("type");
                        String phone = obj.getString("phone");
                        String colour = obj.getString("colour");
                        String timeIn = obj.getString("time_in");
                        String timeOut = obj.getString("time_out");

                        VehicleModel vehicle = new VehicleModel(vehicleId, plateNumber, owner, email, type, phone, colour, timeIn, timeOut);
                        db.addVehicle(vehicle);
                        Log.e("vehicleId", vehicleId + "");
                        Log.e("Reponsevehicle", response+"");
                    }
                }
                catch (JSONException e) {
                    Log.e("error vehicle", e.toString());
                    e.printStackTrace();
                }
            }
        }, error -> Log.e("Error response2", error.toString()));


        queue.add(objectRequest);
    }

}




