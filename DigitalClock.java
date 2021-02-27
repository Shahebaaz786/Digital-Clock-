import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;
public class DigitalClock extends Applet implements Runnable
{
Thread t=null;
int hours=0,minutes=0,seconds=0;
String timeString=" ";
public void init()
{
setBackground(Color.RED);
}
public void start()
{
t=new Thread(this);
t.start();
}
public void run()
{
try
{
while(true)
{
Calendar cal=Calendar.getInstance();
hours=cal.get(Calendar.HOUR_OF_DAY);
if(hours>12)hours-=12;
minutes=cal.get(Calendar.MINUTE);
seconds=cal.get(Calendar.SECOND);
SimpleDateFormat formatter=new SimpleDateFormat("hh:mm:ss");
Date date=cal.getTime();
timeString=formatter.format(date);
repaint();
t.sleep(1000);  
}
}
catch(Exception e)
{
System.out.println(e);
}
}

public void paint(Graphics g)
{
g.setColor(Color.PINK);
g.drawString(timeString,250,250);
}
}
/*
<applet code="DigitalClock" width=500 height=500>
</applet>

*/
