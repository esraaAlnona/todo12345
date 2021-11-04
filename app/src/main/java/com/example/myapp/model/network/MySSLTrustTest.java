package com.example.myapp.model.network;

import android.content.Context;


import java.security.SecureRandom;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class MySSLTrustTest {
    @SuppressWarnings("null")
    public static OkHttpClient configureClient(final OkHttpClient client) {
        final TrustManager[] certs = new TrustManager[] {new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {

            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {

            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        } };

        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(null, certs, new SecureRandom());
        } catch (final java.security.GeneralSecurityException ex) {
        }

        try {
            final HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(final String hostname,
                                      final SSLSession session) {
                    return true;
                }
            };

//            client.
//            client.setHostnameVerifier(hostnameVerifier);
//            client.setSslSocketFactory(ctx.getSocketFactory());
        } catch (final Exception e) {
        }

        return client;
    }

    public static OkHttpClient trustcert(Context context) {
        final OkHttpClient client = new OkHttpClient();
        return configureClient(client);
    }
}