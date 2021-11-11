# Agillic SDK for Android

The Agillic SDK enables you to utilize the Agillic platform from within your Android App.
The SDK currently includes the following functionality:

 * Register devices used by a recipient in your mobile application.
 * Register a recipient token required to send a Push Notification to a device using Apple PN on iOS or Firebase Cloud Messaging for Android. When registered, this token will allow sending push notifications to recipients via the Agillic Dashboard.
 * Track recipient events. Tracking can be paused and resumed when requested by the user. Tracked events can be used to define [Target Groups](https://support.agillic.com/hc/en-gb/articles/360007001991-All-You-Need-to-Know-About-Target-Groups) in the Agillic Dashboard which can be used to direct targeted marketing and other communication.

Read more about the Agillic Platform on the [official Agillic website](https://agillic.com).
And in our [Developer portal](https://developers.agillic.com).

## Requirements

- Requires minimum Android 5.0+ (API level 21+)

## Installation

See the subsections below for details about the different installation methods.
* [As a dependency using Gradle](https://developer.android.com/studio/build/dependencies)

###### Add this to your root build.gradle
```bash
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

###### Add this to your root build.gradle
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

The Agillic instance is now ready for usage.

## Usage

### Register App Installation

* ``RECIPIENT ID`` - Has to match RECIPIENT.EMAIL in the Agillic Recipient Table

```kotlin
Agillic.register(recipientId = "RECIPIENT ID", activity = requireActivity())
```

### Register Push Token

Register for Remote Push Notifications in your App, like you used to and include your deviceToken when registering the SDK
_NOTE: This requires you to have already obtained the Recipient ID and stored it across app sessions - this is currently only supported for known recipients._

```kotlin
Agillic.register(recipientId = "RECIPIENT ID", pushNotificationToken = "DEVICE TOKEN", activity = requireActivity())
```

### App View tracking

Track recipient behavior with App View Tracking

```kotlin
val appViewEvent = com.agillic.app.sdk.events.AgillicAppViewEvent(screenName = "app_protocol://fragment/1")
Agillic.track(appViewEvent)
```

The screenName is the value that can be matched in the Condition Editor. We suggest using a hierarchical naming convention e.g. app/sublevel-1/sublevel-2/..., so that different event types can easily be filtered in the Agillic Condition Editor.

## Questions and Issues

Please provide any feedback via a [GitHub
Issue](https://github.com/mustachedk/mustache-agillic-android-sdk/issues/new).
