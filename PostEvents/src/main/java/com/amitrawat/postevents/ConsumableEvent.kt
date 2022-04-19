package com.amitrawat.postevents

/**
 *  A consumable event, make sure event can run only one time
 *  If you don't consume it, an event can be run multiple times
 */
data class ConsumableEvent(
    var isConsumed: Boolean = false,
    var id: Any? = null,
    var value: Any? = null
) {
    /**
     *  run task & consume event after that
     */
    fun runAndConsume(runnable: () -> Unit) {
        if (!isConsumed) {
            runnable()
            isConsumed = true
        }
    }
}