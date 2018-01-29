//  Created by react-native-create-bridge

import { NativeModules } from 'react-native'

const { ArcGISBridge } = NativeModules

export default {
  exampleMethod () {
    return ArcGISBridge.exampleMethod()
  },

  EXAMPLE_CONSTANT: ArcGISBridge.EXAMPLE_CONSTANT
}
