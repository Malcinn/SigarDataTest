package math.uni.lodz.pl.systeminformationstest;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.Who;

public class OsInfo {

	private Sigar sigar = null;

	public OsInfo(Sigar sigar) {
		this.sigar = sigar;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			stringBuilder.append("\n~~~~~~~~~~~~~~OS~~~~~~~~~~~~~~\n");
			stringBuilder.append("Uptime: " + sigar.getUptime().getUptime() / 60 + " min\n");
		} catch (Throwable t) {
			System.out
					.println("\n~~~~~~~~~~~~~~ERROR error ocurred while gatherig information about OS~~~~~~~~~~~~~~\n "
							+ t.getMessage());
		}
		return stringBuilder.toString();
	}
}
