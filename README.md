# Spike into React Native bridged with ArcGIS Android SDK

## Summary

The hope was that [react-native-create-bridge](https://github.com/peggyrayzis/react-native-create-bridge) would magically wrap the SDK and we could call whatever we need straight from JavaScript. In reality we still need to write a Java layer in between. Even then, it will not be possible/simple to have a 1:1 API, because of the different language paradigms. The ArcGIS Java SDK requires creating/passing in classes (e.g. DefaultMapViewOnTouchListener) and doing conversions from map data classes to simple types to pass back in events.

It would still be possible to use this set up if we wanted to write all of the mapping stuff in Java, and just expose the few actions and events that we need to the React Native wrapping app. For Media Suite to pursue this would require a large investment in time and effort into learning/using the Android and the ArcGIS Java SDKs. We would also likely face most of the challenges raised by this other investigation - https://github.com/glazou/react-native-arcgis-sdk-demo

## Notes on what I did to get this running

Started with running [Create React Native App](https://github.com/react-community/create-react-native-app).

`yarn install`
`yarn start`

Installed https://github.com/peggyrayzis/react-native-create-bridge
Had to clone and build it, then `npm link`, because the current version 2.0.0 wasn't packaged correctly and was giving some "src not found" error.

`react-native new-module`
name: ArcGISBridge
type: both
OS: both, Java + Objective-C ?
dir: src

Looked like it failed to do some iOS stuff
`UnhandledPromiseRejectionWarning: Error: ENOENT: no such file or directory, open '/Users/matt/src/ms/TestReactNativeArcGIS/ios/ArcGISBridgeManager.m'`

Turns out if you create the ios folder then the above works without error.

Next steps were to add to MainApplication.java which doesn't exist, seems I have to eject from the create-react-native-app env.
Once ejected, had to re-do `new module`.

Tweaked the JS and Java a lot to get it to work...

Added entries to 2 `build.gradle` files according to https://developers.arcgis.com/android/latest/guide/develop-your-first-map-app.htm

Been running directly on my phone with `react-native run-android`
Where `react-native` is from node_modules ("react-native": "0.52.0")


Spent first 5 hours just getting a native bridge to work. Then 1 hour getting the ArcGIS map into the bridge. Then about an hour looking into how to add markers or listen to map events.


Documentation for ArcGIS android isn't amazing, and examples don't look very good. They seem to have examples around using and even manipulating ArcGIS feature layers, but nothing about adding data directly (GeoJSON etc).
https://developers.arcgis.com/android/latest/api-reference/reference/packages.html

I forgot how painful writing in Java is.


Trying to listen to touch event. Will probably need to use an ArcGIS lib to translate x,y to lat,lng.
https://developers.arcgis.com/android/latest/api-reference/reference/com/esri/arcgisruntime/mapping/view/DefaultMapViewOnTouchListener.html
https://developer.android.com/reference/android/view/MotionEvent.html
