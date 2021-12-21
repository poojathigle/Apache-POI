package exceloperations;

import java.util.ArrayList;
import java.util.List;

public class ExampleTriggers {

	public static List<Trigger> getListOfTriggers() {
		
		List<Trigger> list = new ArrayList<>();
		
		Trigger sampleTrigger;
		sampleTrigger = new Trigger("ARPSMS-CERT",	"jwcpfetwmis03","Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("ARPSMS-CERT",	"jwcpfetwmis04","Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("HealthCheck-CERT",	"jwcpfetwmis05","Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("OnBoard Advisor", "jwcpdiswmis09_OA","Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("OnBoard Advisor", "jwcpdiswmis10_OA","Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("OnBoard Advisor", "jwcpdiswmis11_OA","Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("OnBoard Advisor", "jwcpdiswmis12_OA","Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("ESF Accel",	"jwcpdiswmis44_POD2","Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("ESF Accel",	"jwcpdiswmis45_POD2","Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("ESF Accel",	"jwcpdiswmis48_POD5","Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("ESF Accel",	"jwcpdiswmis49_POD5","Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("Checkfree Pay", "jwcpdiswmis08_CFP", "Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("Checkfree Pay", "jwcpdiswmis09_CFP", "Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("SCV 5X", "jwcpdiswmis21_SCV5X", "Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("SCV 5X", "jwcpdiswmis22_SCV5X", "Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("SCV 5X", "jwcpdiswmis23_SCV5X", "Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("SCV 5X", "jwcpdiswmis24_SCV5X", "Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("SCV 5X", "jwcpdiswmis25_SCV5X", "Comment");
		list.add(sampleTrigger);
		sampleTrigger = new Trigger("SCV 5X", "jwcpdiswmis26_SCV5X", "Comment");
		list.add(sampleTrigger);
	    
		return list;
		
	}

}
