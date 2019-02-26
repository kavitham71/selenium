package iTestContext;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataproviderClass {

	@DataProvider(name = "SearchProvider")
	public static Object[][] getDataFromDataprovider(ITestContext c) {
		Object[][] groupArray = null;
		for (String group : c.getIncludedGroups()) {
			System.out.println("Group name: "+group);
			if(group.equalsIgnoreCase("A")){
				groupArray = new Object[][] { 
					{ "mgr123", "mgr!23" }, { "b", "aa" }
					};
			break;	
			}
				else if(group.equalsIgnoreCase("B"))
				{
					return new Object[][] { { "mgr123", "mgr!23" }, { "d", "abc" }
						};
				}
			break;
		}
		return groupArray;		
		}
}


