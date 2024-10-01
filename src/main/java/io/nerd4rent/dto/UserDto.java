package io.nerd4rent.dto;

public class UserDto {
    private Long id;
    private String name;
    private String email;

    public UserDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Gettery
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}