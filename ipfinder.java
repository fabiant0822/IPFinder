package ipfinder;

import java.util.Scanner;

public class ipscanner {

	public static void main(String[] args) {
		String ipstr;
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Ip cím (000.0.0.0): ");
			String ip = scan.nextLine();
			
			// pontok eltávolítása
			ipstr = ip.replaceAll("\\.", "");
			System.out.println("Ip string pontok nélkül: " + ipstr);
			
			// első három karakter kivágása
			String firstbyte = ipstr.substring(0, 3);
			System.out.println("Ip első byte: " + firstbyte);
			
			// szöveg számmá konvertálása (cast)
			Integer ipint = Integer.parseInt(firstbyte);
			System.out.println("Ip első byte számformátum: " + ipint);
			
			// vizsgálat
			ipchk(ipint);
			
			// hibakezelés
		} catch (Exception e) {
			System.out.println("Hiba a beolvasás közben: " + e);
		}

	}

	public static void ipchk(int ipint) {
		String ipclass = null;
		//osztálybesorolás
		if ((0 < ipint) && (ipint <= 127)) {
			ipclass = "A";
		} else if ((128 <= ipint) && (ipint <= 191)) {
			ipclass = "B";
		} else if ((192 <= ipint) && (ipint <= 223)) {
			ipclass = "C";
		} else if ((224 <= ipint) && (ipint <= 239)) {
			ipclass = "D";
		} else if ((240 <= ipint) && (ipint <= 255)) {
			ipclass = "E";
		//kivételek kezelése	
		} else if (256 <= ipint) {
			ipclass = "X";
		} else if (0 >= ipint) {
			ipclass = "Y";
		} else
			ipclass = null;
		
		//kiíratás
		switch (ipclass) {
		case "A":
			System.out.println("Az IP cím osztálya: " + ipclass);
			break;
		case "B":
			System.out.println("Az IP cím osztálya: " + ipclass);
			break;
		case "C":
			System.out.println("Az IP cím osztálya: " + ipclass);
			break;
		case "D":
			System.out.println("Az IP cím osztálya: " + ipclass);
			break;
		case "E":
			System.out.println("Az IP cím osztálya: " + ipclass);
			break;
		case "X":
			System.out.println("Túl nagy előtag: " + ipint);
			break;
		case "Y":
			System.out.println("Túl kicsi előtag: " + ipint);
			break;
		}
	}

}
