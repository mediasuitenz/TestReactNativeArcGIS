//  Created by react-native-create-bridge

package com.testreactnativearcgis.arcgisbridge;

import android.view.View;
import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import com.facebook.react.uimanager.annotations.ReactProp;

public class ArcGISBridgeManager extends SimpleViewManager<View> {
    public static final String REACT_CLASS = "ArcGISBridge";

    @Override
    public String getName() {
        // Tell React the name of the module
        // https://facebook.github.io/react-native/docs/native-components-android.html#1-create-the-viewmanager-subclass
        return REACT_CLASS;
    }

    @Override
    public View createViewInstance(ThemedReactContext context){
        Log.v(REACT_CLASS, "create view instance");
        // Create a view here
        // https://facebook.github.io/react-native/docs/native-components-android.html#2-implement-method-createviewinstance
        return new View(context);
    }

    @ReactProp(name = "exampleProp")
    public void setExampleProp(View view, @Nullable String exampleProp) {
        Log.v(REACT_CLASS, "set example prop:");
        Log.v(REACT_CLASS, exampleProp);
        // Set properties from React onto your native component via a setter method
        // https://facebook.github.io/react-native/docs/native-components-android.html#3-expose-view-property-setters-using-reactprop-or-reactpropgroup-annotation
    }
}
