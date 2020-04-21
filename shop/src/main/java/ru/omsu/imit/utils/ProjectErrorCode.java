package ru.omsu.imit.utils;

public enum ProjectErrorCode {
    WRONG_FIRSTNAME("firstName","FIRSTNAME_IS_EMPTY"),
    WRONG_LASTNAME ("lastName","LASTNAME_IS_EMPTY"),
    WRONG_PRODUCT_NAME("productName","PRODUCT_NAME_IS_EMPTY"),
    WRONG_COST("cost","COST_LESS_OR_EQUALS_ZERO"),
    WRONG_QUANTITY("quantity","QUANTITY_LESS_OR_EQUALS_SERO"),
    WRONG_EMAIL("email","EMAIL_IS_EMPTY"),
    WRONG_BIRTHDAY("birthday","BIRTHDAY_IS_NULL)"),
    NULL_BASKET("basket","BASKET_IS_NULL"),
    NULL_PAYMENT("payment","PAYMENT_IS_NULL"),
    WRONG_REQUEST("request","REQUEST DON'T HAVE ENOUGH FIELDS FOR JSON DESERIALIZATION"),
    SUCCESS("", ""),
    ITEM_NOT_FOUND("item", "Item not found %s"),
    NULL_REQUEST("json", "Null request"),
    JSON_PARSE_EXCEPTION("json", "Json parse exception :  %s"),
    WRONG_URL("url", "Wrong URL"),
    METHOD_NOT_ALLOWED("url", "Method not allowed"),
    UNKNOWN_ERROR("error", "Unknown error"),;
    private String field;
    private String message;

    private ProjectErrorCode(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
