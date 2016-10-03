package math.uni.lodz.pl.systeminformationstest;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.Who;

public class UsersInfo {

	private Sigar sigar = null;

	public UsersInfo(Sigar sigar) {
		this.sigar = sigar;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			stringBuilder.append("\n~~~~~~~~~~~~~~Users~~~~~~~~~~~~~~\n");
			Who[] whos = sigar.getWhoList(); 
			for (Who who : whos) {
				stringBuilder.append(who.toString());
			}
		} catch (Throwable t) {
			System.out
			.println("\n~~~~~~~~~~~~~~ERROR error ocurred while gatherig information about Users~~~~~~~~~~~~~~\n "
					+ t.getMessage());
		}
		return stringBuilder.toString();
	}
}
