package com.dhjo.dhjo_be.constant;

public class ErrorMessage {
    public static final String SAVE_ENTITY_ERROR = "Save entity fail";
    public static final String SAVE_ENTITY_ALREADY_EXIST_ERROR = "Entity already existed, cannot save";
    public static final String UPDATE_ENTITY_ERROR = "Update entity fail";
    public static final String DELETE_ENTITY_ERROR = "Delete entity fail";
    public static final String ENTITY_NOT_FOUND_ERROR = "Entity not found";
    public static final String INVALID_EMAIL_ADDRESS_ERROR = "Invalid email address";
    public static final String NOT_EMPTY_ERROR = "Cannot be empty";

    // jwt
    public static final String INVALID_JWT_SIGNATURE = "Invalid JWT signature";
    public static final String INVALID_JWT_TOKEN = "Invalid JWT token";
    public static final String EXPIRED_JWT_TOKEN = "Expired JWT token";
    public static final String UNSUPPORTED_JWT_TOKEN = "Unsupported JWT token";
    public static final String EMPTY_JWT_CLAIMS_STRING = "Empty JWT claims string";
}
