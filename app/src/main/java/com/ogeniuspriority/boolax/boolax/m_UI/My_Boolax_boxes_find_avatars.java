package com.ogeniuspriority.boolax.boolax.m_UI;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.ogeniuspriority.boolax.boolax.Config;
import com.ogeniuspriority.boolax.boolax.R;
import com.ogeniuspriority.boolax.boolax.server_enablers.ImageLoader;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.net.HttpURLConnection;

/**
 * Created by USER on 2/6/2017.
 */
public class My_Boolax_boxes_find_avatars extends AsyncTask<Void, Void, String> implements GlideModule {
    Context c;
    String urlAddress;
    String MyRemoteId;
    String reportData;
    Activity act;
    ImageView institution_avatar_local;


    public My_Boolax_boxes_find_avatars(Context c, String urlAddress, String MyRemoteId, ImageView institution_avatar) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.MyRemoteId = MyRemoteId;
        this.institution_avatar_local = institution_avatar;
        this.reportData = reportData;
        this.act = act;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(Void... voids) {

        try {
            return this.sendMYComment();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        if (jsonData == null) {
            //Toast.makeText(c, "Failed! No internet!", Toast.LENGTH_SHORT).show();
        } else {
            String myTr = jsonData.replaceAll("\\s", "");
            // My_Community_Posts_PicassoClient_box.downloadImage(c, Config.LOAD_MY_SUGGESTION_BOXES + myTr, institution_avatar_local);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            //requestOptions.skipMemoryCache(true);
            try {
//                Glide.with(c)
//                        .load(Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS + "/" + myTr)
//                        .apply(requestOptions.placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder))
//                        .into(institution_avatar_local);
//                //------------------------
                ImageLoader imageLoaderr = new ImageLoader(c);
                imageLoaderr.DisplayImage(Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS + "/" + myTr, institution_avatar_local);
                Log.w("test_2017", "" + myTr);
            } catch (Exception djkjd) {

            }

        }
        //Toast.makeText(c, "Comment sent!"+jsonData, Toast.LENGTH_SHORT).show();
    }

    private String sendMYComment() throws UnsupportedEncodingException {

        HttpURLConnection con = Boolax_favorite_avatars_connect.connect(urlAddress, MyRemoteId);
        if (con == null) {
            return null;
        }
        try {
            InputStream is = new BufferedInputStream(con.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuffer jsonData = new StringBuffer();
            while ((line = br.readLine()) != null) {
                jsonData.append(line + "\n");
            }
            // Send post request

            br.close();
            is.close();


            return jsonData.toString();


        } catch (IOException e) {
            e.printStackTrace();


        }


        return null;
    }

    @Override
    public String glideName() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
