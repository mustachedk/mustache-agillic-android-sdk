# Agillic SDK for Android

The Agillic SDK enables you to utilize the Agillic platform from within your Android App.
The SDK currently includes the following functionality:

 * Register devices used by a recipient in your mobile application.
 * Register a recipient push notification token which enables your Agillic Solution to send push notifications to the recipient device.
 * Track recipient events. Tracking can be paused and resumed when requested by the user. Tracked events can be used to define [Target Groups](https://support.agillic.com/hc/en-gb/articles/360007001991-All-You-Need-to-Know-About-Target-Groups) in the Agillic Dashboard which can be used to direct targeted marketing and other communication.

Read more about the Agillic Platform on the [official Agillic website](https://agillic.com) and at our [Developer portal](https://developers.agillic.com).

## Requirements

- Requires minimum Android 5.0+ (API level 21+)
- INTERNET permission

## Installation

See the subsections below for details about different installation methods.
* [Add SDK as a dependency using Gradle](https://developer.android.com/studio/build/dependencies)


###### Add the maven jitpack repository to your root settings.gradle file
```bash
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()

        //Add this line
        maven { url "https://jitpack.io" }
    }
}
```

###### Add this to your build.gradle
```bash
dependencies {
  implementation 'com.github.mustachedk:mustache-agillic-android-sdk:1.0'
}
```

* [Importing SDK manually using Android Studio](https://developer.android.com/studio/projects/android-library#psd-add-dependencies)

## Initializing the Agillic SDK

In order to use AgillicSDK you have to initialize and configure it first.

You can configure your Agillic instance in code:
* ``AGILLIC API KEY``
* ``AGILLIC API SECRET``
* ``AGILLIC SOLUTION ID``

See how to setup your Agillic Solution and obtain these values
in the [Agillic Solution Setup Guide](docs/AgillicSolutionSetup.md).
We recommended these values are passed down to the client on start of the application from an App Server instead of being hardcoded into the application.


### Initialize in app

Start by importing the Agillic Module into your app component
```kotlin
import Agillic
```

Initialize and configure the Agillic SDK upon launch
```kotlin
Agillic.configure(apiKey = "AGILLIC API KEY", apiSecret = "AGILLIC API SECRET", solutionId = "AGILLIC SOLUTION ID")
```

The Agillic instance is now ready to use.

## Usage

### Register App Installation

You must register your application with the Agillic SDK on app startup. An optional push notification token can be passed to this method if available.

* ``RECIPIENT ID`` - Has to match RECIPIENT.EMAIL in the Agillic Recipient Table

```kotlin
Agillic.register(recipientId = "RECIPIENT ID", pushNotificationToken = "DEVICE TOKEN", activity = requireActivity())
```

Each time an updated push notification token becomes available from Firebase, register() should be called again while passing the updated token.

### App View tracking

Track recipient behavior with App View Tracking

```kotlin
val appViewEvent = com.agillic.app.sdk.events.AgillicAppViewEvent(screenName = "app_protocol://fragment/1")
Agillic.track(appViewEvent)
```

The screenName is the value that can be matched in the Condition Editor. We suggest using a hierarchical naming convention e.g. app/sublevel-1/sublevel-2/..., so that different event types can easily be filtered in the Agillic Condition Editor.

## Reading Push Notifications sent from your Agillic Solution

Prerequisites
* [Setup the Firebase Cloud Messaging SDK](https://firebase.google.com/docs/cloud-messaging/android/client)
* Read the [AgillicPushNotificationSetup](docs/AgillicPushNotificationSetup.md#Introduction) document to learn how to send push notifications to your Android application directly from your Agillic Solution.

**[Receiving a push notification while the application is in the foreground](https://firebase.google.com/docs/cloud-messaging/android/receive#override-onmessagereceived)**

When a user receives a push notification while the application is in the foreground, the notification data (e.g. body and title) and payload is delivered in the onMessageReceived callback of your FirebaseMessagingService implementation.

```kotlin
override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val data = remoteMessage.data
        val headline = data["headline"]
        val message = data["message"]
        val deeplink = data["deeplink"]
    }
```

** [Receiving a push notification while the application is in the background](https://firebase.google.com/docs/cloud-messaging/android/receive#backgrounded)**

When a user clicks a push notification while the application is in the background, the data payload is delivered in the extras of the intent of your launcher Activity.

```kotlin
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val extras = intent?.extras
        val deeplink = extras?.get("deeplink")
    }
```

## Questions and Issues

Please provide any feedback via a [GitHub Issue](https://github.com/mustachedk/mustache-agillic-android-sdk/issues/new).
