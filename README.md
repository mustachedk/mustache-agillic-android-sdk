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
* [Gradle Dependency](https://developer.android.com/studio/build/dependencies)
* [Manual import](https://developer.android.com/studio/projects/android-library#psd-add-dependencies)

## Initializing the Agillic SDK

In order to use AgillicSDK you have to initialize and configure it first.

You can configure your Agillic instance in code:
* ``AGILLIC API KEY``
* ``AGILLIC API SECRET``
* ``AGILLIC SOLUTION ID``

See how to setup your Agillic Solution and obtain these values
in the [Agillic Solution Setup Guide](docs/AgillicSolutionSetup.md)

Initialize and configure

//TODO: INSERT AFTER REFACTOR

AgillicMobileSDK instance is now ready for usage.

## Usage

### Register App Installation

* ``RECIPIENT ID`` - Has to match RECIPIENT.EMAIL in the Agillic Recipient Table

//TODO: INSERT AFTER REFACTOR

### Register Push Token

//TODO: INSERT AFTER REFACTOR

### App View tracking

Track recipient behavior with App View Tracking

//TODO: INSERT AFTER REFACTOR

The ``screenName`` is the value that can be matched in the Condition Editor.
The suggested name convention to use some hierarchical ``app/sublevel-1/sublevel-2/...``

## Questions and Issues

Please provide any feedback via a [GitHub
Issue](https://github.com/mustachedk/mustache-agillic-android-sdk/issues/new).
