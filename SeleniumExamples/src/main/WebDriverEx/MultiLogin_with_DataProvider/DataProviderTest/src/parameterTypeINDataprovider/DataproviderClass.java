package parameterTypeINDataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataproviderClass {

	@DataProvider(name = "SearchProvider")
	public static Object[][] getDataFromDataprovider(Method m) {
		if (m.getName().equalsIgnoreCase("testMethodA")) {
			return new Object[][] { { "mgr123", "mgr!23" }, { "b", "aa" }

			};
		} else {
			return new Object[][] { { "mgr123", "mgr!23" }, { "d", "abc" }

			};
	}}

}
