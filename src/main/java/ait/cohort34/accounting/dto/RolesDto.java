package ait.cohort34.accounting.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class RolesDto {
    private String login;
    private List<String> roles;
}
