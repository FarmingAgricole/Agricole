package agrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Field {
	private HashMap<Integer, Crop> crops = new HashMap<Integer, Crop>();

public Field() {
	
}

public void addCrop(int position, int choice) {
	if (choice == 1) {
	crops.put(position, new Carrot(70,2));
	}
	else if (choice ==2) {
		crops.put(position, new Strawberry(70,2));
	}
}

public void removeCrop(int position) {
	crops.remove(position);
}

public int whichCrop(int number) {
	int res = 0;
	Crop c = accesValue(number);
	if(c == null) {
		res = 0;
	} else if (c instanceof Carrot ) {
		res = 1;
	} else if (c instanceof Strawberry) {
		res = 2;
	}
	return res;
}

public String updateStatus(int number) {
	Crop c = accesValue(number);
	return c.toString();
}

public int getSize() {
	return crops.size();
}

public Crop accesValue(int number) {
	Crop c = (Crop)crops.get(number);
	return c;
}

public static void main(String[] args) throws IOException {
	Field fields = new Field();
	fields.addCrop(1,1);
	System.out.println(fields.accesValue(1).toString());
	fields.accesValue(1).getOlder();
	System.out.println(fields.accesValue(1).toString());
}
}
