package GarageCorba;


/**
* GarageCorba/IGarageRemoteOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Garage.idl
* vendredi 14 décembre 2018 23 h 04 WET
*/

public interface IGarageRemoteOperations 
{
  void Restituer (GarageCorba.Voiture v);
  void Louer (GarageCorba.Voiture v);
  GarageCorba.Voiture[] afficheVoitures ();
  GarageCorba.Voiture maVoiture (String name);
} // interface IGarageRemoteOperations
