package math.uni.lodz.pl.systeminformationstest;

import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;

public class NetworkInterfaceInfo {

	private Sigar sigar = null;

	public NetworkInterfaceInfo(Sigar sigar) {
		this.sigar = sigar;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			String[] netInterfaceList = sigar.getNetInterfaceList();
			stringBuilder.append("\n~~~~~~~~~~~~~~Network interfaces~~~~~~~~~~~~~~\n");
			for (String netInterface : netInterfaceList) {
				stringBuilder.append("Interface name: " + netInterface + "\n");
				NetInterfaceConfig netInterfaceConfig = sigar.getNetInterfaceConfig(netInterface);
				stringBuilder.append(netInterfaceConfig.toString() + "\n");
				NetInterfaceStat netInterfaceStat = sigar.getNetInterfaceStat(netInterface);
				stringBuilder.append(netInterfaceStat.toString() + "\n");
			}
		} catch (Throwable t) {
			System.out.println(
					"\n~~~~~~~~~~~~~~ERROR error ocurred while gatherig information Network Interfaces~~~~~~~~~~~~~~\n "
							+ t.getMessage());
		}
		return stringBuilder.toString();
	}
}
