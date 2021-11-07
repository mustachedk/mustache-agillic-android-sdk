package com.agillic.app.sdk.events

import com.snowplowanalytics.snowplow.tracker.events.AbstractEvent
import java.util.*

class ScreenView(): CommonEvent() {
    var uuid : String = UUID.randomUUID().toString()

    fun id(uuid: String): ScreenView {
        this.uuid = uuid;
        return this;
    }

    override fun createSnowplowEvent(): AbstractEvent {
        return com.snowplowanalytics.snowplow.tracker.events.ScreenView.builder()
            .id(uuid)
            .name(name)
            .build()
    }
}