import com.snowplowanalytics.snowplow.tracker.events.AbstractEvent

interface Event {
    fun createSnowplowEvent(): AbstractEvent
}