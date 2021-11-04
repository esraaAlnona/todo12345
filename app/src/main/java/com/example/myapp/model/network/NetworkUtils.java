//package com.example.myapp.model.network;
//
//import android.content.Context;
//
//import com.tagapps.tagportal.R;
//import com.tagapps.tagportal.data.model.ServiceErrorWrapper;
//
//import java.net.SocketTimeoutException;
//
//import retrofit.RetrofitError;
//
///**
// * Created by Ihab Al-Naqib on 1/6/16.
// */
//public class NetworkUtils {
//
//    public static ServiceErrorWrapper getErrorReason(Context context, Throwable throwable) throws Exception {
//        ServiceErrorWrapper serviceErrorWrapper = new ServiceErrorWrapper();
//
//        if (throwable instanceof RetrofitError) {
//            RetrofitError retrofitError = (RetrofitError) throwable;
//            switch (retrofitError.getKind()) {
//                case NETWORK: {
//                    if (retrofitError.getCause() instanceof SocketTimeoutException)
//                        serviceErrorWrapper.setErrorMessage(context.getString(R.string.noResponse));
//                    else
//                        serviceErrorWrapper.setErrorMessage(context.getString(R.string.otherNetworkFailure));
//                    break;
//                }
//                case HTTP: {
//                    if (retrofitError.getResponse().getStatus() == 404)
//                        try {
//                            serviceErrorWrapper = ((ServiceErrorWrapper) retrofitError.getBodyAs(ServiceErrorWrapper.class));
//                        } catch (Exception e) {
//                            serviceErrorWrapper.setErrorMessage(context.getString(R.string.noResponse));
//                        }
//                    else {
//                        try {
//                            serviceErrorWrapper = ((ServiceErrorWrapper) retrofitError.getBodyAs(ServiceErrorWrapper.class));
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    break;
//                }
//            }
//        }
//        return serviceErrorWrapper;
//    }
//}
