//  Created by react-native-create-bridge

package com.testreactnativearcgis.arcgisbridge;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.HashMap;
import java.util.Map;

import com.esri.arcgisruntime.mapping.view.MapView;

public class ArcGISBridgeModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "ArcGISBridge";
    private static ReactApplicationContext reactContext = null;
    private MapView mMapView;

    public ArcGISBridgeModule(ReactApplicationContext context) {
        // Pass in the context to the constructor and save it so you can emit events
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        super(context);
        Log.v(REACT_CLASS, "construct bridge module");

        reactContext = context;
    }

    public void setMapView(MapView mMapView) {
        this.mMapView = mMapView;
        mMapView.setOnTouchListener(new ArcGISBridgeMapViewOnTouchListener(reactContext, mMapView, this));
    }

    @Override
    public String getName() {
        // Tell React the name of the module
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        return REACT_CLASS;
    }

    @Override
    public Map<String, Object> getConstants() {
        Log.v(REACT_CLASS, "get constants");
        // Export any constants to be used in your native module
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        final Map<String, Object> constants = new HashMap<>();
        constants.put("EXAMPLE_CONSTANT", "example");

        return constants;
    }

    @ReactMethod
    public void exampleMethod () {
        Log.v(REACT_CLASS, "example method");
        // An example native method that you will expose to React
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
    }

    @ReactMethod
    public void bridgeAddMarker(float x, float y) {
        Log.v(REACT_CLASS, "bridge add marker");

    }

    private static void emitDeviceEvent(String eventName, @Nullable WritableMap eventData) {
        Log.v(REACT_CLASS, "emit device event");
        // A method for emitting from the native side to JS
        // https://facebook.github.io/react-native/docs/native-modules-android.html#sending-events-to-javascript
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, eventData);
    }

    public void onTap(MotionEvent e) {
        Log.v(REACT_CLASS, "on tap!");
        WritableMap event = Arguments.createMap();
        event.putDouble("x", e.getX());
        event.putDouble("y", e.getY());

        ReactContext reactContext = (ReactContext) mMapView.getContext();
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("onMapTap", event);
    }
}
