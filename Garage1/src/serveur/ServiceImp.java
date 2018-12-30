package serveur;

import java.util.HashMap;
import java.util.Map;
import GarageCorba.IGarageRemotePOA;
import GarageCorba.Voiture;

public class ServiceImp extends IGarageRemotePOA {

	
	public Map <String, Voiture> mesVoitures = new HashMap<String, Voiture>();
	
	@Override
	public Voiture[] afficheVoitures() 
	{
		if (mesVoitures.size() > 0) 
		{
			Voiture [] tab = new Voiture[mesVoitures.size()];	
			int i = 0;
			for(Map.Entry <String, Voiture> entry : mesVoitures.entrySet()) 
			{
			    tab[i] = entry.getValue();
			    i++;
			}
			return tab;
		} 
		else
		{
			Voiture[] tab = new Voiture[1];
			tab[0] = new Voiture("default","default");
			return tab;
		}
		
	}
	
	@Override
	public void Restituer(Voiture v) 
	{
		mesVoitures.put(v.name, v);
	}
	@Override
	public void Louer(Voiture v)
	{
		mesVoitures.remove(v.name);	
	}
	
	@Override
	public Voiture maVoiture(String name) 
	{
		// TODO Auto-generated method stub
		return mesVoitures.get(name);
	}

}
