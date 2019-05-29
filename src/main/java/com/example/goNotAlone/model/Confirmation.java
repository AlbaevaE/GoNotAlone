package com.example.goNotAlone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Confirmation {
    Long eventId;
    Long confirmUserId;
    int ConfirmationCode;


}
