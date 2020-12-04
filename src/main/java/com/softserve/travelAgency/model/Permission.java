package com.softserve.travelAgency.model;

public enum Permission {
    PERSON_READ("developers:read"),
    PERSON_WRITE("developers:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
