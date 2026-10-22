package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataSampleTest {

    @Test
    void createsValidSampleAndCalculatesMean() {
        double[] features = {1.0, 2.0, 3.0};
        DataSample sample = new DataSample("S-1", "cat", features);
        
        assertEquals("S-1", sample.getId());
        assertEquals(SampleStatus.NEW, sample.getStatus());
        assertEquals(2.0, sample.calculateMean(), 0.0001);
    }

    @Test
    void copiesArrayInConstructor() {
        double[] features = {1.0, 2.0};
        DataSample sample = new DataSample("S-1", "cat", features);
        
        features[0] = 99.0; // Меняем исходный массив после создания
        assertEquals(1.0, sample.getFeatures()[0]); // Внутри объекта должно остаться 1.0
    }

    @Test
    void copiesArrayInGetter() {
        DataSample sample = new DataSample("S-1", "cat", new double[]{1.0, 2.0});
        
        double[] returned = sample.getFeatures();
        returned[0] = 99.0; // Меняем массив, который вернул getter
        
        assertEquals(1.0, sample.getFeatures()[0]); // Внутри объекта должно остаться 1.0
    }

    @Test
    void changesStatusAndChecksReady() {
        DataSample sample = new DataSample("S-1", "cat", new double[]{1.0});
        assertFalse(sample.isReady());
        
        sample.changeStatus(SampleStatus.READY);
        assertTrue(sample.isReady());
    }

    @Test
    void rejectsBlankId() {
        assertThrows(IllegalArgumentException.class,
            () -> new DataSample("  ", "cat", new double[]{1.0}));
    }
}