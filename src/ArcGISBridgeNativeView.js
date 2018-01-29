//  Created by react-native-create-bridge

import React, { Component } from 'react'
import { requireNativeComponent, NativeModules, View, PropTypes } from 'react-native'

// const ArcGISBridge = requireNativeComponent('ArcGISBridge', ArcGISBridgeNativeView)

// // export default class ArcGISBridgeNativeView extends Component {
// class ArcGISBridgeNativeView extends Component {
//   viewZoomIn () {
//     console.log('TOLD TO ZOOM', NativeModules)
//     // ArcGISBridge.bridgeZoomIn()
//     NativeModules.ArcGISBridgeModule.bridgeZoomIn();
//   }

//   newPoint () {
//     console.log('NEW POINT', arugments)
//   }

//   render () {
//     return <ArcGISBridge {...this.props} />
//   }
// }

// // const ArcGISBridge = requireNativeComponent('ArcGISBridge', {
// //   name: 'ArcGISBridgeNativeView'
// // })

// export default ArcGISBridge

var ArcGISBridge = requireNativeComponent('ArcGISBridge', {
  name: 'ArcGISBridge',
  propTypes: {
    ...View.propTypes,
    exampleProp: 'string',
    // layers: PropTypes.arrayOf(PropTypes.shape({
    //   type: PropTypes.oneOf(['ArcGISTiledMapServiceLayer', 'ArcGISFeatureLayer']),
    //   url: PropTypes.string
    // })),
    // onMove: PropTypes.func
  }
})

export default class ArcGISBridgeNativeView extends Component {
  viewZoomIn () {
    NativeModules.ArcGISBridge.bridgeZoomIn();
  }
  render() {
    return (
      <ArcGISBridge {...this.props} />
    );
  }
}
