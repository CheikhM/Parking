//start tnameserv -ORBInitialPort 1050

import java.util.Timer;
import java.util.TimerTask;

import javax.naming.Context;
import javax.naming.InitialContext;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import GarageCorba.Voiture;
import serveur.ServiceImp;
public class ServeurCorba {
	
	public static void main(String[] args) 
	{
		try {
			/*
			 * 
			 * An object adapter is the mechanism 
			 * that connects a request using an object 
			 * reference with the proper code to service that request.
			 *  The Portable Object Adapter, or POA, 
			 *  is a particular type of object adapter that is defined by the CORBA specification.
			 *   The POA is designed to meet the following goals
			 */
			
			ORB orb = ORB.init(args,null);		
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.the_POAManager().activate();
	
			ServiceImp service_imp = new ServiceImp();
		
			//Create three cars			
			service_imp.mesVoitures.put("MERCEDES CDI", new Voiture("Garage1","MERCEDES CDI"));
			service_imp.mesVoitures.put("TOYOTA AVENSIS", new Voiture("Garage1","TOYOTA AVENSIS"));
			service_imp.mesVoitures.put("COROLLA 2014", new Voiture("Garage1","COROLLA 2014"));
			
			/*----JNDI--------*/
			Context context = new InitialContext();
			
			//Publier la reference 
			Object reference = rootPOA.servant_to_reference(service_imp);
			context.rebind("Garage1", reference);
			
			
			Timer timer = new Timer(); 
		    TimerTask task = new TimerTask() {  
		          @Override
		           public void run() {  
			  			System.out.println("Les voitures dans garage: ");
						Voiture [] cars = service_imp.afficheVoitures();
						if (cars[0].name.equals("default")) {	
							//Nothing to do !
						} 	
						else
						{
							for (Voiture voiture : cars)
							{
								System.out.print(voiture.name + ",");	
							}	
							System.out.println("\n");
						}
		          }
		    };
		    timer.schedule(task,0,5000);			
					
		} 
		catch (Exception  e) 
		{
			e.printStackTrace();
		}
 }
	
	
}