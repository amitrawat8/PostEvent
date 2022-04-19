package com.amitrawat.postevent

import com.amitrawat.postevents.ConsumableEvent
import com.amitrawat.postevents.PostEvent

object EventBus {
    fun sendWithoutData() = PostEvent.publish(
        EventPage.MAIN_ACTIVITY, ConsumableEvent(id = EventConstants.withoutData)
    )

    fun unRegister(subject: String) {
        PostEvent.unregister(subject)
    }

    fun sendWithDataString(title: String) =
        PostEvent.publish(
            EventPage.MAIN_ACTIVITY,
            ConsumableEvent(id = EventConstants.dataWithString, value = title)
        )


    fun sendObject(eventItem: EventItem) = PostEvent.publish(
        EventPage.MAIN_ACTIVITY,
        ConsumableEvent(id = EventConstants.dataWithObject, value = eventItem)
    )

}