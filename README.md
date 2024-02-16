# Notification Reciever Application

## Step - 1
 - Add reciever application to the firebase 

## Step - 2
 - Create FirebaseService class and extend with FirebaseMessageService to set the notification data to notification body.

## Step - 3
 - add this to your manifest file.

        <service android:name="com.android.mynotification.messaging.FirebaseService"
            android:permission="com.google.android.c2dm.permission.Send"
            android:exported="true">
            <intent-filter>
                <action android:name="com.google.firebase.MESSAGING_EVENT"/>
                <action android:name="com.google.android.c2dm.intent.Recieve"/>
            </intent-filter>
        </service>
