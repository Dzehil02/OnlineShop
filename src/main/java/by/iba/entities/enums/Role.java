package by.iba.entities.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	
		ROLE_SELLER,
		ROLE_CUSTOMER;
		
		@Override
		public String getAuthority() {
			return name();
		}
	
}
