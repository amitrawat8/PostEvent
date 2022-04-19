package com.amitrawat.postevent

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amitrawat.postevents.ConsumableEvent
import com.amitrawat.postevents.PostEvent

class MainActivity : AppCompatActivity() {
    private var eventItem: EventItem = EventItem()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSubscribeData()

    }

    private fun getSubscribeData() {
        PostEvent.subscribe(EventPage.MAIN_ACTIVITY, this) {
            it.runAndConsume {
                when (it.id) {
                    EventConstants.withoutData -> {
                        Toast.makeText(this, "Event Hit", Toast.LENGTH_SHORT).show()
                    }

                    EventConstants.dataWithString -> {
                        var getValue: String = it.value as String
                        Toast.makeText(this, "Event Hit with data" + getValue, Toast.LENGTH_SHORT)
                            .show()
                    }

                    EventConstants.dataWithObject -> {
                        eventItem = it.value as EventItem

                        Toast.makeText(
                            this,
                            "Event Hit with Object" + eventItem.id,
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }


                }
            }
        }
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


    override fun onDestroy() {
        super.onDestroy()
        /*unregister the Subscriber*/
        PostEvent.unregister(EventPage.MAIN_ACTIVITY)
    }
}