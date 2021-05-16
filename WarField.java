package HW6;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class WarField extends GameObject {

	ArrayList<Tank> enemyTanks = new ArrayList<Tank>();
	ArrayList<Missile> enemyMissiles = new ArrayList<Missile>();
	Tank ourTank;
	Missile ourMissiles ;
	//ArrayList<Missile> deadMissiles = new ArrayList<Missile>();
	int numberOfEnemyTanks = 0;
	
	public int getNumberOfEnemyTanks() {
		return numberOfEnemyTanks;
	}
	public void setNumberOfEnemyTanks(int numberOfEnemyTanks) {
		this.numberOfEnemyTanks = numberOfEnemyTanks;
	}
	public void restart() {
		//reset our tank position if necessary
		//this.ourTank.setX(50);
		//this.ourTank.setY(250);
                this.setNumberOfEnemyTanks(52);
                ourTank = new Tank(this, 325, 600, 60, 5, Color.RED);
		for(Tank t:enemyTanks){
                    t.setLive(true);
                }
                ourMissiles = new Missile(350,580,15,15,Color.BLACK);
		
	}
	public ArrayList<Tank> getEnemyTanks() {
		return enemyTanks;
	}

	public void setEnemyTanks(ArrayList<Tank> enemyTanks) {
		this.enemyTanks = enemyTanks;
	}

	public ArrayList<Missile> getEnemyMissiles() {
		return enemyMissiles;
	}

	public void setEnemyMissiles(ArrayList<Missile> enemyMissiles) {
		this.enemyMissiles = enemyMissiles;
	}

	/*public WarField() {
		this.setBackground(Color.GREEN);
		// TODO Auto-generated constructor stub
		ourTank = new Tank(this, 50, 350, 30, 30, Color.RED);
		for (int i = 0; i < 10; i++)
			this.enemyTanks.add(new Tank(this, 650, 30 + i * 50, 30, 30,
					Color.BLUE));
	}*/

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 */
	public WarField(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		// TODO Auto-generated constructor stub
		//this.setBackground(Color.GREEN);
		ourTank = new Tank(this, 325, 600, 60, 5, Color.RED);
                for(int a=0;a<4;a++){
                    for (int i = 0; i < 13; i++) {
                            this.enemyTanks.add(new EnemyTank(this, 50 + i*50 , 50 + a * 50, 40, 30,
                                            Color.WHITE));
                    }
                }
                ourMissiles = new Missile(350,580,15,15,Color.BLACK);
	}



	@Override
	void draw(Graphics g) {
		ourTank.draw(g);

		
		ourMissiles.draw(g);
		
		this.setNumberOfEnemyTanks(0);
		for (Tank enemyTank : this.enemyTanks) {
			if (enemyTank.isLive()) {
				enemyTank.draw(g);
				numberOfEnemyTanks++;
			}
		}
		
		//g.drawString("Number of Enemy Tanks left:"+numberOfEnemyTanks, 600, 20);
                
                ourMissiles.move();
		ourMissiles.moveBall();
                
                if(ourMissiles.getX()>=800||ourMissiles.getX()<=0){
                    ourMissiles.setDeltaX(ourMissiles.getDeltaX()*-1);
                }
                if(ourMissiles.getY()<=0){
                    ourMissiles.setDeltaY(ourMissiles.getDeltaY()*-1);
                }
                if(ourMissiles.getY()>=600){
                    System.out.println("game over");
                    g.drawString("Game Over", 400, 300);
                    TankWar.setStartWarGame(false);
                }
                
                if(ourMissiles.hitTank(ourTank)){
                    ourMissiles.setDeltaY(ourMissiles.getDeltaY()*-1);
                }
		for (Missile enemyMissile : this.enemyMissiles) {
			enemyMissile.draw(g);
			if (enemyMissile.hitTank(ourTank)) {
				System.out.println("game over");
				g.drawString("Game Over", 400, 300);
				TankWar.setStartWarGame(false);
			}
                        
		}

		
			for (Tank enemyTank : this.enemyTanks) {
				if (enemyTank.isLive())
					ourMissiles.hitTank(enemyTank);
			}
		

		

	}

	

	

	

	public Tank getOurTank() {
		return ourTank;
	}

	public void setOurTank(Tank ourTank) {
		this.ourTank = ourTank;
	}

	public void processKeyPressed(KeyEvent e) {
		ourTank.processKeyPressed(e);

	}

}
