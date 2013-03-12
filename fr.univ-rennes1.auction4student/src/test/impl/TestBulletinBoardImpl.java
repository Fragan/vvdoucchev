package test.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Message;
import auction.Moderator;
import auction.User;
import auction.impl.BulletinBoardImpl;
import auction.impl.MessageImpl;
import auction.impl.ModeratorImpl;

public class TestBulletinBoardImpl {

	private Message message;
	private BulletinBoardImpl bulletinBoard;
	private Moderator modo;
	private User user;

	@Before
	public void setUp() throws Exception {
		bulletinBoard = new BulletinBoardImpl();
		modo = new ModeratorImpl("firstNameModo", "lastNameModo", "emailModo",
				"passwordModo", "addressModo");
	}

	@After
	public void tearDown() throws Exception {
	}

	// Test : delMessage() : String [!(p instanceof Moderator)]
	@Test
	public void testDelMessage1() {
		message = new MessageImpl(bulletinBoard, modo, "monMessage");
		assertEquals(
				"Test : delMessage() : String [!(p instanceof Moderator)]",
				bulletinBoard.delMessage(user, 0),
				"ERROR: only moderators can delete a message");
	}

	// Test : delMessage() : String [num<1]
	@Test
	public void testDelMessage2() {
		message = new MessageImpl(bulletinBoard, modo, "monMessage");
		assertEquals("Test : delMessage() : String [num<1]",
				bulletinBoard.delMessage(modo, 0),
				"ERROR: this message does not exist");
	}

	// Test : delMessage() : String [num>messages.size()]
	@Test
	public void testDelMessage3() {
		message = new MessageImpl(bulletinBoard, modo, "monMessage");
		assertEquals("Test : delMessage() : String [num>messages.size()]",
				bulletinBoard.delMessage(modo, 2000),
				"ERROR: this message does not exist");
	}

	// Test : delMessage() : String
	@Test
	public void testDelMessage4() {
		message = new MessageImpl(bulletinBoard, modo, "monMessage");
		assertEquals("Test : delMessage() : String",
				bulletinBoard.delMessage(modo, 1), "OK");
	}

	// Test : getMess() : String [size<=0]
	@Test
	public void testGelMess1() {
		assertEquals("Test : getMess() : String [size<=0]",
				bulletinBoard.getMess(), "");
	}

	// Test : getMess() : String [size==1]
	@Test
	public void testGelMess2() {
		message = new MessageImpl(bulletinBoard, modo, "monMessage");
		assertEquals("Test : getMess() : String [size==1]",
				bulletinBoard.getMess(), "1 emailModo monMessage");
	}

	// Test : getMess() : String [size>1]
	@Test
	public void testGelMess3() {
		String messages = "";
		for (int i = 0; i < 10; i++) {
			message = new MessageImpl(bulletinBoard, modo, "monMessage" + i);

			// Construction de la chaine de caractere qui sera l'oracle du test  
			if (i == 0) {
				messages += Integer.toString(i + 1) + " emailModo monMessage" + i;
			} else {
				messages += System.getProperty("line.separator")
						+ Integer.toString(i + 1) + " emailModo monMessage" + i;
			}
		}

		assertEquals("Test : getMess() : String [size>1]",
				bulletinBoard.getMess(), messages);
	}

}
