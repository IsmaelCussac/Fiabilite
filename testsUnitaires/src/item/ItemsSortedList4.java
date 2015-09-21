package item;

import java.util.ArrayList;

public class ItemsSortedList4 {

	private ArrayList<Item> panierList;

	/*
	 * a successful build requires that the argument is sorted
	 * otherwise the attribute panierList is set to null 
	 */
	public ItemsSortedList4( ArrayList<Item> l){
		if (isSortedList(l)){
			this.panierList=l;
		} else {
			this.panierList=null;
		}
	}
	/*
	 * @param list to test
	 * @return true iff the list is sorted according to the price of items
	 * */
	private boolean isSortedList(ArrayList<Item> l){
		/*TODO*/
		return true;
	}
	/*
	 * Performs a dichotomic search since panierList is always sorted 
	 * @param item the Item we are looking for
	 * @return true iff item occurs in the list
	 */
	public boolean isPresentArticle(Item item){	
		int sizePanier=this.panierList.size();
		int i=0;
		int j=sizePanier-1;
		int m;
		while (i<=j) {
			m=(i+j)/2;
			if (this.panierList.get(m).lessThanPrice(item)){
				i=m+1;
			}
			if (this.panierList.get(m).isSameArticle(item)){
				return true;
			}	
			if (this.panierList.get(m).greaterThanPrice(item)){
				j=m-1;
			}
			if (i>sizePanier-1 || j<0){
				return false;
			}
		}
		return false;
	}	

	
	
	
	
	
}
