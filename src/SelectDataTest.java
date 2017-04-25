import beans.NavigationBean;

import db.Category;


public class SelectDataTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NavigationBean navi = new NavigationBean();
		Category[] cats = navi.getAllCategories();
		for(Category cat : cats){
			
			System.out.println(cat.getName());
		}
		
	}
		

}
