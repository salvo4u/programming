import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class GeoData {
	
	String customerId;
	
	String contractId;
	
	String geozone;
	
	String teamcode;
	
	String projectcode;
	
	float duration,avgduration;
	
}

public class Excercise {
	public static void getContractData(HashMap<String, HashMap<String, List<GeoData>>> map) {
		// forEach(action) method to iterate map
		System.out.println("The number of unique customerId for each contractId.");
		for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			HashMap<String, List<GeoData>> cmap = map.get(key);
			System.out.println(key + " ---> " + cmap.keySet().size());
		}
		System.out.println();
	}

	public static void getGeoZoneData(HashMap<String, HashMap<String, List<GeoData>>> map) {
		// forEach(action) method to iterate map
		System.out.println("The number of unique customerId for each geozone and avg build duration.");
		for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			HashMap<String, List<GeoData>> cmap = map.get(key);
			
			float duration = 0;
			int count = 0;
			for (Iterator<String> iterator2 = cmap.keySet().iterator(); iterator2.hasNext();) {
				String key1 = iterator2.next();
				List<GeoData> list = cmap.get(key1);
				for(int i=0;i<list.size();i++){
					duration+=list.get(i).duration;
					count++;
				}
			}
			float avgduration = (duration/count);
			System.out.println(key + " ---> " + cmap.keySet().size() + " " + cmap.keySet().toString() + "  " + avgduration +"s");
			
			
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n"
				+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n"
				+ "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n"
				+ "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n"
				+ "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";
		String strarr[] = str.split("\n");
		HashMap<String, HashMap<String, List<GeoData>>> geoMap = new HashMap<String, HashMap<String, List<GeoData>>>();
		HashMap<String, HashMap<String, List<GeoData>>> contractMap = new HashMap<String, HashMap<String, List<GeoData>>>();

		for (String s : strarr) {
			String lineArr[] = s.split(",");
			GeoData data = new GeoData();
			data.customerId = lineArr[0];
			data.contractId = lineArr[1];
			data.geozone = lineArr[2];
			data.teamcode = lineArr[3];
			data.projectcode = lineArr[4];
			data.duration = new Float(lineArr[5].substring(0, lineArr[5].length() - 1));
			// Initialize Data for Zome map
			HashMap<String, List<GeoData>> map = null;
			if (!geoMap.containsKey(data.geozone)) {
				map = new HashMap<String, List<GeoData>>();
				geoMap.put(data.geozone, map);
			}
			map = geoMap.get(data.geozone);
			if (!map.containsKey(data.customerId)) {
				ArrayList<GeoData> list = new ArrayList<GeoData>();
				map.put(data.customerId, list);
			}
			map.get(data.customerId).add(data);

			// Initialize Data for Contract Map
			if (!contractMap.containsKey(data.contractId)) {
				map = new HashMap<String, List<GeoData>>();
				contractMap.put(data.contractId, map);
			}
			map = contractMap.get(data.contractId);
			if (!map.containsKey(data.customerId)) {
				ArrayList<GeoData> list = new ArrayList<GeoData>();
				map.put(data.customerId, list);
			}
			map.get(data.customerId).add(data);
		}
		getContractData(contractMap);
		getGeoZoneData(geoMap);
	}
}
