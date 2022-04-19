package com.amitrawat.postevent

import com.amitrawat.postevents.ConsumableEvent
import com.amitrawat.postevents.PostEventBus

object EventBus {
    fun sendWithoutData() = PostEventBus.publish(
        EventPage.MAIN_ACTIVITY, ConsumableEvent(id = EventConstants.withoutData)
    )

    fun unRegister(subject: String) {
        PostEventBus.unregister(subject)
    }

    fun sendWithDataString(title: String) =
        PostEventBus.publish(
            EventPage.MAIN_ACTIVITY,
            ConsumableEvent(id = EventConstants.dataWithString, value = title)
        )


    fun sendObject(eventItem: EventItem) = PostEventBus.publish(
        EventPage.MAIN_ACTIVITY,
        ConsumableEvent(id = EventConstants.dataWithObject, value = eventItem)
    )

}