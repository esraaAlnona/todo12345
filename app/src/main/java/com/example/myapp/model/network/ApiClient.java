package com.example.myapp.model.network;

import android.app.Application;
import android.content.Context;

import com.example.myapp.TagPortalApp;

import java.io.IOException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private static WebServiceAPI mApiInterface;


    public static Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    public static WebServiceAPI provideAppNewFeatures(OkHttpClient okHttpClient) {


        return new Retrofit.Builder()
                .baseUrl("https://tagapps.tag.global/TAGPortal/api/")
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //.addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .client(okHttpClient)
                .build()
                .create(WebServiceAPI.class);
    }

    public static OkHttpClient provideOkhttpClient(Cache cache) {


        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        //client.addInterceptor(new LoggerInterceptor());
        client.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Accept-Language", "en")
                        .header("source", "tag")
                        .header("applicationId", "tag")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });
        return client.build();
    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

//client.addInterceptor(logging);
            builder.interceptors().add(logging);

            builder.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Accept-Language", "en")
                            .header("Content-Type", "application/json")
                            .header("source", "tag")
                            .header("applicationId", "tag")
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            });

            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebServiceAPI apiClient(Context context) {
        if (mApiInterface == null) {
            mApiInterface = provideAppNewFeatures(getUnsafeOkHttpClient().build());

        }
        return mApiInterface;
    }

}