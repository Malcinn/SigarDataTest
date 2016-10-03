package math.uni.lodz.pl.systeminformationstest;

import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.Sigar;

public class CPUInfo {

	private Sigar sigar;

	public CPUInfo(Sigar sigar) {
		this.sigar = sigar;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			stringBuilder.append("\n~~~~~~~~~~~~~~CPU~~~~~~~~~~~~~~\n");
			double[] loadAverageList = sigar.getLoadAverage();
			stringBuilder.append("The system load averages for the past 1, 5, and 15 minutes. \n");
			for (double d : loadAverageList) {
				stringBuilder.append(" LoadAverage: " + d + "\n");
			}

			CpuInfo[] cpuInfoList = sigar.getCpuInfoList();
			for (CpuInfo cpuInfo : cpuInfoList) {
				try {
					stringBuilder.append(cpuInfo.toString() + "\n");
				} catch (Throwable t) {
					System.out.println(
							"\n~~~~~~~~~~~~~~ERROR error ocurred while gatherig information about cpu~~~~~~~~~~~~~~\n "
									+ t.getMessage());
				}

			}
		} catch (Throwable t) {
			System.out.println(
					"\n~~~~~~~~~~~~~~ERROR error ocurred while getting Cpu object~~~~~~~~~~~~~~\n " + t.getMessage());
		}
		return stringBuilder.toString();
	}

}
