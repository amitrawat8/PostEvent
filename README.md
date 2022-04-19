## PostEvent 
You can consider PostEvent as a lightweight communication channel for passing data within activities, or services, or fragments or between any of them. Think of EventBus as an underlying layer in your app which is independent of any active activities or services or fragments and their lifecycle.

### Step 1. Add the JitPack repository to your build file 
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}




### Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.amitrawat8:PostEvent:1.0.0'
	}
	
### usage of PostEventBus Subscribe in activity or fragment (e.g MainActivity.kt)

```kotlin
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
```

### usage of calling PostEventBus Subscribe of activity or fragment in other class  (e.g SecondActivity.kt)

```kotlin
 
 /*send without data */

 PostEvent.publish(
            EventPage.MAIN_ACTIVITY,
            ConsumableEvent(id = EventConstants.withoutData))

        /*send with data string*/

        PostEvent.publish(
            EventPage.MAIN_ACTIVITY,
            ConsumableEvent(id = EventConstants.dataWithString, value = "hello"))

        /*send with object */

        PostEvent.publish(
            EventPage.MAIN_ACTIVITY,
            ConsumableEvent(id = EventConstants.dataWithObject, value = EventItem(1, 2)) )
```



### UnSubscribe the PostEventBus(e.g MainActivity.kt)  

```kotlin

 override fun onDestroy() {
        super.onDestroy()
        /*unregister the Subscriber*/
        PostEvent.unregister(EventPage.MAIN_ACTIVITY)
    }
    
```    




