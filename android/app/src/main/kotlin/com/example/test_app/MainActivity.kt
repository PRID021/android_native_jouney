package com.example.test_app

import android.content.Intent
import android.os.Handler
import android.os.Looper
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import java.util.Timer
import java.util.TimerTask

class MainActivity: FlutterActivity() {
    private val CHANNEL = "com.example.test_app/method_channel_activity"
    private  val EVENT_CHANNEL = "com.example.test_app/event_channel"
    private var eventSink: EventChannel.EventSink? = null

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
        eventChannel.setStreamHandler(
            object:EventChannel.StreamHandler{
                override fun onListen(arguments: Any?, events: EventChannel.EventSink?) {
                    eventSink = events
                    sendData()
                }

                override fun onCancel(arguments: Any?) {
                    eventSink =null
                }

                private fun sendData() {
                    val timer = Timer()
                    timer.scheduleAtFixedRate(object : TimerTask() {
                        override fun run() {
                            val data = "Current time: ${System.currentTimeMillis()}"
                            Handler(Looper.getMainLooper()).post{
                                eventSink?.success(data)
                            }
                        }
                    }, 0, 1000)
                }
            }
        )




    }

//    private fun createEventSink(): EventChannel.EventSink? {
//        return object:EventChannel.EventSink{
//            override fun success(event: Any?) {
//                // Check if the event sink is set
//                eventSink?.success(event)
//            }
//
//            override fun error(errorCode: String?, errorMessage: String?, errorDetails: Any?) {
//                eventSink?.error(errorCode,errorMessage,errorDetails)
//            }
//
//            override fun endOfStream() {
//              eventSink?.endOfStream()
//            }
//
//        }
//    }

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
