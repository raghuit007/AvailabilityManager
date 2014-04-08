import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.tempuri.* ;

import com.vmware.vim25.mo.ServiceInstance;

public class AvailabilityManager
{
   
   // static String host = "t06-vHost02_cum1-lab2_.132.182";
	public static void ping(String host ) throws IOException
    {
       System.out.println( "Ping Host: " + host ) ;
       
    }
    
    
    public static void main(String args[])
    {
    	
    	try {
			URL url = new URL("https://130.65.132.181/sdk");
			ServiceInstance si = new ServiceInstance(url,"root","12!@qwQW",true);
			
			String host = si.toString();
			
			try {
				AvailabilityManager.ping(host);
			} catch (IOException e) {
				System.out.println("generic IO exception");
				e.printStackTrace();
			}
    	} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
