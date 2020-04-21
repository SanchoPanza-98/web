package ru.omsu.imit.model;

public enum Role {
    BUYER(1),
    ADMIN(2);

    private int roleId;
    private Role(int roleId) {
        this.roleId=roleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
