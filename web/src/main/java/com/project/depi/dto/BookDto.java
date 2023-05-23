package com.project.depi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel("Book")
public class BookDto {

    @ApiModelProperty(value = "Book's identifier")
    private Long id;

    @ApiModelProperty(value = "Author's last name")
    private String lastName;

    @ApiModelProperty(value = "Author's first name")
    private String firstName;

    @ApiModelProperty(value = "Book's title", required = true)
    private String title;
}
