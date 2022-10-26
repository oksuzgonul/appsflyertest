package com.haluko.myapplication2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AFInAppEventType; // Predefined event names
import com.appsflyer.AFInAppEventParameterName; // Predefined parameter names
import com.appsflyer.attribution.AppsFlyerRequestListener;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "AppsFlyerTestApp";
    Map<String, Object> eventValues = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppsFlyerLib.getInstance().init("52KSrYbq7sXMsiQTr9YL9j", null, this);
        AppsFlyerLib.getInstance().start(this);/*, "52KSrYbq7sXMsiQTr9YL9j", new AppsFlyerRequestListener() {
            @Override
            public void onSuccess() {
                Log.d(LOG_TAG, "Launch sent successfully, got 200 response code from server");
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d(LOG_TAG, "Launch failed to be sent:\n" +
                        "Error code: " + i + "\n"
                        + "Error description: " + s);
            }
        });*/
        eventValues.put(AFInAppEventParameterName.CONTENT_ID,"123");
        eventValues.put(AFInAppEventParameterName.CONTENT_TYPE, "shoes");
        eventValues.put(AFInAppEventParameterName.REVENUE, 200);
    }

    public void ClickButton(View view)
    {
        AppsFlyerLib.getInstance().logEvent(getApplicationContext(), AFInAppEventType.PURCHASE, eventValues);
    }
}