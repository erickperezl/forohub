// src/main/java/com/foro/hub/JwtAuthenticationResponse.java
package com.foro.hub;

public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    // Getters and setters
}
