package mvc_test.customer_test;

import java.util.List;

public class Menu {

	private final List<MenuItem> menuItems;
	public Menu(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public MenuItem choose(String menu) {

		return this.menuItems.stream()
			.filter(menuItem -> menuItem.matches(menu))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 입니다."));
	}
}
