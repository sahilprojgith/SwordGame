package Objorient;

class Samurai{
    private String name;
    private String weapon;
    private int health;

    public Samurai(String name, String weapon, int health){
        this.name = name;
        this.weapon = weapon;

        if(health < 0 || health > 100) {
            this.health = 100;
        }else {
            this.health=health;
        }
    }

    public void damageByKatana(){
        this.health -= 30;
        if(this.health<=0){
            this.health = 0;
        }
        System.out.println("Got hit by Katana ... Health is reduced by 30 " + getName() + " New health is " + this.health);
        if(this.health == 0){
            System.out.println(getName() + " is dead" );
        }
    }

    public void damagebyLeftHook(){
        this.health -= 40;
        if(this.health<=0){
            this.health = 0;
        }
        System.out.println("Got hit by Left Hook ... Health is reduced by 40 " + getName() + " New health is " + this.health);
        if(this.health == 0){
            System.out.println(getName() + " is dead" );
        }
    }

    public void heal() {
        if (this.health == 0) {
            System.out.println(getName() + " is dead, heal not possible");
        } else {
            this.health = 100;
            System.out.println(" New Health of "+ getName() + " is "+ this.health + " ,Used Samurai Heal .");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

class Poatan extends Samurai{

    private int health; // cause player 1 health is different , this health is separate fom player 1.
    private boolean ShamanicMagic;

    public Poatan(String name, String weapon, int health, boolean ShamanicMagic){
        super(name,weapon,health);
        this.health= health;
        this.ShamanicMagic = ShamanicMagic;
    }

    @Override
    public void damageByKatana(){
        if(ShamanicMagic){
            this.health-=10;
            if(this.health <=0) {
                this.health =0;
            }
            System.out.println("ShamanicMagic is on, Got hit by Katana " + " New health is " + this.health);
        }
        if(!ShamanicMagic){
            this.health-=30;
            if(this.health<=0){
                this.health=0;
            }
            System.out.println("ShamanicMagic is not on , Got hit by Katana" + " New Health is " + this.health);
        }
        if(this.health == 0){
            System.out.println(getName() + " is dead");
        }
    }


    @Override
    public void damagebyLeftHook(){
        if(ShamanicMagic){
            this.health-=20;
            if(this.health <=0) {
                this.health =0;
            }
            System.out.println("ShamanicMagic is on, Got hot by Talwar " + " New health is " + this.health);
        }
        if(!ShamanicMagic){
            this.health-=30;
            if(this.health<=0){
                this.health=0;
            }
            System.out.println("ShamanicMagic is not on , Got hit by Tawar" + " New Health is " + this.health);
        }
        if(this.health == 0){
            System.out.println(getName() + " is dead");
        }
    }

    @Override
    public void heal(){
        super.heal();
    }

}



public class SwordGame {
    public static void main(String[] args) {
        Samurai katana = new Samurai("Jiri prochazka","Samurai sword",100);
        katana.damageByKatana();
        katana.damagebyLeftHook();

        Poatan hook = new Poatan("Alex Pereira","Left Hook", 100,true);
        hook.damageByKatana();
        hook.heal();
        hook.damageByKatana();

    }
}
