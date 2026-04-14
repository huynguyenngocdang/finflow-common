package com.huynguyenngocdang.commons.api.response;

public record ResponseApi<T>(ResponseStatus status, T data, ResponseMetadata metadata) {
    public static <T> ResponseApi<T> success(T data) {
        ResponseStatus status = ResponseStatus.success();
        ResponseMetadata metadata = ResponseMetadata.current();
        return new ResponseApi<>(status, data, metadata);
    }
    public static <T> ResponseApi<T> fail(String code, String message) {
        ResponseStatus status = ResponseStatus.fail(code, message);
        ResponseMetadata metadata = ResponseMetadata.current();
        return new ResponseApi<>(status, null, metadata);
    }

    public static <T> ResponseApi<T> fail(T data, String code, String message) {
        ResponseStatus status = ResponseStatus.fail(code, message);
        ResponseMetadata metadata = ResponseMetadata.current();
        return new ResponseApi<>(status, data, metadata);
    }
}
