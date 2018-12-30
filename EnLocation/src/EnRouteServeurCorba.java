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

public class EnRouteServeurCorba {

	public static void main(String[] args) {

		try {
			
			ORB orb = ORB.init(args,null);
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.the_POAManager().activate();
		
			//implememter la class ServerImpl
			ServiceImp service_imp = new ServiceImp();
			
			//JNDI
			Context context = new InitialContext();
			
			//__publier lq reference 
			Object ref = rootPOA.servant_to_reference(service_imp);
			System.out.println(ref);
			context.rebind("EnRoute", ref);
			
			//_________________ affichage ____________
			Timer timer = new Timer(); 
		    TimerTask task = new TimerTask() {  
		          @Override
		           public void run() {  

		        	  	System.out.println("Les voitures en locations: ");
						Voiture [] cars = service_imp.afficheVoitures();
						if (cars[0].name.equals("default")) {	
							//Nothing to do !
						} 	
						else
						{
							for (Voiture voiture : cars)
							{
								System.out.print("[ " + voiture.name + "," + voiture.src_garage + " ]; ");	
							}	
							System.out.println("\n");
						}

		          	}
		    };
		    timer.schedule(task,0,3000);
			
		} 
		catch (Exception  e) 
		{
			e.printStackTrace();
		}
}
	
}