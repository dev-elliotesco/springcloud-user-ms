package com.user.ms.dto;

import com.user.ms.utils.MessageUtils;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// RECORD TODO
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotBlank
    @NotEmpty
    @Size(min = 2,max = 10)
    @Pattern(regexp = "^(?:CC|CE)$" , message = MessageUtils.TYPE_DOCUMENT_CONSTRAINT)
    private String typeDocument;

    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 10, message = MessageUtils.DOCUMENT_SIZE_CONSTRAINT)
    @Pattern(regexp = "^\\d*$" , message = MessageUtils.ONLY_NUMBERS_ALLOWED)
    private String document;

    @NotBlank
    @NotEmpty
    @Size(min = 3,max = 8, message = MessageUtils.NAME_SIZE_CONSTRAINT)
    private String name;
}
