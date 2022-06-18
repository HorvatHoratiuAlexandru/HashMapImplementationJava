package hashMapImplementation;

public class myHashMap<k,v> {
	
	private final int SIZE = 7;
	private linkList<k,v> entryList[];
	
	myHashMap(){
		this.entryList = new linkList[SIZE];
	}
	
	private int keyHash(k keyToHash) {
		return Math.abs(keyToHash.hashCode() % 7);
	}
	
	public void put(k Key, v Value) {
		int index = keyHash(Key);
		if(entryList[index] == null) {
			entryList[index] = new linkList<k,v>();
			entryList[index].setLink(Key, Value);
		}else {
			entryList[index].addLink(Key, Value);
		}
	}
	
	public v get(k KeyForValue) {
		int index = keyHash(KeyForValue);
		if(entryList[index] == null) {
			return null;
		}else {
			linkList<k,v> link = entryList[index].transverseLink(KeyForValue);
			if(link.getKey().equals(KeyForValue)) {
				return link.getValue();
			}else if(link.nextLink == null) {

				return null;
			}
		}

		return null;
		
	}
	
	public void remove(k KeyToRemove) {
		int index = keyHash(KeyToRemove);
		if(entryList[index] != null) {
			if(KeyToRemove.equals(entryList[index].getKey()) && entryList[index].nextLink == null) {
				entryList[index] = null;
			}else {
				entryList[index].removeLink(KeyToRemove);
			}		
		}
	}
		
	public void printMap() {
		int index = 0;
		System.out.print("[");
		while(index < SIZE) {
			if(entryList[index] != null) {
				entryList[index].printLink();
			}
			index++;
		}
		System.out.println("]");
		
	}
	
///Inner class linkList
	
	public class linkList<k,v> {
		private k key;
		private v value;
		public linkList<k,v> nextLink;
		
		//Inner class constructor;
		linkList (){
			this.key = null;
			this.value = null;
			this.nextLink = null;
		}
		
		public void setLink(k keyToSet, v valueToSet) {
			this.key = keyToSet;
			this.value = valueToSet;

		}
		
		public void updateLink(k keyToCheck, v valueToUpdate) {
			if(this.key.equals(keyToCheck)) {
				this.value = valueToUpdate;

			}
		}
		
		public k getKey() {
			return this.key;
		}
		
		public v getValue() {
			return this.value;
		}
		
		
		public void addLink(k KeyToAdd, v ValueToAdd) {
			linkList<k,v> link = this.transverseLink(KeyToAdd);
			if(link.getKey().equals(KeyToAdd)) {
				link.updateLink(KeyToAdd, ValueToAdd);
			}else if(link.nextLink == null) {
				
				link.nextLink = new linkList<k,v>();
				link.nextLink.setLink(KeyToAdd, ValueToAdd);
			}	
		}
		
		public linkList<k,v> transverseLink(k KeyToGo){
			if(nextLink == null ) {
				return this;
			}
			linkList<k,v> link = this;
			while(null != link.nextLink && !KeyToGo.equals(link.getKey())) {
				link = link.nextLink;
			}
			
			return link;
		}
		
		public void printLink(){
			
			linkList<k,v> link = this;
			while(null != link) {
				System.out.print("(key:"+ link.getKey() + "  value:" + link.getValue() + ")");
				link = link.nextLink;
			}
			
		}
		
		public void removeLink(k KeyToRemove) {
			linkList<k,v> parentLink = this;
			linkList<k,v> childLink = null;
			linkList<k,v> removeLink = this.nextLink;
			
			if(KeyToRemove.equals(removeLink.getKey())) {
				childLink = removeLink.nextLink;
				parentLink.nextLink = childLink;	
			}else if(removeLink.nextLink != null) {
				removeLink.removeLink(KeyToRemove);
			}		
			
		}
		
	}


}
