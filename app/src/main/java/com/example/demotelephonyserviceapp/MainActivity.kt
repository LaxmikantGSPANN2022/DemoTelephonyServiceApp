package com.example.demotelephonyserviceapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getInfoTelephony()

         if (packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY))
         {

         }
    }

    private fun getInfoTelephony() {
        var telephonyManager: TelephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        val stringIMEINumber: String = telephonyManager.imei
        println("Device IMEI Number $stringIMEINumber")

        val stringSubscriberId: String = telephonyManager.subscriberId
        println("Device Subscriber ID $stringSubscriberId")

        val stringSimSerialNumber = telephonyManager.simSerialNumber
        println("Device Sim Serial Number $stringSimSerialNumber")

        var intDataNtworkType : Int = 0

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_STATE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            intDataNtworkType = telephonyManager.dataNetworkType
        }
        var stringDataNtworkType : String = ""

        when (intDataNtworkType){
            TelephonyManager.NETWORK_TYPE_CDMA -> stringDataNtworkType = "Type CDMA"
            TelephonyManager.NETWORK_TYPE_GPRS ->  stringDataNtworkType = "Type GPRS"
            TelephonyManager.NETWORK_TYPE_LTE ->  stringDataNtworkType = "Type LTE / 4G"
        }

        println("Device Data Network Type $stringDataNtworkType")



    }
}