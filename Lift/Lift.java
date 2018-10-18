public class Lift
{
    boolean doorOpen;
    int maxStorys;
    int minStorys;
    int maxPersons;
    int aktualStory;
    int speed;
    int aktualPersons;
    
    public Lift(int MaxPersons, int MaxStorys, int MinStorys, int Speed)
    {
        System.out.print('\u000C');
       if (MaxStorys == MinStorys)
       {
           MinStorys *= -1;
           System.out.println("Corrected Impossible Number!");
       }
       if (MaxStorys < MinStorys)
       {
           maxStorys = MinStorys;
           minStorys = MaxStorys;
           System.out.println("Corrected Impossible Number!");
       }
       else 
       {
           maxStorys = MaxStorys;
           minStorys = MinStorys;
           System.out.println("Corrected Impossible Number!");
       }
       if (Speed < 0)
       {
           Speed *= -1;
           System.out.println("Corrected Impossible Number!");
        }
        if (MaxPersons < 0)
       {
           MaxPersons *= -1;
           System.out.println("Corrected Impossible Number!");
        }
       doorOpen = false;
       
       maxPersons = MaxPersons;
       aktualPersons = 0;
       aktualStory = MinStorys;
       speed = Speed;
       System.out.println("Congeratulations: You've build a new lift!");
    }
    
    private void toggleDoor(){
        System.out.print('\u000C');
        doorOpen = !doorOpen;
        if (doorOpen)
        {
            System.out.println("Door opened.");
        }
        else
        {
            System.out.println("Door closed.");
        }
        //Delay
                try {
                    Thread.sleep(750);
                } catch (InterruptedException ex) {
                    // handle error
                }
    }
    
    private void driveTo(int Story)
    {
        if (doorOpen)
        {
            toggleDoor();
        }
        if (Story < minStorys | Story > maxStorys)
        {
            System.out.print('\u000C');
            System.out.println("Impossible Number!");
        }
        else 
        {
            if (Story > aktualStory)
            {
                //Forschleife Funktionalisieren
                while (!(aktualStory == Story))
                {
                    aktualStory ++;
                    System.out.print('\u000C');
                    System.out.println(aktualStory);
                    //Delay
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        // handle error
                    }
                }
            }
            if (Story < aktualStory)
            {
                //Forschleife Funktionalisieren
                while (!(aktualStory == Story))
                {
                    aktualStory --;
                    System.out.print('\u000C');
                    System.out.println(aktualStory);
                    //Delay
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        // handle error
                    }
                }
            }
            System.out.print('\u000C');
            System.out.println("Ping! New Story: " + aktualStory);
        }
    }
    
    void gettingIn(int Persons, int Story)
    {
        System.out.print('\u000C');
        if (!(Story == aktualStory))
        {
            driveTo(Story);
        }
        if (!doorOpen)
        {
            toggleDoor();
        }
        if (aktualPersons+Persons > maxPersons | Persons <= 0)
        {
            System.out.println("Impossible Number!");
        }
        else
        {
            aktualPersons += Persons;
            System.out.println("new Person Number: " + aktualPersons);
             try {
                    Thread.sleep(750);
                } catch (InterruptedException ex) {
                    // handle error
                }
        }
    }
    
    void gettingOut(int Persons, int Story)
    {
        System.out.print('\u000C');
        if (!(Story == aktualStory))
        {
            driveTo(Story);
        }
        if (!doorOpen)
        {
            toggleDoor();
        }
        if (aktualPersons-Persons < 0 | Persons <= 0)
        {
            System.out.println("Impossible Number!");
        }
        else
        {
            aktualPersons -= Persons;
            System.out.println("new Person Number: " + aktualPersons);
        }
        try {
                    Thread.sleep(750);
                } catch (InterruptedException ex) {
                    // handle error
                }
    }
}
