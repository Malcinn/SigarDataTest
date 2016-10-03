package math.uni.lodz.pl.systeminformationstest;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.Who;

public class Main {

	public static void main(String[] args) {
		Sigar sigar = null;
		try {
			sigar = new Sigar();
			System.out.println(new RAMInfo(sigar).toString());
			System.out.println(new FileSystemInfo(sigar).toString());
			System.out.println(new CPUInfo(sigar).toString());
			System.out.println(new OsInfo(sigar).toString());
			System.out.println(new UsersInfo(sigar).toString());
			System.out.println(new NetworkInterfaceInfo(sigar).toString());
		} catch (Throwable t) {
			System.out.println("[ERROR] ocurred while creating sigar object.");
		} finally {
			try {
				sigar.close();
			} catch (Throwable t2) {
				System.out.println("[ERROR] ocurred while closing sigar object.");
			}
		}
	}
}
