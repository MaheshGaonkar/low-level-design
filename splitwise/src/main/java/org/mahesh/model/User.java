package org.mahesh.model;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private final String id;
    @Setter
    private String name;
}
