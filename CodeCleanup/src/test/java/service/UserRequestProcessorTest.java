package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import techverito.application.InputReader;
import techverito.constants.Messages;
import techverito.model.User;
import techverito.service.UserRequestProcessor;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserRequestProcessorTest {

    UserRequestProcessor processor;

    User user = null;

    @BeforeEach
    void setup() {
        user = new User();
    }


    @Test
    public void processSelection1Test() {
        processor = new UserRequestProcessor(mock(InputReader.class));
        processor.processSelection1(user);
        assertEquals(Messages.notSubscribed, user.getSubcription());
    }

    @Test
    public void processSelection2Test() {
        String balance = user.getBalance();
        InputReader readerMock = mock(InputReader.class);
        when(readerMock.getInput()).thenReturn("100.0f");
        processor = new UserRequestProcessor(readerMock);
        processor.processSelection2(user);
        assertNotEquals(balance, user.getBalance());
    }

    @Test
    public void processSelection3Test() {
        processor = new UserRequestProcessor(mock(InputReader.class));
        processor.processSelection3(user);
    }

    @Test
    public void processSelection4Test() {
        user.setBalance(1000);
        InputReader readerMock = mock(InputReader.class);
        when(readerMock.getInput()).thenReturn("G", "3");

        processor = new UserRequestProcessor(readerMock);
        processor.processSelection4(user);
        assertEquals("730.0", user.getBalance());
    }

    @Test
    public void processSelection4Test1() {
        user.setBalance(100);
        InputReader readerMock = mock(InputReader.class);
        when(readerMock.getInput()).thenReturn("G", "3");

        processor = new UserRequestProcessor(readerMock);
        processor.processSelection4(user);

        //TODO: test insufficient balance message
        assertEquals("100.0", user.getBalance());
    }

    @Test
    public void processSelection4Test2() {
        user.setBalance(1000);
        InputReader readerMock = mock(InputReader.class);
        when(readerMock.getInput()).thenReturn("S", "3");

        processor = new UserRequestProcessor(readerMock);
        processor.processSelection4(user);
        assertEquals("865.0", user.getBalance());
    }

    @Test
    public void processSelection5Test() {
        user.setBalance(1000);
        InputReader readerMock = mock(InputReader.class);
        when(readerMock.getChannelsInput()).thenReturn(Arrays.asList("Zee", "Sony"));
        String balance = user.getBalance();

        processor = new UserRequestProcessor(readerMock);
        processor.processSelection5(user);
        assertNotEquals(balance, user.getBalance());
    }

    @Test
    public void processSelection6Test() {
        String email = user.getEmail();
        String phone = user.getPhone();
        InputReader readerMock = mock(InputReader.class);
        when(readerMock.getInput()).thenReturn("test@gmail.com", "1234567890");

        processor = new UserRequestProcessor(readerMock);
        processor.processSelection6(user);

        assertNotEquals(email, user.getEmail());
        assertNotEquals(phone, user.getPhone());

    }
}
