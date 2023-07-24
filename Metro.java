import java.util.*;



public class Metro {
    private static void showPath(HashMap<Integer,String>map,List<Integer>path)
	{
		for (int i=0; i<path.size(); i++) 
		{
			System.out.print(map.get(path.get(i)));
			if (i != path.size()-1)
				System.out.print(" -> ");
		}
		System.out.println();
	}
    private static int getInt(HashMap<String,Integer>hpi,String s) throws NullPointerException{
        try{
            return hpi.get(s);
        }
        catch(NullPointerException e){
            System.out.println("Looks like you have entered a wrong Station Name -- Re-enter");
        }
        return -1;
    }
    private static void displayStation(int v, HashMap<Integer,String>map)
	{
		for (int i=0; i<v; i++)
		{
			System.out.println(i+1+" "+map.get(i));
		}
	}
    public static void main(String[] args) throws SameNameException {
        HashMap<Integer,String>hp=new HashMap<Integer,String>();
        String stations[]={"LBnagar","Victoria_memorial","chaitanyapuri","Dilshukhnagar","moosrambagh","NewMarket","malakpet","MGbusstation","Osmania_medical","Gandhibhavan","Nampally","Assembly","Lakdikapool","Khairtabad","Irrummanzil","Panjagutta","Ameerpet","SRnagar","ESIhospital","Erragadda","Bharatnagar","Moosapet","DR_BRambedkar","Kukatpally","KPHBcolony","JNTUcollege","Miyapur","Sultanbazar","Narayanguda","Chikkadpali","RTCxroads","Musheerabad","Gandhihospital","Secbadwest","Paradeground","Nagole","Uppal","stadium","NGRI","Habsiguda","Tarnaka","Mettuguda","Secbadeast","Paradise","Rasoolpura","PrakashNagar","Begumpet","MathuraNagar","Yusufguda","Jubliehills","JH-checkpost","Peddamagudi","Madhapur","Dugamcheruvu","Hitechcity","raidurg"};
        for (int i = 0; i <stations.length; i++) {
            String station = stations[i];
            hp.put(i,station);
        }
Scanner sc=new Scanner(System.in);
        HashMap<String,Integer>hpi=new HashMap<String,Integer>();
        for(int i:hp.keySet()){
            hpi.put(hp.get(i),i);
        }
        List<Integer> path = new ArrayList<Integer>();
        int [] dist = new int [stations.length];
        int edges[][]={
            
            {0, 1, 1},
        {1, 2, 1},
        {2, 3, 1},
        {3, 4, 2},
        {4, 5, 1},
        {5, 6, 1},
        {6, 7, 1},
        {7, 8, 1},
        {8, 9, 1},
        {9, 10, 1},
        {10, 11, 1},
        {11, 12, 1},
        {12, 13, 1},
        {13, 14, 1},
        {14, 15, 1},
        {15, 16, 1},
        {16, 17, 1},
        {17, 18, 1},
        {18, 19, 1},
        {19, 20, 1},
        {20, 21, 1},
        {21, 22, 1},
        {22, 23, 1},
        {23, 24, 1},
        {24, 25, 2},
        {25, 26, 2},


            
            

            {34,33,2},
            {33,32,2},
            {32,31,1},
            {31,30,2},
            {30,29,1},
            {29,28,2},
            {28,27,1},
            {27,7,1},

            {35,36,1},
            {36,37,1},
            {37,38,2},
             {38,39,1},
            {39,40,2},
            {40,41,1},
             {41,42,2},
            {42,34,2},
            {34,43,1},
             {43,44,1},
            {44,45,1},
            {45,46,1},
             {46,16,2},
            {16,47,1},
            {47,48,1},
             {48,49,1},
            {49,50,1},
            {50,51,1},
             {51,52,1},
            {52,53,1},
            {53,54,1},
            {54,55,1}

        };
        int dest=-1;
        int src=-1;
        int v=56,e=56;
        int fare = 0;
	int totalDist = -2;
        int choice;
        do {
            System.out.println("----------------------------------------");
            System.out.println("Choose a numeric value from the options below:");
            System.out.println("Enter 0: Exit Menu");
            System.out.println("Enter 1: Show All Stations");
            System.out.println("Enter 2: Enter Source Station & Destination Station");
            System.out.println("Enter 3: Distance to be travelled");
            System.out.println("Enter 4: Shortest Path");
            System.out.println("Enter 5: Estimated Time");
            System.out.println("Enter 6: Fare");
            System.out.println("----------------------------------------");
            System.out.print("Enter Your Choice: ");

            // Check if the input is empty (just pressing Enter)
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                choice = -1; // Set an invalid choice to repeat the loop
            } else {
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e1) {
                    choice = -1; // Invalid choice, repeat the loop
                }
            }

            if (choice == -1) {
                System.out.println("Invalid choice. Please enter a valid numeric value.");
            } else {
                switch (choice) {
                    case 0:
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);
                    case 1:
                        displayStation(v, hp);
                        break;
                    case 2:
                        src = -1;
                        dest = -1;
                        while (src == -1) {
                            System.out.println("Enter Source Station");
                            String sstr = sc.nextLine();
                            src = getInt(hpi, sstr);
                            if (src == -1) {
                                System.out.println("Invalid Source Station Name. Please re-enter.");
                            }
                        }
                        while (dest == -1) {
                            System.out.println("Enter Destination Station");
                            String dstr = sc.nextLine();
                            dest = getInt(hpi, dstr);
                            if (dest == -1) {
                                System.out.println("Invalid Destination Station Name. Please re-enter.");
                            }
                        }
                        if (dest == src)
                            throw new SameNameException("Looks like Source and Destination Stations are the same");
                        path = help.dijsktraAlgo(v, e, src, dest, edges, dist);
                        break;
                    case 3:
                        try {
                            System.out.println("Approx Distance: " + dist[dest]);
                        } catch (Exception ex) {
                            System.out.println("Please Enter Source and Destination Station first.");
                        }
                        break;
                    case 4:
                        if (path.size() == 0)
                            System.out.println("Please Enter Source and Destination Station first.");
                        else
                            showPath(hp, path);
                        break;
                    case 6:
                        try {
                            fare = graph.fair(dist[dest]);
                            System.out.println("Fare need to be paid: " + fare);
                        } catch (Exception ex) {
                            System.out.println("Please Enter Source and Destination Station first.");
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("Journey Time: " + graph.estimatedTime(dist[dest], path.size()) + " min");
                        } catch (Exception ex) {
                            System.out.println("Please Enter Source and Destination Station first.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid numeric value.");
                        break;
                }
            }
        } while (true); // Will loop indefinitely until a valid choice (0 to 6) is provided.
    }
	

       
}

