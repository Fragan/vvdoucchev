package test.impl;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.Message;
import auction.Moderator;
import auction.impl.BulletinBoardImpl;
import auction.impl.MessageImpl;
import auction.impl.ModeratorImpl;

public class TestMessage {

	private BulletinBoardImpl bulletinBoardMock;
	private Moderator modo;
	private Message message;

	@Before
	public void setUp() throws Exception {
		bulletinBoardMock = EasyMock.createMock(BulletinBoardImpl.class);
		EasyMock.expect(bulletinBoardMock.getMessages()).andReturn(
				new java.util.ArrayList<MessageImpl>());
		EasyMock.replay(bulletinBoardMock);

		modo = new ModeratorImpl("firstName", "lastName", "emailDuModo", "password",
				"address");

		message = new MessageImpl(bulletinBoardMock, modo,
				"Ceci est le message");
	}

	@After
	public void tearDown() throws Exception {
		EasyMock.verify(bulletinBoardMock);
	}

	// Test : getBulletinBoard() : BulletinBoard
	@Test
	public void testGeBulletinBoard() {
		assertEquals("Test : getBulletinBoard() : BulletinBoard",
				message.getBulletinBoard(), bulletinBoardMock);
	}

	// Test : getAuthor() : Person
	@Test
	public void testGetAuthor() {
		assertEquals("Test : getAuthor() : Person", message.getAuthor(), modo);
	}
	
	// Test : getMessage() : String
	@Test
	public void testGetMessage() {
		assertEquals("Test : getMessage() : String", message.getMessage(), "Ceci est le message");
	}
	
	// Test : toString() : String
	@Test
	public void testGetToString() {
		assertEquals("Test : toString() : String", message.toString(), "emailDuModo Ceci est le message");
	}

}
