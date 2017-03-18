/**
 * StaticvariableResetter
 * 
 * Clasa care reseteaza valorile statice folosite in joc atunci cand este necesar.
 * De exemplu, la trecerea intr-un mod de joc nou.
 */
public class StaticVariableResetter  
{
    public static void resetMenuVariables()
    {
        //resetat variabile ce tin de meniu
        MenuWorld.gamemode=-1;
        MenuWorld.isPlaying=false;    
        MenuWorld.tutorialShown=false;
        MenuWorld.scoreWindowShown=false;
        MenuWorld.shouldResetText=false;        
        Start.lang=-1;  
        Start.hasBeenAnimated=false;      
        MuteButton.mute = false;
    }
    public static void resetPMVariables()
    {
        //resetat variabile ce tin de modul puzzle
        Player.canMove=true;
        MenuWorld.isPlaying=false;            
        FOV.SwitchImage=false;        
        PMworld.shouldShowVictoryWindow=false;
        PMworld.VictoryWindowShown=false;      
        for(int i=0;i<4;i++)
            ItemCounter.gems_taken[i]=0;
        ItemCounter.pillTimer=300;
        ItemCounter.shouldCountdownPill=false;   
        PMworld.shouldSwitchWorld=false;
        MenuWorld.gamemode=-1;
    }
    public static void resetTAVariables()
    {
        //resetat variabile ce tin de modul contra timp
        Player.canMove=true;
        MenuWorld.isPlaying=false;    
        ItemCounter.pillTimer=300;
        ItemCounter.shouldCountdownPill=false;
        FOV.SwitchImage=false;
        TAworld.shouldRegen=false;
        TAworld.remainingTime=7800; 
        TAworld.victoryWindowShown=false;
        TAworld.shouldSwitchWorld=false;
        MenuWorld.gamemode=-1;        
    }
    
}
