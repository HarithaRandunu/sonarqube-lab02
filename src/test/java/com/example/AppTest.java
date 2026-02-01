package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setProperty("db.password", "testPassword");
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testMainMethodExecutes() {
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }

    @Test
    void testMainMethodWithNullArgs() {
        assertDoesNotThrow(() -> App.main(null));
    }

    @Test
    void testAppCreation() {
        App app = new App();
        assertNotNull(app);
    }
}
