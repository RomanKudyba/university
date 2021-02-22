package com.example.university.dto;

import com.example.university.model.Degree;

public class DegreeCount {
    private Degree degree;
    private Long count;

    public DegreeCount() {
    }

    public DegreeCount(Degree degree, Long count) {
        this.degree = degree;
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return degree + "=" + count;
    }
}
