package mainGame.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import mainGame.Game.STATE;
import mainGame.spawn.*;
import mainGame.*;
import mainGame.gfx.*;

/**
 * The main menu
 * 
 * @author Brandon Loehle 5/30/16
 *
 */

public class Menu {

	private Game game;
	private Handler handler;
	private HUD hud;
	private Image img;
	private Image img2;
	private Image willpic;
	private Image juliopic;
	private Image mattpic;
	private Image kylepic;
	private Image eamonpic;
	private Image hoffmanpic;
	private int timer;
	private Random r;
	private ArrayList<Color> colorPick = new ArrayList<Color>();
	private int colorIndex;
	private Spawn1to5 spawner;


	public Menu(Game game, Handler handler, HUD hud, Spawn1to5 spawner) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		this.spawner = spawner;
		timer = 10;
		r = new Random();
		img = null;
		img2 = null;

		try {
			URL imageURL = Game.class.getResource("images/dust-particles.png");
			img = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			URL imageURL = Game.class.getResource("images/paintbucket.png");
			img2 = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void tick() {
		timer--;
		if (timer <= 0) {
			handler.object.clear();
			colorIndex = r.nextInt(6);
			timer = 300;
		}
		handler.tick();
	}

	public void render(Graphics g) {
		if (game.gameState == STATE.Menu) {
			g.drawImage(img, 0, 0, Game.WIDTH, Game.HEIGHT, null);
			g.drawImage(img2, 850, 450, 100, 100, null);
			handler.render(g);
			
			Button b1 = new Button(50, 150, 350, 100);
			b1.setText("Waves");
			Button b2 = new Button(50, 300, 350, 100);
			b2.setText("Bosses");
			Button b3 = new Button(50, 450, 350, 100);
			b3.setText("Survival");
			Button b4 = new Button(450, 150, 350, 100);
			b4.setText("Credits");
			Button b5 = new Button(450, 300, 350, 100);
			b5.setText("Help");
			Button b6 = new Button(450, 450, 350, 100);
			b6.setText("Quit");
			Button b7 = new Button(850, 150, 350, 100);
			b7.setText("Host");
			Button b8 = new Button(850, 300, 350, 100);
			b8.setText("Join");
			
			Font font = new Font("Amoebic", 1, 80);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("Unknown Battleland", 200, 100);
			
			b1.render(g);
			b2.render(g);
			b3.render(g);
			b4.render(g);
			b5.render(g);
			b6.render(g);
			b7.render(g);
			b8.render(g);
		} else if (game.gameState == STATE.Help) {// if the user clicks on
			// "help"
			g.drawImage(img, 0, 0, Game.WIDTH, Game.HEIGHT, null);
			handler.render(g);

			img = null;

			try {
				URL imageURL = Game.class.getResource("images/dust-particles.png");
				img = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Font font = new Font("impact", 1, 33);
			Font font2 = new Font("impact", 1, 20);

			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("Help", 600, 46);

			g.drawString("To move the player you use either the arrow keys or the WASD keys.", 100, 100);
			g.setFont(font);
			g.drawString("Waves:", 100, 160);
			g.setFont(font2);
			g.drawString(" In this mode, your goal is to avoid enemies in order to advance levels, every 5th level you will encounter a boss, and ",
					100, 190);
			g.drawString(" exactly as the normal levels your goal is to avoid being hit by a boss for a certain period of time to advance a",
					100, 220);
			 g.drawString(" level. Upgrades obtained after completing a boss level can be used by pressing the shift key", 100, 250);
			g.setFont(font);
			g.drawString("Bosses:", 100, 320);
			g.setFont(font2);
			g.drawString(" Within Bosses, your goal is similar to Waves but instead of having bosses every 5th level, every level will be a boss.",
					100, 350);
			g.drawString(" There is an unlimited ammount of bosses so your objective is to obtain the highest score by surviving the longest.", 100, 380);
			g.setFont(font);
			g.drawString("Survival:", 100, 450);
			g.setFont(font2);
			g.drawString(" Within Survival, your goal is to survive as long as possible while enemies spawn and try to kill you. Poewr-ups are available",
					100, 480);
			g.drawString(" to help you stay alive. If you pick up a ham, you regain health, if you pick up shoes, you earn a light speed boost and if you ",
					100, 510);
			g.drawString("pick up a coin, you earn \"add 1000\" points to your score.", 100, 540);
			g.drawString("To mute the sound in game press the m key" , 100, 590);
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawRect(566, 590, 133, 42);
			g.drawString("Back", 613, 620);
		}
		else if (game.gameState == STATE.Credits) {
			
			g.drawImage(img, 0, 0, Game.WIDTH, Game.HEIGHT, null);
			g.drawImage(mattpic, 0, 0, 426 , 360, null);
			g.drawImage(willpic, 426, 0, 426 , 360, null);
			g.drawImage(juliopic, 852, 0, 426 , 360, null);
			g.drawImage(kylepic, 0, 360, 426 , 360, null);
			g.drawImage(eamonpic, 426, 360, 426 , 360, null);
			g.drawImage(hoffmanpic, 852, 360, 426 , 360, null);
			handler.render(g);

			img = null;
			willpic = null;
			juliopic = null;
			mattpic = null;
			kylepic = null;
			eamonpic = null;
			hoffmanpic = null;

			try {
				URL imageURL = Game.class.getResource("images/dust-particles.png");
				img = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				URL imageURL = Game.class.getResource("images/willpic.jpg");
				willpic = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				URL imageURL = Game.class.getResource("images/juliopic.jpg");
				juliopic = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				URL imageURL = Game.class.getResource("images/hoffmanpic.jpg");
				hoffmanpic = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				URL imageURL = Game.class.getResource("images/mattpic.jpg");
				mattpic = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				URL imageURL = Game.class.getResource("images/kylepic.jpg");
				kylepic = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				URL imageURL = Game.class.getResource("images/eamonpic.jpg");
				eamonpic = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Font font = new Font("impact", 1, 33);
			Font font2 = new Font("impact", 1, 20);

			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("Credits", 575, 46);

			g.drawString("Team A1 - Can be found spending their $50 Amazon giftcards online.", 150, 100);
			g.setFont(font);
			g.drawString("Team Members:", 100, 160);
			g.setFont(font2);
			g.drawString(
					"Matt \"Scrub Daddy\" Chieco - \"I'm at the tippidy top of the mountain and im only half way up, think about it.\"",
					100, 190);
			g.drawString("Can be found benching at the gym.",
					100, 220);
			g.drawString("Will \"Head Developer\" Eccles - Drinks a refreshing Mtn Dew every class.", 100, 275);
			g.drawString("Can be found where ever cacti are located.", 100, 305);
			
			g.drawString("Julio \"Pause Menu\" Argueta - He hates olives.", 100, 360);
			g.drawString("Can be found playing Super Smash Bros.", 100, 390);
			
			g.drawString("Kyle \"Mouse Listner\" Gorman - Likes long walks on the beach, pina coladas and gettin caught in the rain.", 100, 445);
			g.drawString("Can be found climbing some kind of wall.", 100, 475);
			
			g.drawString("Eamon \"HTML\" Duffy - Is up to date on One Piece", 100, 530);
			g.drawString("Can be found on Instagram @eamon_duffy.", 100, 560);
			
			g.drawString("Professor \"Manager of the Best Team\" Hoffman - \"I LOVE CHARTS AND TABLES!!\"", 100, 615);
			g.drawString("Can be found stealing team A1's $50 giftcards.", 100, 640);
			
			
			
			g.setColor(Color.white);
			g.drawRect(566, 650, 133, 42);
			g.drawString("Back", 613, 680);
		}
	}
}
