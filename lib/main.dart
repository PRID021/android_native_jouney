import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  final MethodChannel _channel = MethodChannel('com.example.flutter/activity');

  void startActivity() async {
    try {
      await _channel.invokeMethod('startActivity');
    } on PlatformException catch (e) {
      print("Failed to call Kotlin activity: ${e.message}");
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Flutter App'),
        ),
        body: Center(
          child: ElevatedButton(
            onPressed: startActivity,
            child: Text('Open Kotlin Activity'),
          ),
        ),
      ),
    );
  }
}
