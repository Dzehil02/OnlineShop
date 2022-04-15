package by.iba.entities.enums;

public enum Category {
	
	ELECTRONICS,
	COMPUTERS,
	TECHNIQUE,
	INSTRUMENTS;
	
	public static Category getCategory(String value) {
		return Category.TECHNIQUE;
	}

}
