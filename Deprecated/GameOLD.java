////Game class holds the actual game itself as launched, as well as houses the User Interface of the game.
//
//import java.util.Scanner;
//
//public class GameOLD
//{
//    //static Room room = new Room();
//    private static boolean gameStarted;
//
//    public static boolean isGameStarted()
//    {
//        return gameStarted;
//    }
//
//    public void setGameStarted(boolean gameStarted)
//    {
//        this.gameStarted = gameStarted;
//    }
//
//    public GameOLD(Scanner gameScanner)
//    {
//
//    }
//
//    public static boolean checkIfDirectionInputIsValid(String userInput)
//    {
//        // String commands[] = {"GO N", "GO NORTH", "GO WEST", "GO W", "GO SOUTH", "GO S", "GO E", "GO EAST", "GO NORTHEAST"
//        // , "GO NE", "GO NORTHWEST", "GO NW", "GO SW", "GO SOUTHWEST", "GO SOUTHEAST", "GO SE"};
//
//        String commands[] = {"N", "NORTH", "WEST", "W", "SOUTH", "S", "E", "EAST", "NORTHEAST"
//                , "NE", "NORTHWEST", "NW", "SW", "SOUTHWEST", "SOUTHEAST", "SE"};
//
//        String[] arr = userInput.split(" ");
//        for (String ss : arr)
//        {
//            if (!ss.equalsIgnoreCase("Go"))
//            {
//                userInput = ss;
//            }
//        }
//        for (String command : commands)
//        {
//            if (userInput.equalsIgnoreCase(command))
//            {
//                int x = room.returnCharacterXLocation();
//                int y = room.returnCharacterYLocation();
//                if (checkifDirectionisValid(userInput, x, y, 1))
//                    return true;
//
//            }
//        }
//        System.out.println("Invalid direction!");
//        return false;
//    }
//
//    public void startGame()
//    {
//        if (isGameStarted() == true)
//        {
//            Scanner sc = new Scanner(System.in);
//            Help listOfHelpCommands = new Help();
//            String userInput;
//            Character newCharacter = new Character("player 1");
//
//            System.out.println("Welcome! Before we begin. . .");
//            System.out.println("Please enter a name for your player:");
//
//            boolean charNameSelect = false;
//            while (charNameSelect == false)
//            {
//                userInput = sc.nextLine();
//                if (userInput.isEmpty())
//                {
//                    System.out.println("Empty Character name entered, please try again");
//                } else
//                {
//                    System.out.println("Character Name, " + userInput + ", has been set");
//                    newCharacter.setName(userInput);
//                    charNameSelect = true;
//                }
//            }
//
//            room.readRoom("DemoRoom.txt");
//
//            System.out.println("Tip: If you ever get stuck with the controls of the game, Type 'help'!\n");
//
//            System.out.println("You have awoken after 40 years in cryogenic sleep. . .");
//            System.out.println("Your mind is awake, but your body aches.");
//            System.out.println("You try to remember what the last thing you did was. . .");
//            System.out.println("but there is no hope, all you remember is your name: " + newCharacter.returnName() + ".");
//            System.out.println("You get out of the pod in hopes to figuring out what happened.");
//
//
//            newCharacter.setCurrentRoom(room.getRoomName());
//            newCharacter.setCharacterXLocation(room.returnCharacterXLocation());
//            newCharacter.setCharacterYLocation(room.returnCharacterYLocation());
//
//            while (isGameStarted() == true)
//            {
//                userInput = sc.nextLine();
//                if (userInput.equalsIgnoreCase("Quit"))
//                {
//                    System.out.println("Are you sure you want to quit? Y/N: ");
//                    boolean quit = false;
//                    while (quit == false)
//                    {
//                        userInput = sc.nextLine();
//                        if (userInput.equalsIgnoreCase("Yes") || userInput.equalsIgnoreCase("Y"))
//                        {
//                            System.exit(0);
//                        } else if (userInput.equalsIgnoreCase("No") || userInput.equalsIgnoreCase("N"))
//                        {
//                            System.out.println("Returning to the game. . .");
//                            quit = true;
//                        } else
//                        {
//                            System.out.println("Invalid Response. Please try again.");
//                        }
//                    }
//                } else if (userInput.equalsIgnoreCase("Help"))
//                {
//                    listOfHelpCommands.helpInstructionsDisplay();
//                } else if (userInput.equalsIgnoreCase("Look"))
//                {
//                    String[] directions = {"N", "W", "S", "E", "NE", "NW", "SW", "SE"};
//                    for (int i = 0; i < directions.length; i++)
//                    {
//                        if (checkifDirectionisValid(directions[i], room.returnCharacterXLocation(), room.returnCharacterYLocation(), 2))
//                        {
//                            System.out.println("as you look towards " + directions[i]);
//                        }
//                    }
//                    room.displayroomBoard();
//
//                } else if (userInput.equalsIgnoreCase("Progress"))
//                {
//                    newCharacter.getProgress();
//                } else if (checkIfDirectionInputIsValid(userInput))
//                {
//                    newCharacter.setCharacterXLocation(room.returnCharacterXLocation());
//                    newCharacter.setCharacterYLocation(room.returnCharacterYLocation());
//                    String[] arr = userInput.split(" ");
//                    for (String ss : arr)
//                    {
//                        if (!ss.equalsIgnoreCase("Go"))
//                        {
//                            userInput = ss;
//                        }
//                    }
//                    System.out.println(newCharacter.returnName() + " moves " + userInput);
//                    room.displayroomBoard();
//
//                } else if (userInput.equalsIgnoreCase("Go"))
//                {
//                    System.out.println("Please enter a direction after the Go command, Ex: Go west, Go N");
//                }
//
//
//            }
//
//
//        } else
//        {
//            System.out.println("Game hasn't been started yet.");
//        }
//
//    }
//
//    public static boolean checkifDirectionisValid(String userInput, int x, int y, int condition)
//    {
//
//
//        if (userInput.equalsIgnoreCase("N") || userInput.equalsIgnoreCase("north"))
//        {
//            if ((x - 1 != -1))
//            {
//
//                if (room.ifPlayerCanmove(x - 1, y, condition))
//                {
//                    return true;
//                } else
//                {
//                    return false;
//                }
//            }
//            return false;
//
//        } else if (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south"))
//        {
//            if (!(x + 1 >= room.roomXBound))
//            {
//                if (room.ifPlayerCanmove(x + 1, y, condition))
//                {
//                    return true;
//                } else
//                    return false;
//            }
//            return false;
//        } else if (userInput.equalsIgnoreCase("W") || userInput.equalsIgnoreCase("west"))
//        {
//            if ((y - 1 != -1))
//            {
//                if (room.ifPlayerCanmove(x, y - 1, condition))
//                {
//                    return true;
//                } else
//                    return false;
//            }
//            return false;
//        } else if (userInput.equalsIgnoreCase("E") || userInput.equalsIgnoreCase("east"))
//        {
//            if (!(y + 1 >= room.roomYBound))
//            {
//                if (room.ifPlayerCanmove(x, y + 1, condition))
//                {
//                    return true;
//                } else
//                    return false;
//            }
//            return false;
//        } else if (userInput.equalsIgnoreCase("NE") || userInput.equalsIgnoreCase("northeast"))
//        {
//            if ((x - 1 != -1) && !(y + 1 >= room.roomYBound))
//            {
//
//                if (room.ifPlayerCanmove(x - 1, y + 1, condition))
//                {
//                    return true;
//                } else
//                {
//                    return false;
//                }
//            }
//            return false;
//        } else if (userInput.equalsIgnoreCase("se") || userInput.equalsIgnoreCase("southeast"))
//        {
//            if (!(x + 1 >= room.roomXBound) && !(y + 1 >= room.roomYBound))
//            {
//                if (room.ifPlayerCanmove(x + 1, y + 1, condition))
//                {
//                    return true;
//                } else
//                    return false;
//            }
//            return false;
//        } else if (userInput.equalsIgnoreCase("NW") || userInput.equalsIgnoreCase("northwest"))
//        {
//            if ((x - 1 != -1) && (y - 1 != -1))
//            {
//                if (room.ifPlayerCanmove(x - 1, y - 1, condition))
//                {
//                    return true;
//                } else
//                    return false;
//            }
//            return false;
//        } else if (userInput.equalsIgnoreCase("Sw") || userInput.equalsIgnoreCase("southwest"))
//        {
//            if (!(x + 1 >= room.roomXBound) && (y - 1 != -1))
//            {
//                if (room.ifPlayerCanmove(x + 1, y - 1, condition))
//                {
//                    return true;
//                } else
//                    return false;
//            }
//            return false;
//        }
//
//
//        return false;
//    }
//}
