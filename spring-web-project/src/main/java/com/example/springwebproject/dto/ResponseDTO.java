package com.example.springwebproject.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class ResponseDTO {
    private Object data;
    @Setter(AccessLevel.PUBLIC)
    @Getter(AccessLevel.PUBLIC)
    private List<Object> errors;
    private String message;

    public ResponseDTO() {
        errors = new ArrayList<>();
    }

    public void addError(Object error) {
        if (getErrors() == null)
            setErrors(new ArrayList<>());
        getErrors().add(error);
    }

    @JsonIgnore
    public List<Object> getErrorsUnmodifiableList() {
        return Collections.unmodifiableList(errors);
    }

    public void removeResponse() {
        data = null;
    }

    public void removeErrors() {
        errors = null;
    }

    public boolean hasErrors() {
        return !this.getErrorsUnmodifiableList().isEmpty();
    }
}

