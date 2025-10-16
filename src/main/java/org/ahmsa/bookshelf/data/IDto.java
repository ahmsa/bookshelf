package org.ahmsa.bookshelf.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface IDto {
    @JsonIgnore
    public Object getEntity();
}
