package com.example.test_app

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterActivity() {
    private val CHANNEL = "com.example.test_app/method_channel_activity"
    private  val EVENT_CHANNEL = "com.example.test_app/event_channel"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)

        // Create a MethodChannel
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            when (call.method) {
                "startActivity" -> {
                    val activityName = call.argument<String>("activityName");
                    val activityClass = getClassFromName(activityName)
                    if(activityClass!=null){
                        startKotlinActivity(activityClass)
                        result.success(null)
                    }
                    else{
                        result.error("INVALID_ACTIVITY","Invalid activity name",null)
                    }
                }
                else -> result.notImplemented()
            }
        }


        // Setup EventChannel
        val eventChannel = EventChannel(flutterEngine.dartExecutor.binaryMessenger,EVENT_CHANNEL)
        eventChannel.setStreamHandler(object:EventChannel.StreamHandler{
            override fun onListen(arguments: Any?, events: EventChannel.EventSink?) {
                events?.success("Event 1")
                events?.success("Event 2")
                events?.success("Event 3")
            }

            override fun onCancel(arguments: Any?) {
                // Clean up resources
            }
        })
    }

    private fun startKotlinActivity(activityClass: Class<*>?) {
        val intent = Intent(this,activityClass)
        startActivity(intent)

    }

    private fun getClassFromName(className: String?): Class<*>? {
        return  try {
            Class.forName(className)
        }catch (e:ClassNotFoundException){
            e.printStackTrace()
            null
        }
    }
}
