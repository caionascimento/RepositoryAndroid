package com.example.hp.asynctaskexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

/**
 * Created by HP on 23/09/2016.
 */
public class SyncTaskClass extends AsyncTask <String, Void, Bitmap> {

    private ImageView carregaImagemImageView;

    public SyncTaskClass (ImageView carregaImagemImageView){
        this.carregaImagemImageView = carregaImagemImageView;
    }

    @Override
    protected void onPreExecute() { super.onPreExecute(); }

    @Override
    protected Bitmap doInBackground(String... strings) { return contatoRede(strings[0]); }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        carregaImagemImageView.setImageBitmap(bitmap);
    }

    private Bitmap contatoRede (String url) {
        // initilize the default HTTP client object
        final DefaultHttpClient client = new DefaultHttpClient();

        //forming a HttoGet request
        final HttpGet getRequest = new HttpGet(url);
        try {

            HttpResponse response = client.execute(getRequest);

            //check 200 OK for success
            final int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {
                Log.w("ImageDownloader", "Error " + statusCode +
                        " while retrieving bitmap from " + url);
                return null;

            }

            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = null;
                try {
                    // getting contents from the stream
                    inputStream = entity.getContent();

                    // decoding stream data back into image Bitmap that android understands
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    return bitmap;
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    entity.consumeContent();
                }
            }
        } catch (Exception e) {
            // You Could provide a more explicit error message for IOException
            getRequest.abort();
            Log.e("ImageDownloader", "Something went wrong while" +
                    " retrieving bitmap from " + url + e.toString());
        }

        return null;
    }
}

