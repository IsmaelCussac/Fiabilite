package item;

import java.util.ArrayList;

public class ItemsSortedListLaboratory {

	private ArrayList<Item> panierList;
	
	public ItemsSortedListLaboratory( ArrayList<Item> l){
		if (isSortedList(l)){
			this.panierList=l;
		} else {
			this.panierList=null;
		}
	}

	public boolean isSortedList(ArrayList<Item> l) {
		
		for(int i = 0; i < l.size() - 1; i++){
			if(l.get(i).greaterThanPrice(l.get(i+1))){
				return false;
			}
		}
		return true;
	}
	
}
