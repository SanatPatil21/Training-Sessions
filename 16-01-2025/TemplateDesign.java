public class TemplateDesign {
    
}

abstract class Sports{
    protected abstract void toss();
    protected abstract void start();
    protected abstract void interval();
    protected abstract void resume();
    protected abstract void finish();
    protected abstract void results();

    public static void play(){
        toss();
        start();
        Interval();
        resume();
        finish();
        results();
    }
}


class Cricket extends Sports{
    public void toss(){
        System.out.println("Cricket ka toss");
    };
    protected void start(){
        System.out.println("Cricket ki shurwat");


    };
    protected void interval(){
        System.out.println("Cricket ka innings break");
      
    };
    protected void resume(){
        System.out.println("Dusri team ki batting");
    };
    protected void finish(){
        System.out.println("Overs Khatam");
    };
        
    protected void results(){
        System.out.println("Thala for a reason");
    };

}
