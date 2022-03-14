package geometry

import java.util.*

class RectangleUtil {

    fun createRandomRactangle(): Rectangle {
        val random = Random()
        return Rectangle(random.nextInt(), random.nextInt())
    }
}