package com.example.demo;


import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClimaTask extends AsyncTask<String, Void, String> {

    private TextView text;

    public ClimaTask(TextView text) {
        this.text = text;
    }

    @Override
    protected String doInBackground(String... params) {
        String city = params[0].replaceAll(" ", "%20");

        Api api = new Api();
        String retorno = api.get("https://weather.contrateumdev.com.br/api/weather/city/?city=" + city);

        return retorno;
    }

    @Override
    protected void onPostExecute(String s) {

        try {
            JSONObject json = new JSONObject(s);

            JSONArray weather = json.getJSONArray("weather");
            JSONObject weatherObject = weather.getJSONObject(0);
            String situacao = weatherObject.getString("description");

            JSONObject main = json.getJSONObject("main");
            String temp = main.get("temp").toString();

            text.setText("Temp. " + temp + "\n" + situacao);

        } catch (JSONException ex) {
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }
}