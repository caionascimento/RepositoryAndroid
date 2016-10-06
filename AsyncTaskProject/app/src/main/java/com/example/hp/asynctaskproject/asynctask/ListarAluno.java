package com.example.hp.asynctaskproject.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hp.asynctaskproject.R;
import com.example.hp.asynctaskproject.acticity.ListarActivity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IFPB on 03/10/2016.
 */
public class ListarAluno extends AsyncTask<String, Void, Integer> {

    private static final String TAG = "Http Connection";
    private ListView listAct = null;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Integer doInBackground(String... params) {
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;
        Integer result = 0;
        try {
            // Conectar com o servidor
            URL url = new URL("http://ladoss.info:8773/Convite_SERVICE/convidado/listar");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            //Verifica se a conexão foi feita com a respota = 200
            int statusCode = urlConnection.getResponseCode();
            if (statusCode ==  200) {
                inputStream = new BufferedInputStream(urlConnection.getInputStream());
                String response = convertInputStreamToString(inputStream);
                parseResult(response);
                result = 1;
            }else{
                result = 0;
            }

        } catch (IOException e) {
            Log.e("CadastrarAluno", e.getMessage());
        }
        return result;
    }

    @Override
    //Adptador para o ListView
    protected void onPostExecute(Integer result) {
        if(result == 1){
            ListarActivity delimitador = new ListarActivity();
            ArrayAdapter arrayAdapter = new ArrayAdapter(delimitador, android.R.layout.simple_list_item_1, R.id.listActivity);
            listAct.setAdapter(arrayAdapter);
        }
        else{
            Log.e(TAG, "Failed to fetch data!");
        }
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null){
            result += line;
        }

        if(null!=inputStream){
            inputStream.close();
        }
        return result;
    }

    //Transforma o Json para objeto
    private void parseResult(String result) {
        try{
            JSONObject response = new JSONObject(result);
            JSONArray posts = response.optJSONArray("posts");
            String[] blogTitles = new String[posts.length()];
            for(int i=0; i< posts.length();i++ ){
                JSONObject post = posts.optJSONObject(i);
                String title = post.optString("title");
                blogTitles[i] = title;
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
