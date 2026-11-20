package edu.course.lab02;

import java.util.Arrays;

public class DataSample {
    private final String id;
    private final String label;
    private SampleStatus status;
    private final double[] features;

    public DataSample(String id, String label, double[] features) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id must not be blank");
        }
        if (label == null || label.isBlank()) {
            throw new IllegalArgumentException("label must not be blank");
        }
        if (features == null || features.length == 0) {
            throw new IllegalArgumentException("features must not be empty");
        }
        this.id = id;
        this.label = label;
        // Копируем массив, чтобы извне не могли его изменить
        this.features = Arrays.copyOf(features, features.length); 
        this.status = SampleStatus.NEW;
    }

    public String getId() { return id; }
    public String getLabel() { return label; }
    public SampleStatus getStatus() { return status; }

    // Возвращаем копию массива, защищая внутреннее состояние
    public double[] getFeatures() {
        return Arrays.copyOf(features, features.length);
    }

    public void changeStatus(SampleStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("status must not be null");
        }
        this.status = newStatus;
    }

    public boolean isReady() {
        return status == SampleStatus.READY;
    }

    public double calculateMean() {
        double sum = 0;
        for (double feature : features) {
            sum += feature;
        }
        return sum / features.length;
    }
}