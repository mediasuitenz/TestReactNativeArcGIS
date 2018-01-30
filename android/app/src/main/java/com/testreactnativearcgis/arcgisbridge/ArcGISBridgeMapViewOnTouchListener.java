package com.testreactnativearcgis.arcgisbridge;

import android.util.Log;
import android.view.MotionEvent;

import com.facebook.react.bridge.ReactApplicationContext;

import com.esri.arcgisruntime.mapping.view.DefaultMapViewOnTouchListener;
import com.esri.arcgisruntime.mapping.view.MapView;

public class ArcGISBridgeMapViewOnTouchListener extends DefaultMapViewOnTouchListener {

    public ArcGISBridgeModule bridgeModule;

    public ArcGISBridgeMapViewOnTouchListener(ReactApplicationContext context, MapView mapView, ArcGISBridgeModule bridgeModule) {
        super(context, mapView);
        this.bridgeModule = bridgeModule;
    }

    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.v("ArcGISBridge", "on single tap confirmed");
        bridgeModule.onTap(e);
        return true;
    }
}
