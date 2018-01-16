package com.iprogrammer.app.utils

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

/**
 * Created by saurabha on 26/12/17.
 */
object CheckPermission {
    /*permissions request codes*/
    val REQUEST_COARSE_LOCATION = 5551
    val REQUEST_AUTHORIZATION = 5552
    val REQUEST_GOOGLE_PLAY_SERVICES = 5553
    val REQUEST_PERMISSION_GET_ACCOUNTS = 5554
    val REQUEST_PERMISSION_ALL = 5555
    val REQUEST_FINE_LOCATION = 5556
    val EXTERNAL_STORAGE = 854
    val CAMERA = 1444
    val READ_CALENDAR = 1531
    val WRITE_CALENDAR = 1530
    val CALL_PHONE = 1533
    val SMS = 1532

    @RequiresApi(Build.VERSION_CODES.M)
    fun checkStoragePermission(activity: Activity): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (activity.shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    activity.requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), EXTERNAL_STORAGE)
                    return false
                } else {
                    activity.requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), EXTERNAL_STORAGE)
                    return false
                }
            }
            return true
        } else {
            return true
        }

    }

    fun checkLocationPermission(activity: Activity): Boolean {

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_FINE_LOCATION)
                return false
            } else {
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_FINE_LOCATION)
                return false
            }
        }
        return true
    }

    fun checkSmsReadPermission(activity: Activity): Boolean {

        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_SMS)) {
                //ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_SMS}, CheckPermission.SMS);
                var alertBuilder = AlertDialog.Builder(activity)
                alertBuilder.setCancelable(true)
                alertBuilder.setTitle("Permission necessary")
                alertBuilder.setMessage("Read SMS permission is necessary")
                alertBuilder.setPositiveButton(android.R.string.yes, DialogInterface.OnClickListener { dialog, which -> ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_SMS), SMS) })
                val alert = alertBuilder.create()
                alert.show()
                return false
            } else {
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_SMS), SMS)
                return false
            }
        }
        return true
    }

    fun openPermissionConfirmDialog(context: Activity, permission: String, requestCode: Int, message: String, showAppSetting: Boolean) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(message)

        if (!showAppSetting) {
            builder.setPositiveButton("Allow", DialogInterface.OnClickListener { dialog, which ->
                ActivityCompat.requestPermissions(context, arrayOf(permission), requestCode)
                dialog.cancel()
            })
        } else if (showAppSetting) {
            builder.setPositiveButton("Setting", DialogInterface.OnClickListener { dialog, id ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + context.applicationContext.packageName))
                context.startActivity(intent)
            })
        }

        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
        builder.show()
    }

    fun checkGetAccountPermission(activity: Activity, requestCode: Int): Boolean {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.GET_ACCOUNTS)) {
                    ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.GET_ACCOUNTS), requestCode)
                    return false
                } else {
                    ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.GET_ACCOUNTS), requestCode)
                    return false
                }
            }
        }
        return true
    }

    fun checkCameraPermission(context: Activity): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(context, Manifest.permission.CAMERA)) {
                    ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.CAMERA), CAMERA)
                    return false
                } else {
                    ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.CAMERA), CAMERA)
                    return false
                }
            } else {
                return true
            }
        } else {
            return true
        }
    }

    fun checkCalenderReadPermission(context: Activity): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(context, Manifest.permission.READ_CALENDAR)) {
                    ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.READ_CALENDAR), READ_CALENDAR)
                    return false
                } else {
                    ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.READ_CALENDAR), READ_CALENDAR)
                    return false
                }
            }

            return true
        } else {
            return true
        }
    }

    fun checkCalenderWritePermission(context: Activity): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(context, Manifest.permission.WRITE_CALENDAR)) {
                    ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.WRITE_CALENDAR), WRITE_CALENDAR)
                    return false
                } else {
                    ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.WRITE_CALENDAR), WRITE_CALENDAR)
                    return false
                }
            }
            return true
        } else {
            return true
        }
    }

    fun checkCALLPermission(context: Activity): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(context, Manifest.permission.CALL_PHONE)) {
                    ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.CALL_PHONE), CALL_PHONE)
                    return false
                } else {
                    ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.CALL_PHONE), WRITE_CALENDAR)
                    return false
                }
            }
            return true
        } else {
            return true
        }
    }
}