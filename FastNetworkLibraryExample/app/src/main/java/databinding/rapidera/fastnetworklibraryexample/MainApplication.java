package databinding.rapidera.fastnetworklibraryexample;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

/**
 * Created by 201401 on 14-12-2018.
 */

public class MainApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //Initializing the Network Library
//        AndroidNetworking.initialize(getApplicationContext());

        //Initializing StethoIntercepter
        Stetho.initializeWithDefaults(this);


        // Adding an Network Interceptor for Debugging purpose :
        OkHttpClient okHttpClient = new OkHttpClient() .newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        AndroidNetworking.initialize(getApplicationContext(),okHttpClient);



    }
}
