package utilitescontainer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.jiochat.constants.ConstantsCollection;
import com.jiochat.enums.ConfigProperties;

public class ReadPropertyFile {
	
	private ReadPropertyFile()
	{
		
	}
	
//	public static String readProperty(String key) throws Exception
//	{
//		Properties property = new Properties();
//		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"src\\main\\java\\utilitescontainer\\ReadPropertyFile.java");
//		property.load(file);
//		String value =property.getProperty(key);
//		if(Objects.isNull(value))
//		{
//			throw new Exception ("Property name" + key + "does not exist. Please check FrameworkProperties.properties");
//		}
//		return value ;
//		
//	}
	
	private static Properties property = new Properties();
	private static final  Map<String, String> CONFIGMAP = new HashMap<String, String>();
	
	static
	{
		try
		{
			FileInputStream file = new FileInputStream(ConstantsCollection.getConfigPath());
			property.load(file);
			for(Map.Entry<Object, Object> entries : property.entrySet())
				CONFIGMAP.put(String.valueOf(entries.getKey()), String.valueOf(entries.getValue()).trim());
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static String get(ConfigProperties key) throws Exception
	{
		if(Objects.isNull(key.name().toLowerCase())|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
				throw new Exception ("Property name" + key + "does not exist. Please check FrameworkProperties.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
		
	}

}
