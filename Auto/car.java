public /*abstract*/ class car
{
    public double speed;
    public double maxSpeed;
    public boolean motor;
    public String name;
    public double price;
    public boolean quality;
    public String colour;
    
    public car(double SetMaxspeed, String setName, boolean qualityIsGood, double Price, String color){
        speed = 0; 
        maxSpeed = SetMaxspeed;
        motor = false;
        name = setName;
        price = Price;
        quality = qualityIsGood;
        colour = color;
        
        checkQuality(price, quality);
        /*if (price > 10000 & quality == false) {
            System.out.println(" Very bad deal!");
        }
        else  if (price > 100000 | quality == false) {
            System.out.println(" Bad deal!");
        }
        else {
            System.out.println(" Good deal!");
        }*/
        
    }  
    public void checkQuality(double price,boolean quality) {
        System.out.print("You've buyed a new car: " + name + "!");
        
        if (price > 10000 & quality == false) {
            System.out.println(" Very bad deal!");
        }
        else  if (price > 100000 | quality == false) {
            System.out.println(" Bad deal!");
        }
        else {
            System.out.println(" Good deal!");
        }
    }
    /*public void turnMotorOn() {
        if (motor == false) {
            motor = true;
            System.out.println(name + ": Motor is now on");
        }
        else {
            System.out.println(name + ": Motor is allready on!");
        }
    }*/
    private void turnMotorOff() {
        if (motor == true) {
            motor = false;
            speed = 0;
            System.out.println(name + ": Motor is now off");
        }
        else {
            System.out.println(name + ": Motor is allready off!");
        }
    }
    public void switchMotor() {
        if (motor == true) {
            motor = false;
            speed = 0;
            System.out.println(name + ": Motor is now off");
        }
        else {
            motor = true;
            System.out.println(name + ": Motor is now on");
        }
    }
    
    public void speedUpDown(double acctualSpeed) {
        if (acctualSpeed < 0) {
            acctualSpeed *= -1;
        }
        if (motor == true){
            if (acctualSpeed > maxSpeed) {
                System.out.println(name + ": Error: Speed " + acctualSpeed + " to high! MaxSpeed = " + maxSpeed + "!");
            }
            else {
                speed = acctualSpeed;
                System.out.println(name + ": Akktuelles Tempo: " + speed + ". maxSpeed = " + maxSpeed + ".");
            }
        }
        else {
            System.out.println(name + ": Error: Motor is not on!");
        }
    }
    
    public void fromSpeedUpDown(double additionalSpeed) {
        if (motor == true){
            double acctualSpeed = speed + additionalSpeed;
            if (acctualSpeed > maxSpeed) {
                System.out.println(name + ": Error: Speed " + acctualSpeed + " to high! MaxSpeed = " + maxSpeed + "!");
                turnMotorOff();
            }
            else {
                speed = acctualSpeed;
                System.out.println(name + ": Akktuelles Tempo: " + speed + ". maxSpeed = " + maxSpeed + ".");
            }
        }
        else {
            System.out.println(name + ": Error: Motor is not on!");
        }
        if (speed < 0) {
            speed = 0;
        }
    }
}
