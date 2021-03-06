package GarageCorba;


/**
* GarageCorba/_IGarageRemoteStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Garage.idl
* vendredi 14 décembre 2018 23 h 04 WET
*/

public class _IGarageRemoteStub extends org.omg.CORBA.portable.ObjectImpl implements GarageCorba.IGarageRemote
{

  public void Restituer (GarageCorba.Voiture v)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Restituer", true);
                GarageCorba.VoitureHelper.write ($out, v);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                Restituer (v        );
            } finally {
                _releaseReply ($in);
            }
  } // Restituer

  public void Louer (GarageCorba.Voiture v)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Louer", true);
                GarageCorba.VoitureHelper.write ($out, v);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                Louer (v        );
            } finally {
                _releaseReply ($in);
            }
  } // Louer

  public GarageCorba.Voiture[] afficheVoitures ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("afficheVoitures", true);
                $in = _invoke ($out);
                GarageCorba.Voiture $result[] = GarageCorba.tabVoituresHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return afficheVoitures (        );
            } finally {
                _releaseReply ($in);
            }
  } // afficheVoitures

  public GarageCorba.Voiture maVoiture (String name)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("maVoiture", true);
                $out.write_string (name);
                $in = _invoke ($out);
                GarageCorba.Voiture $result = GarageCorba.VoitureHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return maVoiture (name        );
            } finally {
                _releaseReply ($in);
            }
  } // maVoiture

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:GarageCorba/IGarageRemote:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _IGarageRemoteStub
