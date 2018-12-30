
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import GarageCorba.IGarageRemote;
import GarageCorba.IGarageRemoteHelper;
import GarageCorba.Voiture;

public class GuichetLocationCorba {

	public static void main(String[] args) {
		try 
		{	
			//jndi 
			Context context = new InitialContext();
			
			// pour la location
			Object objenroute = context.lookup("EnRoute");
			IGarageRemote stubroute = IGarageRemoteHelper.narrow((org.omg.CORBA.Object)objenroute);
			
			// pour le garage
			Object obj = context.lookup("Garage1");
			IGarageRemote stub = IGarageRemoteHelper.narrow((org.omg.CORBA.Object)obj);

			afficher(stub, stubroute);
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void afficher(IGarageRemote garage, IGarageRemote enroute) {
	
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Entrez une commande { 0 pour afficher, 1 pour louer }");
			int commande = sc.nextInt();
			
			if(commande == 0) {

				//afficher les voitures disponibles
				Voiture [] disponible = garage.afficheVoitures();					
				if(disponible.length == 0)
				{
					System.out.println("le Garage est vide!");
				} 
				else 
				{
					for (Voiture voiture : disponible) 
					{
						System.out.println("[ " + voiture.name + ", " + voiture.src_garage + " ]; ");
					}
				}
				
				
			}
			
			else if(commande == 1) {
				// louer une voiture
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Entrez le nom de la voiture svp !!!");
				String name = sc2.nextLine();
				Voiture voiture = garage.maVoiture(name);
				garage.Louer(voiture);
				enroute.Restituer(voiture);
				System.out.println("la voiture est bien louée!");
				continue;
			}
			
			else {
				System.out.println("Commande Erreur !");		
			}	
		}		
	}
}
