package display;

import java.awt.Color;
import java.awt.Graphics;

import platform.Agent;


/**
 * A panel to display the agent's point of view
 * @author simon
 *
 */
public class ProbePanel extends EnvPanel{

	private static final long serialVersionUID = 1L;
	
	public ProbePanel(Agent a){
		super(a);
	}
	
	public void paintComponent(Graphics g){
		
		// draw background
		g.setColor(Color.blue);
		g.fillRect(0, 0, 720, 100);
		g.setColor(Color.orange);
		g.fillRect(0,100, 720, 100);
		
		// draw visual features
		for (int i=0;i<360;i++){
			double d=100/ (Math.max(0.1,agent.body.probe1.distRetina[i]/10.));
			g.setColor(agent.body.probe1.colRetina[i]);
			g.fillRect(i*2, (int)( 100- d/2 ), 2, (int)(d));
		}
		
		// draw corners
		g.setColor(Color.black);
		for (int i=0;i<360;i++){
			double d=100/ (Math.max(0.1,agent.body.probe1.distRetina[i]/10.));
			if (agent.body.probe1.corner[i]==1) g.drawLine(i*2,(int)( 100- d/2 ), i*2, 198-(int)( 100- d/2 ));
			if (agent.body.probe1.corner[i]==2) g.drawLine(i*2,(int)( 100- d/2 ), i*2, 198-(int)( 100- d/2 ));
		}
		
		g.setColor(Color.red);
		for (int i=0;i<agent.hippocampus.pointList.size();i++){
			double d=100/ (Math.max(0.1,agent.hippocampus.pointList.get(i).distance));
			int theta=(int) agent.hippocampus.pointList.get(i).angle;
			g.fillRect(theta*2, (int)( 100- d/2 ), 2, (int)(d));
		}
		
		/*g.setColor(Color.red);
		for (int i=0;i<360;i++){
			double m=0;
			for (int a=0;a<20;a++){
				m+=agent.body.probe1.distRetina[(i+a)%360];
			}
			m=m/20;
			g.fillRect(((i+10)*2)%720, (int)( 100- m/2 ), 1, (int)(m));
		}*/
	}
}
