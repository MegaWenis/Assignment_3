package org.uob.a3.gameobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FeatureTest {

    private Feature feature;

    @BeforeEach
    void setUp() {
        // Initialize a Feature object before each test
        feature = new Feature("feature1", "Ancient Statue", "A weathered statue covered in moss.");
    }

    @Test
    void testFeatureConstructor() {
        assertNotNull(feature, "Feature object should be created successfully.");
        assertEquals("feature1", feature.getId(), "Feature ID should match the provided value.");
        assertEquals("Ancient Statue", feature.getName(), "Feature name should match the provided value.");
        assertEquals("A weathered statue covered in moss.", feature.getDescription(),
                "Feature description should match the provided value.");
    }

    @Test
    void testToString() {
        // Assuming GameObject's toString is implemented correctly
        String expectedString = "GameObject {id='feature1', name='Ancient Statue', description='A weathered statue covered in moss.'}";
        assertEquals(expectedString, feature.toString(), "toString() should return the correct representation.");
    }

}
