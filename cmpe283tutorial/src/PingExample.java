// package com.vmware.vim25.mo.samples;

import java.util.Scanner;
import java.util.Timer;
import java.util.Date;
import java.util.TimerTask;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import api.ovs.oracle.types.VmStatus;

import com.vmware.vim25.Action;
import com.vmware.vim25.AlarmAction;
import com.vmware.vim25.AlarmSetting;
import com.vmware.vim25.AlarmSpec;
import com.vmware.vim25.AlarmTriggeringAction;
import com.vmware.vim25.CustomizationFault;
import com.vmware.vim25.Description;
import com.vmware.vim25.DuplicateName;
import com.vmware.vim25.FileFault;
import com.vmware.vim25.GroupAlarmAction;
import com.vmware.vim25.HostConfigInfo;
import com.vmware.vim25.HostConfigSummary;
import com.vmware.vim25.HostConnectInfo;
import com.vmware.vim25.HostConnectSpec;
import com.vmware.vim25.HostListSummary;
import com.vmware.vim25.HostRuntimeInfo;
import com.vmware.vim25.HostSystemHealthInfo;
import com.vmware.vim25.HostSystemInfo;
import com.vmware.vim25.HostSystemPowerState;
import com.vmware.vim25.HostVMotionCompatibility;
import com.vmware.vim25.InsufficientResourcesFault;
import com.vmware.vim25.InvalidDatastore;
import com.vmware.vim25.InvalidName;
import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedEntityStatus;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.MethodAction;
import com.vmware.vim25.MethodActionArgument;
import com.vmware.vim25.MigrationFault;
import com.vmware.vim25.OutOfBounds;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.SendEmailAction;
import com.vmware.vim25.SnapshotFault;
import com.vmware.vim25.StateAlarmExpression;
import com.vmware.vim25.StateAlarmOperator;
import com.vmware.vim25.TaskInProgress;
import com.vmware.vim25.TaskInfo;
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDeviceConfigSpec;
import com.vmware.vim25.VirtualDeviceConfigSpecFileOperation;
import com.vmware.vim25.VirtualDeviceConfigSpecOperation;
import com.vmware.vim25.VirtualDisk;
import com.vmware.vim25.VirtualDiskFlatVer2BackingInfo;
import com.vmware.vim25.VirtualEthernetCard;
import com.vmware.vim25.VirtualEthernetCardNetworkBackingInfo;
import com.vmware.vim25.VirtualLsiLogicController;
import com.vmware.vim25.VirtualMachineCapability;
import com.vmware.vim25.VirtualMachineCloneSpec;
import com.vmware.vim25.VirtualMachineConfigInfo;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualMachineFileInfo;
import com.vmware.vim25.VirtualMachineMovePriority;
import com.vmware.vim25.VirtualMachinePowerState;
import com.vmware.vim25.VirtualMachineQuickStats;
import com.vmware.vim25.VirtualMachineRelocateDiskMoveOptions;
import com.vmware.vim25.VirtualMachineRelocateSpec;
import com.vmware.vim25.VirtualMachineRelocateSpecDiskLocator;
import com.vmware.vim25.VirtualMachineRuntimeInfo;
import com.vmware.vim25.VirtualMachineSummary;
import com.vmware.vim25.VirtualPCNet32;
import com.vmware.vim25.VirtualSCSISharing;
import com.vmware.vim25.VmConfigFault;
import com.vmware.vim25.mo.AlarmManager;
import com.vmware.vim25.mo.ComputeResource;
import com.vmware.vim25.mo.Datacenter;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostHealthStatusSystem;
import com.vmware.vim25.mo.HostPowerSystem;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ResourcePool;
import com.vmware.vim25.mo.ServerConnection;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

public class PingExample
{

    static String vCenterIP= "130.65.132.180";
	static String vCenterURL= "https://" + vCenterIP + "/sdk";
	static String userName= "administrator";
	static String password="12!@qwQW";
	static String datacenterName="Team06_DC";
	
	
	
	        /* Getting the vhost details, given the vCener IP*/
	
	public static void getvHostStatus(ServiceInstance si)
	{
		Folder rootFolder = si.getRootFolder();
		InventoryNavigator navigator = new InventoryNavigator(rootFolder);
		ManagedEntity[] mes=null;
		try {
		       mes = navigator.searchManagedEntities("HostSystem");
		       
		       
		       
		       for(int i=0;i<mes.length;i++)
		       {
		    	   if(mes[i] instanceof HostSystem)
					{
		    		   HostSystem hs = (HostSystem) mes[i];
						System.out.println("The names of  vhost is" +hs.getName());
						System.out.println("Powering ON the vhosts, in case they are not powered on...");
					}
		    	   
		       }
		} catch (InvalidProperty e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("The host is not alive....");
			e.printStackTrace();
		}
	
	
}
		       
		       
		       
		       
		       
		/* method to restar the vhost from the admin console */
	
	public static void powerOnHost(ServiceInstance si)
    {
		Folder rootFolder = si.getRootFolder();
		InventoryNavigator navigator = new InventoryNavigator(rootFolder);
		ManagedEntity mes=null;
		ManagedEntity mes1=null;
		try {
		       mes = navigator.searchManagedEntity("VirtualMachine","t06-vHost02_cum1-lab2_.132.182");
		       VirtualMachine vm = (VirtualMachine ) mes;
		       
		       Task task = vm.powerOnVM_Task(null);
		       
		       if(task.waitForMe()=="SUCCESS");
		       {
		         System.out.println("the host is powered on successfully");
		       }
		       
		       
    }catch (InvalidProperty e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (RuntimeFault e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	
	
	try {
	       mes1 = navigator.searchManagedEntity("VirtualMachine","t06-vHost01-cum1-lab1 _.132.181");
	       VirtualMachine vm1 = (VirtualMachine ) mes1;
	       
	       Task task = vm1.powerOnVM_Task(null);
	       
	       if(task.waitForMe()=="SUCCESS");
	       {
	         System.out.println("the host is powered on successfully");
	       }
	       
	       
}catch (InvalidProperty e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (RuntimeFault e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (RemoteException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	

	
	         /* Getting the VM given the vCenter URL */
	public static VirtualMachine getVM(ServiceInstance si)
	{
		Folder rootFolder = si.getRootFolder();
		InventoryNavigator navigator = new InventoryNavigator(rootFolder);
		ManagedEntity mes=null;
		try {
		       mes = navigator.searchManagedEntity("VirtualMachine","Team06_ubuntu_RK_Clone");
		       
		
		
		} catch (InvalidProperty e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RuntimeFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return (VirtualMachine) mes;
		
	}

	 /* Getting the status of the VM, that is , if the VM is powered off or not*/
	
	public static String getVMPowerDetails(VirtualMachine vm) throws RemoteException
	{
		String status = null;
		
		
		status = vm.getGuestHeartbeatStatus().toString();
		// System.out.println(status);
		if(status.equalsIgnoreCase("gray"))
			System.out.println("The VM is not powered on. Checking the vHost for power.");
		
		
		
	
		return status;
	}
	
	
	
	
	/* GEtting the VM power details, given a vCenter IP*/
	
	public static void getPowerDetails(ServiceInstance s)
	{
		Folder rootFolder = s.getRootFolder();
		int counter=0;
		
		
		try{
		ManagedEntity[] mes = rootFolder.getChildEntity();
		
	
		for(int i=0; i<mes.length; i++)
		{
			if(mes[i] instanceof Datacenter)
			{
				Datacenter dc = (Datacenter) mes[i];
				Folder vmFolder;
				
					vmFolder = dc.getVmFolder();
					ManagedEntity[] vms = vmFolder.getChildEntity();
					String[] isAlive= new String[vms.length];
					for(int j=0; j<vms.length; j++)
					{
						if(vms[j] instanceof VirtualMachine)
						{
							VirtualMachine vm = (VirtualMachine) vms[j];
							
							isAlive[j]=vm.getGuestHeartbeatStatus().toString();
							
							if(isAlive[j].equalsIgnoreCase("green"))
							{
								 isAlive[j]="alive";
							}
							else
								isAlive[j]=" not alive";
							System.out.println("The vm " + vm.getName() + " is " +isAlive[j]);
							
						}
		                
						
					}
					
					}
				}
							
					}catch (InvalidProperty e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (RuntimeFault e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	     }
					
					
					
		 /*Getting the configuration details like CPU, I/O and memory */
	
	public static void getConfiguration(VirtualMachine vm)
	{
		VirtualMachineConfigInfo vmc = vm.getConfig();
		VirtualMachineCapability vmCapability = vm.getCapability();
		System.out.println("virtual machine name:" + vmc.getName());
		System.out.println("Number of CPUs:" +vmc.getHardware().numCPU);
		System.out.println("Memory status:" +vmc.getHardware().memoryMB);
		System.out.println("Guest OS name:"+ vmc.getGuestFullName());
		System.out.println("Multiple snapshot supported?" + vmCapability.isMultipleSnapshotsSupported());
		System.out.println("ip address:" + vm.getGuest().ipAddress);
	}
	
	
	  /* Method to take a snapshot for the VM for every 10 minutes */
	public static void takeSnapshot(VirtualMachine vm)
	{
		String snapshot = vm.getName()+"_snapShot";
		try {
			Task task = vm.createSnapshot_Task(snapshot,"This is a snapshot", false, false);
			if(task.waitForMe()==Task.SUCCESS)
		      {
		        System.out.println("Snapshot was created for the VM:" +vm.getName());
		      }
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VmConfigFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SnapshotFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaskInProgress e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidState e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	   /* Migrating the VM from one host to other , in case a host fails */
	
	public static void migrateVM(VirtualMachine vm,ServiceInstance serviceInst1, String fromClone) throws InvalidProperty, RuntimeFault, RemoteException,InterruptedException 
	{
		
		System.out.println("Migrating the cloned VM... : " + fromClone);
		

		String vmName = vm.getName();
		Folder rootFolder = serviceInst1.getRootFolder();

		VirtualMachine newVM = (VirtualMachine) new InventoryNavigator(rootFolder).searchManagedEntity("VirtualMachine", fromClone); 

		HostSystem newHost = (HostSystem) new InventoryNavigator(rootFolder)
				.searchManagedEntity("HostSystem", "130.65.132.182");
		

		 ComputeResource cr = (ComputeResource) newHost.getParent();
		
		 
	    
	    String[] checks = new String[] {"cpu", "software"};
		HostVMotionCompatibility[] vmcs = serviceInst1.queryVMotionCompatibility(newVM, new HostSystem[] 
						{newHost },checks);
		String[] comps = vmcs[0].getCompatibility();
		if (checks.length != comps.length) 
		{
			System.out.println("Error - CPU/software NOT compatible. Exit.");
			
			
		}

		// TargetResPool, TargetHost, Priority, State
		Task task = newVM.migrateVM_Task(cr.getResourcePool(), newHost,
				VirtualMachineMovePriority.highPriority,
				VirtualMachinePowerState.poweredOff);

		if (task.waitForTask().equalsIgnoreCase(Task.SUCCESS)) 
		{
			System.out.println("Migrating : " + vmName
					+ " has been migrated successfully!");
			newVM.powerOnVM_Task(null);
		
			
			
			
		} else {
			System.out.println("VM could not be migrated!");
			TaskInfo info = task.getTaskInfo();
			System.out.println(info.getError().getFault());
			throw new RuntimeException("Error - VM could not be migrated!");
		}

	}
	
	
		    
		        /* Taking the clone of the VM */
	
	public static void createClone(VirtualMachine vm, ServiceInstance si1)
	{
		String clone = vm.getName()+"_clone";
		
		
		try {
			
		   VirtualMachineCloneSpec cloneSpec = new VirtualMachineCloneSpec();
		   cloneSpec.setLocation(new VirtualMachineRelocateSpec());
		   
		   
		   cloneSpec.setPowerOn(false);
	       cloneSpec.setTemplate(false);
		   Folder  f  = (Folder)vm.getParent();
		  
		  Task task = vm.cloneVM_Task(f,clone, cloneSpec);
			@SuppressWarnings("deprecation")
			String status = 	task.waitForMe();
			   if(status==Task.SUCCESS)
			   {
		            System.out.println("Virtual Machine got cloned successfully.");
			   }
			   else
			   {
				   System.out.println("Failure -: Virtual Machine cannot be cloned");
			   }
			
		} catch (VmConfigFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaskInProgress e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CustomizationFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidState e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InsufficientResourcesFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MigrationFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDatastore e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		  
		  
	} 
	
	
	 /* methods to set alarm for a vm */
	
	
	
	  public static StateAlarmExpression createStateAlarmExpression()
	    {
	      StateAlarmExpression expression = 
	        new StateAlarmExpression();
	      expression.setType("VirtualMachine");
	      expression.setStatePath("runtime.powerState");
	      expression.setOperator(StateAlarmOperator.isEqual);
	      expression.setRed("poweredOff");
	      return expression;
	    }

	    public static MethodAction createPowerOnAction() 
	    {
	      MethodAction action = new MethodAction();
	      action.setName("PowerOnVM_Task");
	      MethodActionArgument argument = new MethodActionArgument();
	      argument.setValue(null);
	      action.setArgument(new MethodActionArgument[] { argument });
	      return action;
	    }
	    
	   public  static SendEmailAction createEmailAction() 
	    {
	      SendEmailAction action = new SendEmailAction();
	      action.setToList("raghu.it007@gmail.com");
	      action.setCcList("raghavendra.vn512@gmail.com");
	      action.setSubject("Alarm - {alarmName} on {targetName}\n");
	      action.setBody("Description:{eventDescription}\n"
	          + "TriggeringSummary:{triggeringSummary}\n"
	          + "newStatus:{newStatus}\n"
	          + "oldStatus:{oldStatus}\n"
	          + "target:{target}");
	      return action;
	    }

	    public static AlarmTriggeringAction createAlarmTriggerAction(
	        Action action) 
	    {
	      AlarmTriggeringAction alarmAction = 
	        new AlarmTriggeringAction();
	      alarmAction.setYellow2red(true);
	      alarmAction.setAction(action);
	      return alarmAction;
	    }   
	
	
	   /* Creating an alarm in case the VM fails(does not create when the VM is powered off by the user) */
	
	public static void setAlarmAtPowerOff(ServiceInstance siMigrate)
	{
		Folder rootFolder = siMigrate.getRootFolder();
		InventoryNavigator navigator = new InventoryNavigator(rootFolder);
		ManagedEntity mes=null;
		String nicName = "E1000";
		String op = "remove";
	
		    try {  
		    mes = navigator.searchManagedEntity("VirtualMachine","Team06_ubuntu_RK_Clone");
		       VirtualMachine vm = (VirtualMachine) mes;
		   
		      
		     
	          

		    
		    	      
		     /* once NIC is disabled, create an alarm*/
		    	      
		   	      AlarmManager alarmMgr = siMigrate.getAlarmManager();
		    	      
		    	      AlarmSpec spec = new AlarmSpec();
		    	      
		    	      StateAlarmExpression expression = createStateAlarmExpression();
		    	      AlarmAction emailAction = createAlarmTriggerAction(
		    	          createEmailAction());
		    	      AlarmAction methodAction = createAlarmTriggerAction(
		    	          createPowerOnAction());
		    	      GroupAlarmAction gaa = new GroupAlarmAction();

		    	      gaa.setAction(new AlarmAction[]{emailAction, methodAction});
		    	      spec.setAction(gaa);
		    	      spec.setExpression(expression);
		    	      spec.setName("VmPowerStateAlarm");
		    	      spec.setDescription("Monitor VM state and send email " +
		    	      		"and power it on if VM powers off");
		    	      spec.setEnabled(true);    
		    	      
		    	      AlarmSetting as = new AlarmSetting();
		    	      as.setReportingFrequency(0); //as often as possible
		    	      as.setToleranceRange(0);
		    	      
		    	      spec.setSetting(as);
		    	      
		    	      alarmMgr.createAlarm(vm, spec);
		    	      
		    	      siMigrate.getServerConnection().logout();
		    	    
          } catch (InvalidProperty e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RuntimeFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	 } 
	
	
	
	
	
	
	
	    /* Simulating a vHost failure*/
	
	public static void vHostFailSimulation(ServiceInstance si)
    {
		Folder rootFolder = si.getRootFolder();
		InventoryNavigator navigator = new InventoryNavigator(rootFolder);
		ManagedEntity mes=null;
		String name = "130.65.132.182";
		try {
		       mes = navigator.searchManagedEntity("HostSystem",name);
		       
		      
		    		   HostSystem hs = (HostSystem) mes;
					hs.shutdownHost_Task(true);	
					
		    	   
		       
		} catch (InvalidProperty e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("The host is not alive....");
			e.printStackTrace();
		}
	
    }
	
	
	
	
	
	
	
	  /* Getting the service instance , given the vCenter IP */
	
	private static ServiceInstance getServiceInstance(String ip, String username, String password, boolean ignoreCert) {

		ServiceInstance si = null;
		try {
			URL u = new URL(ip);
			si = new ServiceInstance(u, username, password,ignoreCert);
		} catch (MalformedURLException e) {
			System.err.println("Incorrect URL");
			e.printStackTrace();
		} catch (RemoteException e) {
			System.err.println("Exception occurred while connecting");
			e.printStackTrace();
		}
		return si;
	}
	

	

	public static void main(String args[]) throws RemoteException
	{
		System.out.println("Press enter a choice alphabet on the operation you wish to perform");
		char menuOptions;
		Scanner sc = new Scanner(System.in);
		
		
		ServiceInstance si;
		si = getServiceInstance(vCenterURL,userName,password,true);
		
		final VirtualMachine vm = PingExample.getVM(si);
		
		do
		{
			System.out.println("Press 'a' to check the vhost status and restart it in case it is not alive");
			System.out.println("Press 'b' to check the  power status of the VMs in the vCenter");
			System.out.println("Press 'c' to get configuration details of all the VMs in the vhost/vCenter");
			System.out.println("Press 'd' to take a snapshot of the vm");
			System.out.println("Press 'e' to take a clone of the vm");
			System.out.println("Press 'f' to migrate vm from one host to another in case a host fails");
			System.out.println("Press 'g' to simulate a host failure");
			System.out.println("Press 'h' to simulate a vm failure and create an alarm in this case");
			
			System.out.println("Press 'q' to quit");
			
			String input = sc.next();
			menuOptions = input.charAt(0);
			
			switch(menuOptions)
			{
			
			case 'a':
				
				 URL uHost;
					try {
						uHost = new URL("https://130.65.132.180/sdk");
						ServiceInstance s = new ServiceInstance(uHost, "administrator","12!@qwQW",true);
						PingExample.getvHostStatus(si);
						//PingExample.getvHostPowerDetails(s);
						
					  }catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
					 catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					
					URL url1;
					ServiceInstance sHost=null;;
					try {
						   url1 = new URL("https://130.65.132.14/sdk");
					       
							sHost = new ServiceInstance(url1, "administrator", "12!@qwQW", true);
							PingExample.powerOnHost(sHost);
						} catch (RemoteException e) {
							System.out.println("A remote exception occured because the host you are trying to connect is not alive ");
							e.printStackTrace();
						}
					      
					      catch (MalformedURLException e) {
						   System.err.println("Non uniform URL");
						   e.printStackTrace();
					       } 
				
			       break;
			       
			case 'b':     
				    
				PingExample.getPowerDetails(si);
			     break;
			     
			case 'c':
				PingExample.getConfiguration(vm);
				break;
				
			case 'd':
				
				Timer timer = new Timer();

				timer.schedule( new TimerTask() {
				    public void run() {
				    	PingExample.takeSnapshot(vm);
				    }
				 }, 0, 600*1000);
				
				break;
				
			case 'e':
				
				URL urlClone;
				ServiceInstance siClone=null;
				try {
					urlClone = new URL("https://130.65.132.182/sdk");
					
					siClone = new ServiceInstance(urlClone, "root", "12!@qwQW", true);
						
						
						PingExample.createClone(vm,siClone);
				  }  catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				   catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				break;
				
			case 'f':
				
				URL urlMigrate;
				ServiceInstance siMigrate=null;
				try {
					urlMigrate = new URL("https://130.65.132.181/sdk");
					
					siMigrate = new ServiceInstance(urlMigrate, "root", "12!@qwQW", true);
					
					  PingExample.migrateVM(vm, siMigrate,"Team06_ubuntu_RK_Clone" );
				  }      catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
				
			        catch (MalformedURLException e) {
				     // TODO Auto-generated catch block
				     e.printStackTrace();
			         } 
			
			      break;
				
			case 'g':
				
				URL uHostFailure;
				try {
					uHostFailure = new URL("https://130.65.132.180/sdk");
					ServiceInstance sHostFail = new ServiceInstance(uHostFailure, "administrator","12!@qwQW",true);
					PingExample.vHostFailSimulation(sHostFail);
				 }catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				 catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				break;
				
				
			case 'h': 
				URL urlCreateAlarm;
				ServiceInstance siCreateAlarm=null;
				try {
					urlCreateAlarm = new URL("https://130.65.132.181/sdk");
					
					siMigrate = new ServiceInstance(urlCreateAlarm, "root", "12!@qwQW", true);
					
					  PingExample.setAlarmAtPowerOff(siMigrate);
				  }     
				
			        catch (MalformedURLException e) {
				     // TODO Auto-generated catch block
				     e.printStackTrace();
			         } 
			
			      break;
				
				
				
					
				 
				
				  
				
				
			
			
			
			case 'q': break;
			
			default: 
				System.out.println("Please enter a valid choice");
				break;
				
				
				
				
				
				
			}

			
		
		}while(menuOptions!='q');
		
		
		
		
	    
		
	
	
		
       
        
		
		
		
		
		
		

          
		
          
        
         
          
          
          
	}

}
