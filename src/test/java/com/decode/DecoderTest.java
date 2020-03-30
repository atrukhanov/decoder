package com.decode;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private Decoder dc = new Decoder();


    @org.junit.jupiter.api.Test
    void toShortCodeTest() {
        assertEquals("01010110",dc.toShortCode(86));
    }

    @org.junit.jupiter.api.Test
    void toLongCodeTest() {
        assertEquals("82 28 a3",dc.toLongCode(10403));
    }

    @org.junit.jupiter.api.Test
    void decodeFromShortTest() {
        assertEquals("82",dc.decodeFromShort("01010010"));
    }

    @org.junit.jupiter.api.Test
    void decodeFromLongTest() {
        assertEquals("10403",dc.decodeFromLong("80 28 a3"));
    }
}