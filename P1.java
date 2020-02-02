import java.io.*;
import java.util.*;

    public class P1 
    {
	/* Define data structures for holding the data here */
        public static int i = 0;
        public static int j = 0;
        Scanner readfile;
        
        ArrayList<Team> Teams; 
        private class Team
        {
            String team_IDs = " ", locations = " ", names = " ", leagues = " ";
            public Team(String team_ID, String location, String name, String league)
            {
                team_IDs = team_ID;
                names = name;
                locations = location;           
                leagues = league;
            }
            public String Location() {return locations;}
            public String Name() {return names;}
            public String toString()
            {
                String output = team_IDs
                + " " 
                + locations
                + " " 
                + names
                + " " 
                + leagues;
                return output;
            }
        }
      
        ArrayList<Coach> Coaches;
        private class Coach
        {
            int seasons = 0, season_wins = 0, season_losses = 0, playoff_wins = 0, playoff_losses = 0;
            String coach_IDs = " ", first_names = " ", last_names = " ", teams = " ";
        
            public Coach(String coach_ID, int season, String first_name, String last_name, int season_win, int season_loss, int playoff_win, int playoff_loss, String team)
            {
                coach_IDs = coach_ID;
                seasons = season;
                first_names = first_name;
                last_names = last_name;
                season_wins = season_win;
                season_losses = season_loss;
                playoff_wins = playoff_win;
                playoff_losses = playoff_loss;            
                teams = team;
            }
 
            public String CoachID() {return coach_IDs;}
            public int Season() {return seasons;}      
            public String FirstName() {return first_names;}
            public String LastName() {return last_names;}
            public int SeasonWin() {return season_wins;}
            public int SeasonLoss() {return season_losses;}
            public int PlayoffWin() {return playoff_wins;}
            public int PlayoffLoss() {return playoff_losses;}
            public String TeamName() {return teams;}
            public String toString()
            {
                String output = coach_IDs 
                + " " 
                + seasons
                + " " 
                + first_names 
                + " " 
                + last_names 
                + " " 
                + season_wins 
                + " " 
                + season_losses 
                + " " 
                + playoff_wins 
                + " " 
                + playoff_losses 
                + " " 
                + teams;
                
                return output;
            }
        }
          
        public P1() 
        {
            /* initialize the data structures */
            Coaches = new ArrayList<Coach>();
            Teams = new ArrayList<Team>();
        }
    
        public void run() 
        {
            CommandParser parser = new CommandParser();
            System.out.println("The mini-DB of NBA coaches and teams");
            System.out.println("Please enter a command.  Enter 'help' for a list of commands.");
            System.out.println();
            System.out.print("> "); 
        
            Command cmd = null;
            while ((cmd = parser.fetchCommand()) != null) 
            {
               //System.out.println(cmd);
            
                boolean result = false;
            
                if (cmd.getCommand().equals("help")) 
                {
                    result = doHelp();
                    /* You need to implement all the following commands */
                } 
                else if (cmd.getCommand().equals("add_coach")) 
                {                 
                    String[] addCoach = cmd.getParameters();
                    add_coaches(addCoach);                         
                }    
                else if (cmd.getCommand().equals("add_team")) 
                {
                    String[] addTeam = cmd.getParameters();              
                    add_teams(addTeam);                 	
                } 
                else if (cmd.getCommand().equals("load_coaches")) 
                {
                    String loadCoaches[] = cmd.getParameters();
                    load_coach(loadCoaches);              
                }
                else if (cmd.getCommand().equals("load_teams")) 
                {       
                    String[] loadTeam = cmd.getParameters();
                    load_team(loadTeam);            
                }
                else if (cmd.getCommand().equals("print_coaches")) 
                {
                    print_coaches();   
                        
                } 
                else if (cmd.getCommand().equals("print_teams")) 
                {
                    print_teams();         
                }       
                else if (cmd.getCommand().equals("coaches_by_name")) 
                {
                    String[] coachesByName = cmd.getParameters();  
                    coach_by_name(coachesByName);         
                } 
                else if (cmd.getCommand().equals("teams_by_city")) 
                {
                    String[] teamsByCity = cmd.getParameters();  
                    team_by_city(teamsByCity);         
                }               
                else if (cmd.getCommand().equals("best_coach")) 
                {
                    String[] bestCoach = cmd.getParameters();
                    best_coach(bestCoach);
                }          
                else if (cmd.getCommand().equals("search_coaches")) 
                {
                    String[] searchCoaches = cmd.getParameters();       
                    search_coach(searchCoaches);               
                } 
                else if (cmd.getCommand().equals("exit")) 
                {
         			System.out.println("Leaving the database, goodbye!");
         			break;
                } 
                else if (cmd.getCommand().equals("")) 
                {}
                else 
                {
         			System.out.println("Invalid Command, try again!");
                } 
                     
                if (result) 
                {
                         // ...
                }
         
                    System.out.print("> "); 
            }  
        }
        public void add_coaches(String[] coachHolder)
        {
            coachHolder[4] = coachHolder[4].replace(" ", "");
            coachHolder[5] = coachHolder[5].replace(" ", "");
            coachHolder[6] = coachHolder[6].replace(" ", "");
            coachHolder[7] = coachHolder[7].replace(" ", "");
            Coach coaches = new Coach(coachHolder[0], 
            Integer.parseInt(coachHolder[1]), 
                             coachHolder[2], 
                             coachHolder[3], 
                             Integer.parseInt(coachHolder[4]), 
                             Integer.parseInt(coachHolder[5]), 
                             Integer.parseInt(coachHolder[6]), 
                             Integer.parseInt(coachHolder[7]),
                             coachHolder[8]);
                             
            Coaches.add(coaches);
        }
        public void add_teams(String[] teamHolder)
        {
            teamHolder[0] = teamHolder[0].replaceAll("\\p{Punct}", " ");
            teamHolder[1] = teamHolder[1].replaceAll("\\p{Punct}", " ");
            teamHolder[2] = teamHolder[2].replaceAll("\\p{Punct}", " ");
            teamHolder[3] = teamHolder[3].replaceAll("\\p{Punct}", " ");
            Team teams = new Team(teamHolder[0], 
                                teamHolder[1], 
                                teamHolder[2], 
                                teamHolder[3]);             
            Teams.add(teams);
        }
        public void print_coaches()
        {
            for(i = 0; i < Coaches.size(); ++i)
            {
                System.out.println(Coaches.get(i));
            }          
         }
        public void print_teams()
        {
            for(i = 0; i < Teams.size(); ++i)
            {
                System.out.println(Teams.get(i));
            }
        }
        public void coach_by_name(String[] coachName)
        {
            for(i = 0; i < Coaches.size(); ++i)
            {
                if(Coaches.get(i).LastName().trim().equalsIgnoreCase(coachName[0].replace("+", " ")))
                {
                    System.out.println(Coaches.get(i));                      
                }
            }
        }
        public void team_by_city(String[] teamByCity)
        {          
            for(i = 0; i < Teams.size(); ++i)
            {
                String temp = Teams.get(i).Location().replace(" ", "+");
                if(Teams.get(i).Location().trim().equals(teamByCity[0]))
                {  
                    System.out.println(Teams.get(i));
                }
                else if(temp.equals(teamByCity[0]))
                {
                    System.out.println(Teams.get(i));
                }
            }
        }
        
        public void load_coach(String coachLoad[])
        {              
            try
            {    
                String readLines;
                String[] stringHolder;
                readfile = new Scanner(new File(coachLoad[0])); 
                if(readfile.hasNextLine())
                {
                    readLines = readfile.nextLine(); 
                }                  
                while(readfile.hasNextLine())
                {
                    readLines = readfile.nextLine();
                    stringHolder = readLines.split(",");
                    if (stringHolder.length == 9)
                    {
                        stringHolder[1] = stringHolder[1].replace(" ", "");
                        stringHolder[4] = stringHolder[4].replace(" ", "");
                        stringHolder[5] = stringHolder[5].replace(" ", "");
                        stringHolder[6] = stringHolder[6].replace(" ", "");
                        stringHolder[7] = stringHolder[7].replace(" ", "");
                        Coach newCoach =  new Coach(stringHolder[0], 
                                                    Integer.parseInt(stringHolder[1]), 
                                                    stringHolder[2], 
                                                    stringHolder[3], 
                                                    Integer.parseInt(stringHolder[4]), 
                                                    Integer.parseInt(stringHolder[5]), 
                                                    Integer.parseInt(stringHolder[6]), 
                                                    Integer.parseInt(stringHolder[7]), 
                                                    stringHolder[8]);                      
                        Coaches.add(newCoach);                          
                    }
                }
                readfile.close();      
            }
            catch(FileNotFoundException notFound)
            {
                System.out.println(coachLoad[0] + " file not found!");
            }  
        }
        public void load_team(String[] teamLoad)
        {
            try
            {
                readfile = new Scanner(new File(teamLoad[0]));
                String readLines;
                String[] stringHolder;
                while(readfile.hasNextLine())
                {
                    readLines = readfile.nextLine();
                    break;               
                }                   
                while(readfile.hasNextLine())
                {
                    readLines = readfile.nextLine();
                    stringHolder = readLines.split(",");
                    while(stringHolder.length == 4)
                    {
                        Team newTeam = new Team(stringHolder[0], stringHolder[1], stringHolder[2], stringHolder[3]);
                        Teams.add(newTeam); 
                        break;                         
                    }
                }
                readfile.close();  
            }
            catch(FileNotFoundException notFound)
            {
                System.out.println(teamLoad[0] + " file not found!");
            } 
        }
        public void best_coach(String[] coachBest)
        {
            int totalWin = 0;
            int winMatches = 0;     
            for(i = 0; i < Coaches.size(); ++i)
            {
                Coach coaches = Coaches.get(i);      
                while(coaches.Season() == Integer.parseInt(coachBest[0]))
                {     
                    winMatches = (coaches.SeasonWin() - coaches.SeasonLoss()) + (coaches.PlayoffWin() - coaches.PlayoffLoss());                  
                        while(winMatches > totalWin)
                        {
                            totalWin = winMatches;
                            break;
                        }
                        break;
                }
            }
         
            for(j = 0; j < Coaches.size(); ++j)
            {
                Coach coaches = Coaches.get(j);                       
                while(coaches.Season() == Integer.parseInt(coachBest[0]))
                {
                    winMatches = (coaches.SeasonWin() - coaches.SeasonLoss()) + (coaches.PlayoffWin() - coaches.PlayoffLoss());                      
                    while(winMatches == totalWin)
                    {    
                        System.out.println(coaches.FirstName() + " " + coaches.LastName());
                        break;
                    }
                    break;
                }
            }
        }
        public void search_coach(String[] coachSearch)
        {
            String[] separateString = coachSearch[0].split("=");
            String first = separateString[0], second = separateString[1];
                     
            for(i = 0; i < Coaches.size(); ++i)
            {   
                    Coach newCoach = Coaches.get(i);                  
                    if(first.equalsIgnoreCase("coach_id"))
                    {
                        if(second.equalsIgnoreCase(newCoach.CoachID()))
                        {
                            System.out.println(newCoach.CoachID()
                            + " "
                            + newCoach.Season()
                            + " "
                            + newCoach.FirstName() 
                            + " " 
                            + newCoach.LastName()
                            + " "
                            + newCoach.SeasonWin()
                            + " "
                            + newCoach.SeasonLoss()
                            + " "
                            + newCoach.PlayoffWin()
                            + " "
                            + newCoach.PlayoffLoss()
                            + " "
                            + newCoach.TeamName());
                            break;
                        }                         
                    }
                    else if(first.equalsIgnoreCase("year"))
                    {
                        if(Integer.parseInt(second) == newCoach.Season())
                        {
                            System.out.println(newCoach.Season()
                            + " "
                            + newCoach.CoachID()
                            + " "
                            + newCoach.FirstName() 
                            + " " 
                            + newCoach.LastName()
                            + " "
                            + newCoach.SeasonWin()
                            + " "
                            + newCoach.SeasonLoss()
                            + " "
                            + newCoach.PlayoffWin()
                            + " "
                            + newCoach.PlayoffLoss()
                            + " "
                            + newCoach.TeamName());
                            break;
                        }
                    }                                               
                    else if(first.equalsIgnoreCase("first_name"))
                    {
                        if(second.equalsIgnoreCase(newCoach.FirstName()))
                        {
                            System.out.println(newCoach.FirstName() 
                            + " "
                            + newCoach.CoachID()
                            + " "
                            + newCoach.Season()
                            + " "
                            + newCoach.LastName()
                            + " "
                            + newCoach.SeasonWin()
                            + " "
                            + newCoach.SeasonLoss()
                            + " "
                            + newCoach.PlayoffWin()
                            + " "
                            + newCoach.PlayoffLoss()
                            + " "
                            + newCoach.TeamName());
                            break;
                        }                       
                    }                      
                    else if(first.equalsIgnoreCase("last_name"))
                    {
                        if(second.equalsIgnoreCase(newCoach.LastName()))
                        {
                            System.out.println(newCoach.LastName()
                            + " "
                            + newCoach.CoachID()
                            + " "
                            + newCoach.Season()
                            + " "
                            + newCoach.FirstName()
                            + " " 
                            + newCoach.SeasonWin()
                            + " "
                            + newCoach.SeasonLoss()
                            + " "
                            + newCoach.PlayoffWin()
                            + " "
                            + newCoach.PlayoffLoss()
                            + " "
                            + newCoach.TeamName());
                            break;
                        }                      
                    }
                    else if(first.equalsIgnoreCase("season_win"))
                    {
                        if(Integer.parseInt(second) == newCoach.SeasonWin())
                        {
                            System.out.println(newCoach.SeasonWin()
                            + " "
                            + newCoach.CoachID()
                            + " "
                            + newCoach.Season()
                            + " "
                            + newCoach.FirstName() 
                            + " " 
                            + newCoach.LastName()
                            + " "
                            + newCoach.SeasonLoss()
                            + " "
                            + newCoach.PlayoffWin()
                            + " "
                            + newCoach.PlayoffLoss()
                            + " "
                            + newCoach.TeamName());
                            break;
                        }                   
                    }                        
                    else if(first.equalsIgnoreCase("season_loss"))
                    {
                        if(Integer.parseInt(second) == newCoach.SeasonLoss())
                        {
                            System.out.println(newCoach.SeasonLoss()
                            + " "
                            + newCoach.CoachID()
                            + " "
                            + newCoach.Season()
                            + " "
                            + newCoach.FirstName() 
                            + " " 
                            + newCoach.LastName()
                            + " "
                            + newCoach.SeasonWin()
                            + " "
                            + newCoach.PlayoffWin()
                            + " "
                            + newCoach.PlayoffLoss()
                            + " "
                            + newCoach.TeamName());
                            break;
                        }                       
                    }
                    else if(first.equalsIgnoreCase("playoff_win"))
                    {
                        if(Integer.parseInt(second) == newCoach.PlayoffWin())
                        {
                            System.out.println(newCoach.PlayoffWin()
                            + " "
                            + newCoach.CoachID()
                            + " "
                            + newCoach.Season()
                            + " "
                            + newCoach.FirstName() 
                            + " " 
                            + newCoach.LastName()
                            + " "
                            + newCoach.SeasonWin()
                            + " "
                            + newCoach.SeasonLoss()
                            + " "
                            + newCoach.PlayoffWin()
                            + " "
                            + newCoach.PlayoffLoss()
                            + " "
                            + newCoach.TeamName());
                            break;
                        }                        
                    }
                    else if(first.equalsIgnoreCase("playoff_loss"))
                    {
                        if(Integer.parseInt(second) == newCoach.PlayoffLoss())
                        {
                            System.out.println(newCoach.PlayoffLoss()
                            + " "
                            + newCoach.CoachID()
                            + " "
                            + newCoach.Season()
                            + " "
                            + newCoach.FirstName() 
                            + " " 
                            + newCoach.LastName()
                            + " "
                            + newCoach.SeasonWin()
                            + " "
                            + newCoach.SeasonLoss()
                            + " "
                            + newCoach.PlayoffWin()
                            + " "
                            + newCoach.TeamName());
                            break;
                        }
                    }
                    else if(first.equalsIgnoreCase("team"))
                    {
                        if(second.equalsIgnoreCase(newCoach.TeamName()))
                        {
                            System.out.println(newCoach.TeamName()
                            + " "
                            + newCoach.CoachID()
                            + " "
                            + newCoach.Season()
                            + " "
                            + newCoach.FirstName() 
                            + " " 
                            + newCoach.LastName()
                            + " "
                            + newCoach.SeasonWin()
                            + " "
                            + newCoach.SeasonLoss()
                            + " "
                            + newCoach.PlayoffWin()
                            + " "
                            + newCoach.PlayoffLoss());
                            break;
                        }                        
                    }    
            }
    }
            
    private boolean doHelp() 
    {
         System.out.println("add_coach ID SEASON FIRST_NAME LAST_NAME SEASON_WIN "); 
	      System.out.println("SEASON_LOSS PLAYOFF_WIN PLAYOFF_LOSS TEAM - add new coach data");
         System.out.println("add_team ID LOCATION NAME LEAGUE - add a new team");
         System.out.println("print_coaches - print a listing of all coaches");
         System.out.println("print_teams - print a listing of all teams");
         System.out.println("coaches_by_name NAME - list info of coaches with the specified name");
         System.out.println("teams_by_city CITY - list the teams in the specified city");
	      System.out.println("load_coach FILENAME - bulk load of coach info from a file");
         System.out.println("load_team FILENAME - bulk load of team info from a file");
         System.out.println("best_coach SEASON - print the name of the coach with the most netwins in a specified season");
         System.out.println("search_coaches field=VALUE - print the name of the coach satisfying the specified conditions");
		   System.out.println("exit - quit the program");        
         return true;
    }
    
    public static void main(String[] args) 
    {
        new P1().run();
    }    
}
