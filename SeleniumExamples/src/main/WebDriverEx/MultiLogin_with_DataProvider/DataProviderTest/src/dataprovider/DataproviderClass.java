package dataprovider;

import org.testng.annotations.DataProvider;

public class DataproviderClass {
	@DataProvider(name="SearchProvider")
    public static Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "mgr123", "mgr!23" },
            { "b", "aa" },
            
        };

    }


}

