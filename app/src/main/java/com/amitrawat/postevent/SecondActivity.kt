package com.amitrawat.postevent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amitrawat.postevents.ConsumableEvent
import com.amitrawat.postevents.PostEvent

class SecondActivity : AppCompatActivity() {
    private var eventItem: EventItem = EventItem()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendData()

    }


    /*calling Mainactivity subscriber  in other activity and fragment  */
    private fun sendData() {
/*sending without data*/
        PostEvent.publish(
            EventPage.MAIN_ACTIVITY,
            ConsumableEvent(id = EventConstants.withoutData)
        )

        /*send with data string*/

        PostEvent.publish(
            EventPage.MAIN_ACTIVITY,
            ConsumableEvent(id = EventConstants.dataWithString, value = "hello")
        )

        /*send with object */

        PostEvent.publish(
            EventPage.MAIN_ACTIVITY,
            ConsumableEvent(id = EventConstants.dataWithObject, value = EventItem(1, 2))
        )

    }


}