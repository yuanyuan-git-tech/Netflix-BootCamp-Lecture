# We Do: TDD

Starter code: [./starter](./starter)

Solved code: [./solved](./solved)

In this activity, you will write test cases first, then write the minimum amount of code necessary to pass the tests.

## Instructions

Using the starter project as your beginning point, add the following test cases to the project:

```java
package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TVTest{

    TV tele;
    @Before
    public void setUp() {
        tele = new TV(15);
    }

    @Test
    public void shouldTurnOn() {
        tele.on();
        assertTrue(tele.isOn());
    }

    @Test
    public void shouldTurnOff() {
        tele.off();
        assertFalse(tele.isOn());
    }

    @Test
    public void shouldChangeChannel() {
        tele.increaseChannel();
        tele.increaseChannel();
        assertEquals(17, tele.getChannel());
    }
}
```

Now add the following code to pass the tests:

```java
package com.company;

public class TV {

    private int channel;
    private boolean on;

    public TV(int channel) {
        this.channel = channel;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    public int increaseChannel() {
        return channel++;
    }

}
```

---

© 2023 2U. All Rights Reserved.
