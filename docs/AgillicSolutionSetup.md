# Configuration of the Agillic Solution

## Introduction

This section will help you to configure the Agillic Solution an
obtain the keys and id's you need to be able configure and initialize
the AgillicMobileSDK into your Android application.

---

Login to your Agillic Solution and select **Settings** in the top right corner.

<img src="resources/setup1.png">

Next, select **Push and SDK** in the left pane Menu, under **Integrations** and check the "enable push" checkbox

<img src="resources/setup2.png">

**Enter application name.**

<img src="resources/setup3.png">

**Enter Client Application id.** This should correspond to the package name of your Android application.

<img src="resources/setup4.png">

**Enter Service account.** This should correspond to the service account key of a Firebase service account authorized to manage Firebase features such as the Firebase Cloud Messaging API.
Access or create a service account by navigating to [Google Cloud Platform](https://console.cloud.google.com).
From there select your Firebase project. Then click IAM & Admin in the sidebar and then Service Accounts.

<img src="resources/setup5.png">

Continue using an existing service account or click "CREATE SERVICE ACCOUNT" to create a new one.

<img src="resources/setup6.png">

When you have a valid service account, click the actions button and then "Manage keys".

<img src="resources/setup7.png">

Click "ADD KEY" and then "Create new key".

<img src="resources/setup8.png">

In the dialog, ensure that JSON is selected and click create.

<img src="resources/setup9.png">

This will download a json file containing the service account key.

It is important that your Firebase project has the Cloud Messaging API enabled.

