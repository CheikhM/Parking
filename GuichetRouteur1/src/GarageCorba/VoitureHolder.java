package GarageCorba;

/**
* GarageCorba/VoitureHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Garage.idl
* vendredi 14 décembre 2018 23 h 15 WET
*/

public final class VoitureHolder implements org.omg.CORBA.portable.Streamable
{
  public GarageCorba.Voiture value = null;

  public VoitureHolder ()
  {
  }

  public VoitureHolder (GarageCorba.Voiture initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = GarageCorba.VoitureHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    GarageCorba.VoitureHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return GarageCorba.VoitureHelper.type ();
  }

}
