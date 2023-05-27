import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  final MethodChannel _channel =
      const MethodChannel('com.example.test_app/method_channel_activity');
  final EventChannel _evenChannel =
      const EventChannel('com.example.test_app/event_channel');

  void startActivity(String activityName) async {
    try {
      await _channel
          .invokeMethod('startActivity', {'activityName': activityName});
    } on PlatformException catch (e) {
      print("Failed to call Kotlin activity: ${e.message}");
    }
  }

  void startListening(){
    _evenChannel.receiveBroadcastStream().listen((event) {
      print('Received event : $event');

    },onError: (dynamic error){
      print('Received error: ${error.message}');
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Flutter App'),
        ),
        body: Center(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              ElevatedButton(
                onPressed: () =>
                    startActivity('com.example.test_app.YourKotlinActivity'),
                child: const Text('Open Kotlin Activity'),
              ),
              const SizedBox(height: 8,),
              ElevatedButton(
                onPressed: () =>
                    startListening(),
                child: const Text('Start listening on event channel'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
