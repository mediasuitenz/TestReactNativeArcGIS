//  Created by react-native-create-bridge

package com.testreactnativearcgis.arcgisbridge;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.testreactnativearcgis.arcgisbridge.ArcGISBridgeModule;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArcGISBridgePackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
      // Register your native module
      // https://facebook.github.io/react-native/docs/native-modules-android.html#register-the-module
      // return Arrays.<NativeModule>asList(
      //     new ArcGISBridgeModule(reactContext)
      // );
      List<NativeModule> modules = new ArrayList<>();
      modules.add(new ArcGISBridgeModule(reactContext));
      return modules;
    }

    // @Override
    // public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
    //     return Collections.emptyList();
    // }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        // Register your native component's view manager
        // https://facebook.github.io/react-native/docs/native-components-android.html#4-register-the-viewmanager
        return Arrays.<ViewManager>asList(
            new ArcGISBridgeManager()
        );
    }
}
