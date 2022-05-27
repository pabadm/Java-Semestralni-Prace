package database;

import java.util.HashMap;
import java.util.Map;

public class Database {
	private Map<GroupEnum, GroupDatabase> elementsDatabase;

	public Database() {
		elementsDatabase = new HashMap<GroupEnum, GroupDatabase>();
	}

	public boolean setGroupDatabase(GroupEnum group) {
		if (elementsDatabase.put(group, new GroupDatabase()) == null)
			return true;
		else
			return false;
	}

	public GroupDatabase getGroupDatabase(GroupEnum group) {
		return elementsDatabase.get(group);
	}



	public void printDatabase() {
		System.out.println("=================================");
		System.out.println("\t---TECHNICAL---");
		elementsDatabase.get(GroupEnum.Technical).printGroupDatabase();
		System.out.println("\t---HUMANITARIAN---");
		elementsDatabase.get(GroupEnum.Humanitarian).printGroupDatabase();
		System.out.println("\t---COMBINED---");
		elementsDatabase.get(GroupEnum.Combined).printGroupDatabase();
//		System.out.println("=================================");
	}
}