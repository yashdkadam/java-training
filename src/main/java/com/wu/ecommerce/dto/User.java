package com.wu.ecommerce.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String userId;
	private String firstName;
	private String lastName;
	private long contactNumber;
}
