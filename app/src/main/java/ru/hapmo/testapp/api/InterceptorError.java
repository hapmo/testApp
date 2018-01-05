package ru.hapmo.testapp.api;


import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class InterceptorError implements Interceptor {

    public InterceptorError() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        boolean networkError = false;
        try {
            Response response = chain.proceed(chain.request());
            return response;
        } catch (Throwable t) {
            t.printStackTrace();
            if ((t instanceof UnknownHostException) ||
                    (t instanceof ConnectException)) {
                networkError = true;
            }
        }
        if (networkError) {
            String message = "Error: UNKNOWN HOST";
            throw new IOException(message);
        }
        return null;
    }
}
