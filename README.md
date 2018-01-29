


This project was bootstrapped with [Create React Native App](https://github.com/react-community/create-react-native-app).

`yarn install`
`yarn start`


Installed https://github.com/peggyrayzis/react-native-create-bridge
Had to clone and build it, then `npm link`, because the current version 2.0.0 wasn't packaged correctly.

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
