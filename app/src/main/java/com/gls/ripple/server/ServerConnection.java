package com.gls.ripple.server;

import android.content.Context;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


/**
 * Created by santosh on 6/10/15.
 */
public class ServerConnection {

    public static HttpClient httpClient;
    public static HttpContext localContext;
    public static String url = "";

    public static HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = new DefaultHttpClient();
        }
        return httpClient;
    }

    public static void setHttpClient(HttpClient httpClient) {
        ServerConnection.httpClient = httpClient;
    }

    public static HttpContext getLocalContext() {
        if (localContext == null)
            localContext = new BasicHttpContext();
        return localContext;
    }

    public static void setLocalContext(HttpContext localContext) {
        ServerConnection.localContext = localContext;
    }

    public static String getASCIIContentFromEntity(HttpEntity entity) {
        InputStream in = null;
        StringBuffer out = null;
        try {
            in = entity.getContent();
            out = new StringBuffer();
            int n = 1;
            while (n > 0) {
                byte[] b = new byte[4096];
                n = in.read(b);
                if (n > 0)
                    out.append(new String(b, 0, n));
            }
        } catch (IllegalStateException ie) {
            ie.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (OutOfMemoryError oom) {
            oom.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return out.toString();
    }
    public static String executeGet(String url) throws UnsupportedEncodingException {
        Log.e("URL executeGet", url);
        httpClient = getHttpClient();
        localContext = getLocalContext();
        String result = "";
        url=url.replace(" ","%20");
        HttpEntity entity;
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpGet, localContext);
            entity = response.getEntity();
            result = getASCIIContentFromEntity(entity);
        } catch (HttpHostConnectException hhce) {
            hhce.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public static String executePost(String param, String urlPath) {
        Log.e("URL executePost",urlPath);
        httpClient = getHttpClient();
        localContext = getLocalContext();
        urlPath=urlPath.replace(" ", "%20");
        HttpEntity entity;
        String result = "";
        HttpPost httpPost = new HttpPost(urlPath);
        try {
            StringEntity stringEntity = new StringEntity(param);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost, localContext);
            entity = response.getEntity();
            result = getASCIIContentFromEntity(entity);

        } catch (HttpHostConnectException hhce) {
            hhce.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}

