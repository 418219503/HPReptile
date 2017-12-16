package ragdoll.cat.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ragdoll.cat.model.HousePriceModel;

public class FileUtil {
	
	public static void writeToFile(String fileName,List<HousePriceModel> housePriceModels)
	{
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw); 
			for (HousePriceModel housePriceModel : housePriceModels) {
				bw.write(JsonUtil.objectToJson(housePriceModel));   
			    bw.newLine(); 
			}
		    
		    if(bw != null)
				bw.close();
		    if(fw != null)
		    		fw.close();
		} catch (IOException e) {
			System.out.println("文件" + fileName + "写失败:" + e.getCause().toString());
		}
	      
	}
}
