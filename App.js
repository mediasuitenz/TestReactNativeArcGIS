import React from 'react';
import { StyleSheet, Text, View, Button } from 'react-native';
import ArcGISBridgeView from './src/ArcGISBridgeNativeView'

export default class App extends React.Component {
  onZoomIn () {
    this.refs.map.viewZoomIn();
  }

  render() {
    return (
      <View style={styles.container}>
        <ArcGISBridgeView
          style={styles.map}
          ref="map"
          exampleProp="hi"
        />
        <Button
          style={styles.button}
          onPress={() => { this.onZoomIn() }}
          title="Zoom in?"
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  map: {
    flex: 1,
    backgroundColor: '#8F8',
    height: '100%',
    width: '100%',
  },
  button: {
  }
});
