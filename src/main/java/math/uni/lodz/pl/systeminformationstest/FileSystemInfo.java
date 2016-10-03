package math.uni.lodz.pl.systeminformationstest;

import org.hyperic.sigar.DirUsage;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;

public class FileSystemInfo {

	private Sigar sigar;

	public FileSystemInfo(Sigar sigar) {
		this.sigar = sigar;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			stringBuilder.append(("\n~~~~~~~~~~~~~~DIK~FILE_SYSTEM~~~~~~~~~~~~~~\n"));
			FileSystem[] fileSystemList = sigar.getFileSystemList();
			for (FileSystem fileSystem : fileSystemList) {
				try {
					stringBuilder.append("DirName: " + fileSystem.getDirName() + "\n");

					DirUsage dirUsage = sigar.getDirUsage(fileSystem.getDirName());
					stringBuilder.append(dirUsage.toString() + "\n");

					FileSystemUsage fileSystemUsage = sigar.getFileSystemUsage(fileSystem.getDirName());
					stringBuilder.append(fileSystemUsage.toString() + "\n\n");
				} catch (Throwable t) {
					System.out.println(
							"\n\n~~~~~~~~~~~~~~[ERROR] ocurred while gathering data about disks~~~~~~~~~~~~~~\n"
									+ t.getMessage() + " DISK name: " + fileSystem.getDirName()+"\n\n");
				}
			}
		} catch (Throwable t) {
			System.out.println("\n~~~~~~~~~~~~~~ERROR error ocurred while getting fileSystemList object~~~~~~~~~~~~~~\n");
		}
		return stringBuilder.toString();
	}

}
