package com.example.consumirunaapirestfulenformatojsonenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements com.example.myapplication.WebService.Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void  btguardar(View view){
        //Intent intent = new Intent(MainActivity.this,MainActivity.class);
        Map<String, String> datos = new HashMap<String, String>();
        com.example.myapplication.WebService.WebService ws= new WebService("https://jsonplaceholder.typicode.com/users",
                datos,MainActivity.this,MainActivity.this);
        ws.execute("GET");
    }
    @Override
    public void processFinish(String result) throws JSONException {

        String idtxt="";
        String name1="";
        String city1="";
        JSONArray JSONlista1 = new JSONArray(result);
        for(int i=0; i< JSONlista1.length();i++)
        {

            JSONObject datos1= JSONlista1.getJSONObject(i);
            idtxt = idtxt + "\n" +
                    datos1.getString("id").toString();

            JSONObject datos2= JSONlista1.getJSONObject(i);
            name1 = name1 + "\n" +
                    datos2.getString("name").toString();

            JSONObject datos3= JSONlista1.getJSONObject(i);
            city1 = city1 + "\n" +
                    datos3.getString("username").toString();

        }
        TextView txtdatos1 = (TextView)findViewById(R.id.tx_tid);
        txtdatos1.setText("ID"+"\n"+idtxt);

        TextView txtdatos2 = (TextView)findViewById(R.id.id_nombre);
        txtdatos2.setText("NOMBRE"+"\n"+name1);

        TextView txtdatos3 = (TextView)findViewById(R.id.id_city);
       txtdatos3.setText("USERNAME"+"\n"+city1);


    }
}