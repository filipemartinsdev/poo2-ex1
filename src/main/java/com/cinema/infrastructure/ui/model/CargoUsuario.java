package com.cinema.infrastructure.ui.model;

public enum CargoUsuario {
    CLIENTE(1, "Cliente"),
    FUNCIONARIO(2, "Funcionário");

    public final int id;
    public final String description;

    CargoUsuario(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
