class AirplaneSearchSort {
    public static void main(String[] args) {
        Airplane[] airplanes = createAirplaneArray();
        System.out.println("-----------------------------------------------------");
        System.out.println("The number of airplanes in the array: " + airplanes.length);
        System.out.println("Printing the Airplane information");
        showAirplaneInfo(airplanes);
        System.out.println("-----------------------------------------------------");

        System.out.println("Linear Search on the array based on duration");
        System.out.println("-----------------------------------------------------");

        int LSDuration = 1415;
        linearSearchByDuration(airplanes, LSDuration);
        System.out.println();

        int LSDurationTwo = 100;
        linearSearchByDuration(airplanes, LSDurationTwo);
        System.out.println("-----------------------------------------------------");

        System.out.println("Linear Search on the array based on capacity");
        System.out.println("-----------------------------------------------------");

        int LSCapacity = 32;
        linearSearchByCapacity(airplanes, LSCapacity);
        System.out.println();

        int LSCapacityTwo = 50;
        linearSearchByCapacity(airplanes, LSCapacityTwo);

        System.out.println("-----------------------------------------------------");

        System.out.println("Sorting the array using Bubble Sort based on duration");
        System.out.println("-----------------------------------------------------");
        bubbleSortByDuration(airplanes);
        System.out.println("Printing the sorted array.....");
        showAirplaneInfo(airplanes);

        System.out.println("-----------------------------------------------------");

        System.out.println("Binary Search on the array based on duration");
        System.out.println("-----------------------------------------------------");

        int BSDuration = 1415;
        binarySearchDuration(airplanes, BSDuration);
        System.out.println();

        int BSDurationTwo = 100;
        binarySearchDuration(airplanes, BSDurationTwo);

        System.out.println("-----------------------------------------------------");
        bubbleSortByCapacity(airplanes);
        System.out.println("Printing the sorted array.....");
        showAirplaneInfo(airplanes);

        System.out.println("-----------------------------------------------------");
        System.out.println("Binary Search on the array based on capacity");
        System.out.println("-----------------------------------------------------");

        int BSCapacity = 32;
        binarySearchByCapacity(airplanes, BSCapacity);
        System.out.println();

        int BSCapacityTwo = 50;
        binarySearchByCapacity(airplanes, BSCapacityTwo);

    }

/*find the position based on duration using Binary Search*/
    static int binarySearchDuration(Airplane[] airplanes, int BSDuration) {
    	int left = 0;
      int right = airplanes.length - 1;

      while (left <= right) {
      	int mid = left + (right - left) / 2;

        if (airplanes[mid].getDuration() == BSDuration) {
        	System.out.println("Airplane with operating duration " + BSDuration + " found at position " + mid);
          System.out.println(airplanes[mid]);
          return mid;
        }
        if (airplanes[mid].getDuration() < BSDuration) {
        	left = mid + 1;
        }
        else {
        	right = mid - 1;
        }
      }
			System.out.println("Airplane with operating duration " + BSDuration + " not found in the array.");
      return -1;
    }

/*find the position based on capacity using Binary Search*/
    static int binarySearchByCapacity(Airplane[] airplanes, int BSCapacity) {
    	int left = 0;
      int right = airplanes.length - 1;

      while (left <= right) {
      	int mid = left + (right - left) / 2;
        	if (airplanes[mid].getCapacity() == BSCapacity) {
          	System.out.println("Airplane with capacity " + BSCapacity + " found at position " + mid);
            System.out.println(airplanes[mid]);
            return mid;
          }
          if (airplanes[mid].getCapacity() < BSCapacity) {
          	left = mid + 1;
          }
        	else {
          	right = mid - 1;
          }
        }
				System.out.println("Airplane with capacity " + BSCapacity + " not found in the array.");
        return -1;
    }

/*find the position based on capacity using linear Search*/
    static int linearSearchByCapacity(Airplane[] airplanes, int LSCapacity) {
			for (int i = 0; i < airplanes.length; i++) {
      	if (airplanes[i].getCapacity() == LSCapacity) {
        	System.out.println("Airplane with capacity " + LSCapacity + " found at position " + i);
          System.out.println(airplanes[i]);
          return i;
        }
     }
     System.out.println("Airplane with capacity " + LSCapacity + " not found in the array.");
     return -1;
    }

/*find the position based on duration using linear Search*/
    static int linearSearchByDuration(Airplane[] airplanes, int LSDuration) {
    	for (int i = 0; i < airplanes.length; i++) {
      	if (airplanes[i].getDuration() == LSDuration) {
        	System.out.println("Airplane with duration " + LSDuration + " found at position " + i);
          System.out.println(airplanes[i]);
          return i;
        }
      }
      System.out.println("Airplane with duration " + LSDuration + " not found in the array.");
      return -1;
    }

/*arrange the Airplane objects in ascending order of duration using Bubble Sort.(Consider method overloading)*/
    public static void bubbleSortByDuration(Airplane[] allAirplane) {
			int n = allAirplane.length;
    	for (int i = 0; i < n - 1; i++) {
      	for (int j = 0; j < n - i - 1; j++) {
        	if (allAirplane[j].getDuration() > allAirplane[j + 1].getDuration()) {
          	// swap airplanes[j] and airplanes[j+1]
          		Airplane temp = allAirplane[j];
            	allAirplane[j] = allAirplane[j + 1];
            	allAirplane[j + 1] = temp;
          }
        }
      }
    }

/*arrange the Airplane objects in ascending order of capacity using Bubble Sort*/
    public static void bubbleSortByCapacity(Airplane[] allAirplane) {
    int n = allAirplane.length;
    	for (int i = 0; i < n - 1; i++) {
     		for (int j = 0; j < n - i - 1; j++) {
        	if (allAirplane[j].getCapacity() > allAirplane[j + 1].getCapacity()) {
          	// swap allAirplane[j] and allAirplane[j+1]
            Airplane temp = allAirplane[j];
            allAirplane[j] = allAirplane[j + 1];
            allAirplane[j + 1] = temp;
          }
        }
     	}
    }
  
/*Display all the variables of a Airplane object in the same sequence they appear in the parameter array.*/
    static void showAirplaneInfo(Airplane[] allAirplane) {
        for (int i = 0; i < allAirplane.length; i++) {
            System.out.println(allAirplane[i].toString());
        }
    }

    static Airplane[] createAirplaneArray() {
        Airplane[] newAirplane = {
                new Airplane(296, "Boeing 747", 20, 920, 2300),
                new Airplane(333, "Boeing 737", 32, 900, 2030),
                new Airplane(234, "Cessna 172", 42, 1600, 2200),
                new Airplane(748, "Boeing 777", 40, 600, 2015),
                new Airplane(123, "Boeing 787", 70, 830, 2230),
                new Airplane(765, "Boeing 717", 58, 720, 2005),
                new Airplane(111, "Airbus A350", 63, 1000, 2050),
                new Airplane(365, "Airbus A380", 35, 500, 2030),
                new Airplane(900, "Airbus A330", 55, 700, 2030),
                new Airplane(222, "Airbus A320", 60, 1610, 2230),
        };
        return newAirplane;
    }
}
