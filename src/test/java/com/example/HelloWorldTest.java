package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {
    // ...existing code...

    @Test
    void testGetGreeting() {
        assertEquals("Hello, World!", HelloWorld.getGreeting());
    }

    // ...existing code...
}

