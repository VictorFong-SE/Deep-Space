//import java.io.*;
//
//
//public class RoomOLD
//{
//
//    String roomName;
//
//    int roomXBound;
//    int roomYBound;
//
//    int playerXLocation;
//    int playerYLocation;
//
//    int doorXLocation;
//    int doorYLocation;
//
//    int lootXLocation;
//    int lootYLocation;
//
//    char[][] roomBoard;
//    boolean[][] hiddenRoomBoard;
//
//    public static RoomOLD getRoomByID(int nextInt)
//    {
//        return null;
//    }
//
//
//    public int getRoomXBound()
//    {
//        return this.roomXBound;
//    }
//
//    public int getRoomYBound()
//    {
//        return this.roomYBound;
//    }
//
//    public void setCharacterXLocation(int x)
//    {
//        this.playerXLocation = x;
//    }
//
//    public int returnCharacterXLocation()
//    {
//        return this.playerXLocation;
//    }
//
//    public int returnCharacterYLocation()
//    {
//        return this.playerYLocation;
//    }
//
//    public void setCharacterYLocation(int y)
//    {
//        this.playerYLocation = y;
//    }
//
//
//    public void setRoomBoardValues()
//    {
//
//        for (int i = 0; i < roomBoard.length; i++)
//        {
//            for (int f = 0; f < roomBoard.length; f++)
//            {
//                roomBoard[i][f] = '*';
//
//            }
//        }
//        this.roomBoard[playerXLocation][playerYLocation] = 'P';
//        this.roomBoard[doorXLocation][doorYLocation] = 'D';
//        this.roomBoard[lootXLocation][lootYLocation] = 'L';
//
//    }
//
//    public void displayroomBoard()
//    {
//        System.out.println("Room: " + getRoomName());
//        for (int i = 0; i < roomBoard.length; i++)
//        {
//            for (int f = 0; f < roomBoard.length; f++)
//            {
//                if ((roomBoard[i][f] == 'D' || roomBoard[i][f] == 'L') && hiddenRoomBoard[i][f] == true)
//                    System.out.print("*" + " ");
//                else
//                    System.out.print(roomBoard[i][f] + " ");
//            }
//            System.out.println("");
//        }
//    }
//
//    public boolean ifPlayerCanmove(int x, int y, int condition)
//    {
//        if (condition == 1)
//        {
//            if (roomBoard[x][y] == '*')
//            {
//
//                roomBoard[returnCharacterXLocation()][returnCharacterYLocation()] = '*';
//                setCharacterXLocation(x);
//                setCharacterYLocation(y);
//                setRoomBoardValues();
//                return true;
//            }
//
//
//        } else if (condition == 2)
//        {
//            hiddenRoomBoard[x][y] = false;
//            if (roomBoard[x][y] == 'D')
//            {
//                System.out.print("You reveal a door! ");
//            } else if (roomBoard[x][y] == 'L')
//            {
//                System.out.print("You reveal loot! ");
//            } else if (roomBoard[x][y] == '*')
//            {
//                System.out.print("You reveal nothing ");
//            }
//            return true;
//        } else
//        {
//            return false;
//        }
//        return false;
//    }
//
//    public String getRoomName()
//    {
//        return this.roomName;
//    }
//
//    public void setRoomName(String roomName)
//    {
//        this.roomName = roomName;
//    }
//
//    public void setPlayerStartingLocations(String locations, int num)
//    {
//        String[] arr = locations.split(",");
//
//        int locationofArr = 0;
//
//        for (String ss : arr)
//        {
//            if (locationofArr == 0)
//            {
//                if (num == 0)
//                    this.playerXLocation = Integer.parseInt(ss);
//                else if (num == 1)
//                    this.doorXLocation = Integer.parseInt(ss);
//                else
//                    this.lootXLocation = Integer.parseInt(ss);
//                locationofArr++;
//            } else if (num == 0)
//                this.playerYLocation = Integer.parseInt(ss);
//            else if (num == 1)
//                this.doorYLocation = Integer.parseInt(ss);
//            else
//                this.lootYLocation = Integer.parseInt(ss);
//        }
//
//    }
//
//    public void setRoomBoardLocations(int x, int y)
//    {
//        this.roomXBound = x;
//        this.roomYBound = y;
//        this.roomBoard = new char[x][y];
//        this.hiddenRoomBoard = new boolean[x][y];
//        for (int i = 0; i < hiddenRoomBoard.length; i++)
//        {
//            for (int f = 0; f < hiddenRoomBoard.length; f++)
//            {
//                hiddenRoomBoard[i][f] = true;
//
//            }
//        }
//    }
//
//    public void setRoomBoard(String dimensions)
//    {
//        String[] arr = dimensions.split(",");
//
//        int locationofArr = 0;
//        int x = 0, y = 0;
//
//        for (String ss : arr)
//        {
//            if (locationofArr == 0)
//            {
//                x = Integer.parseInt(ss);
//                locationofArr++;
//            } else
//                y = Integer.parseInt(ss);
//        }
//        setRoomBoardLocations(x, y);
//    }
//
//
//    public void readRoom(String fileName)
//    {
//        String line = null;
//
//        try
//        {
//            FileReader fileReader = new FileReader(fileName);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            while ((line = bufferedReader.readLine()) != null)
//            {
//                if (line.equalsIgnoreCase("Room:"))
//                {
//                    setRoomName(bufferedReader.readLine());
//                } else if (line.equalsIgnoreCase("Tiles:"))
//                {
//                    setRoomBoard(bufferedReader.readLine());
//
//                } else if (line.equalsIgnoreCase("Doors:"))
//                {
//                    setPlayerStartingLocations(bufferedReader.readLine(), 1);
//
//                } else if (line.equalsIgnoreCase("Loot:"))
//                {
//                    setPlayerStartingLocations(bufferedReader.readLine(), 2);
//
//                } else if (line.equalsIgnoreCase("StartingLocation:"))
//                {
//                    setPlayerStartingLocations(bufferedReader.readLine(), 0);
//                }
//
//            }
//            setRoomBoardValues();
//
//            bufferedReader.close();
//        } catch (FileNotFoundException ex)
//        {
//            System.out.println("Unable to open file '" + fileName + "'");
//        } catch (IOException ex)
//        {
//            System.out.println("Error reading file '" + fileName + "'");
//
//        }
//    }
//
//    public void addPath(Path path)
//    {
//    }
//}
//
//
//
