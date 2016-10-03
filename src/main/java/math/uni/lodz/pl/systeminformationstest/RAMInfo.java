package math.uni.lodz.pl.systeminformationstest;

import java.security.Signature;

import org.hyperic.sigar.Sigar;

public class RAMInfo {

	private Sigar sigar;

	public RAMInfo(Sigar sigar) {
		this.sigar = sigar;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			stringBuilder.append("~~~~~~~~~~~~~~RAM~~~~~~~~~~~~~~\n");
			stringBuilder.append(sigar.getMem().toString());
			stringBuilder.append(
					"\nActualFree: " + sigar.getMem().getActualFree() + " ActualUsed: " + sigar.getMem().getActualUsed()
							+ " Free: " + sigar.getMem().getFree() + " FreePercent: " + sigar.getMem().getFreePercent()
							+ " Ram: " + sigar.getMem().getRam() + " Total: " + sigar.getMem().getTotal() + " Used: "
							+ sigar.getMem().getUsed() + " UsedPercent: " + sigar.getMem().getUsedPercent() + "\n");
		} catch (Throwable t) {
			System.out.println("\n~~~~~~~~~~~~~~ERROR error ocurred while gathering data about RAM ~~~~~~~~~~~~~~\n"
					+ t.getMessage());
		}
		return stringBuilder.toString();
	}
}
