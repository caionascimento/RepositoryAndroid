package com.example.hp.asynctaskproject.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.example.hp.asynctaskproject.entidade.Aluno;
import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by HP on 01/10/2016.
 */
public class CadastrarAluno extends AsyncTask<Aluno, Void, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Aluno... alunos) {
        try {
            // Converter Alunos para Json
            Gson gson = new Gson();
            String alunoJson = gson.toJson(alunos[0]);

            Log.i("MainActivity", alunoJson);

            // Conectar com o servidor e enviar os dados.
            URL url = new URL("http://l");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            // create data output stream
            DataOutputStream wr = new DataOutputStream(
                    urlConnection.getOutputStream());
            // write to the output stream from the string
            wr.writeBytes(alunoJson);
            wr.close();

        } catch (IOException e) {

            Log.e("CadastrarAluno", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
