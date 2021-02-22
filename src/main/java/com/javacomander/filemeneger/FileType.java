package com.javacomander.filemeneger;

public enum FileType {
    FILE("File"), DIRECTORY("DIR");

    private String name;

    FileType(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
